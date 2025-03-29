package br.com.souzadev.picpay_desafio.service;

import br.com.souzadev.picpay_desafio.database.model.Transactions;
import br.com.souzadev.picpay_desafio.database.model.Users;
import br.com.souzadev.picpay_desafio.database.repository.TransactionsRepository;
import br.com.souzadev.picpay_desafio.dto.TransferRequest;
import br.com.souzadev.picpay_desafio.dto.feign.AuthorizationResponse;
import br.com.souzadev.picpay_desafio.enums.ClientTypeEnum;
import br.com.souzadev.picpay_desafio.handler.exceptions.InsuficientBalanceException;
import br.com.souzadev.picpay_desafio.handler.exceptions.InvalidTransactionException;
import br.com.souzadev.picpay_desafio.handler.exceptions.NotAuthorizedTransactionException;
import br.com.souzadev.picpay_desafio.handler.exceptions.ShopkeeperException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransferService {

    private final TransactionsRepository transactionsRepository;
    private final UsersService usersService;
    private final FeignClientService feignClientService;

    @Transactional
    public void createTransfer(TransferRequest request) throws Exception{
        Users sender = usersService.findById(request.getPayer());
        Users receiver = usersService.findById(request.getPayee());

        if(sender.getType().name().equals(ClientTypeEnum.SHOPKEEPER.name()))
            throw new ShopkeeperException(sender.getId());

        if(sender.getBalance().compareTo(request.getValue()) < 0)
            throw new InsuficientBalanceException();

        if(sender.getId().equals(receiver.getId()))
            throw new InvalidTransactionException();

        AuthorizationResponse response = feignClientService.getAuthorization();
        if(!response.getData().getAuthorization())
            throw new NotAuthorizedTransactionException();

        sender.setBalance(sender.getBalance().subtract(request.getValue()));
        receiver.setBalance(receiver.getBalance().add(request.getValue()));

        usersService.save(sender);
        usersService.save(receiver);

        transactionsRepository.save(Transactions.builder()
                .sender(sender)
                .receiver(receiver)
                .transactionValue(request.getValue())
                .build());

        feignClientService.sendNotification();
    }
}
