package com.example.java_projects.presentation.grpc;

import org.springframework.stereotype.Service;

import com.example.java_projects.proto.GetProductRequest;
import com.example.java_projects.proto.GetProductResponse;
import com.example.java_projects.proto.ListProductsRequest;
import com.example.java_projects.proto.ListProductsResponse;
import com.example.java_projects.proto.ProductServiceGrpc;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GrpcApp extends ProductServiceGrpc.ProductServiceImplBase {
  @Override
  public void getProduct(GetProductRequest request,
      StreamObserver<GetProductResponse> responseObserver) {
    GetProductResponse response = GetProductResponse.newBuilder().setDescription("").setName("").setProductId(0)
        .build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void listProducts(ListProductsRequest request,
      StreamObserver<ListProductsResponse> responseObserver) {
    GetProductResponse productResponse = GetProductResponse.newBuilder().setDescription("").setName("")
        .setProductId(0).build();
    ListProductsResponse response = ListProductsResponse.newBuilder()
        .addProducts(productResponse)
        .build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
