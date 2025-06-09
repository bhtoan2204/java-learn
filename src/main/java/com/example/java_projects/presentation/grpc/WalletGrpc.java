package com.example.java_projects.presentation.grpc;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import com.example.java_projects.application.command.wallet.CreateWalletCommand;
import com.example.java_projects.proto.CreateWalletRequest;
import com.example.java_projects.proto.CreateWalletResponse;
import com.example.java_projects.proto.WalletServiceGrpc;

import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class WalletGrpc extends WalletServiceGrpc.WalletServiceImplBase {

    private final CommandGateway commandGateway;

    @Override
    public void createWallet(CreateWalletRequest request,
            StreamObserver<CreateWalletResponse> responseObserver) {

        String generatedString = java.util.UUID.randomUUID().toString();
        CreateWalletCommand createWalletCommand = CreateWalletCommand.builder()
                .walletId(generatedString)
                .ownerId(request.getOwnerId())
                .ownerType(request.getOwnerType())
                .currency(request.getCurrency())
                .build();

        try {
            commandGateway.sendAndWait(createWalletCommand);

            CreateWalletResponse response = CreateWalletResponse.newBuilder()
                    .setWalletId(generatedString)
                    .setOwnerId(request.getOwnerId())
                    .setOwnerType(request.getOwnerType())
                    .setCurrency(request.getCurrency())
                    .setBalance(0)
                    .setCreatedAt(String.valueOf(System.currentTimeMillis()))
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            log.error("Error creating wallet: {}", e.getMessage());
            responseObserver.onError(e);
        }
    }
}
