package main.java.com.main.bl;
import com.main.api.CreateFoodHistoryRequest;
import com.main.api.CreateFoodHistoryResponse;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import com.main.api.CreateFoodHistoryGrpc;

/**
 * @author: zongcan.li
 * @create: 2024/05/04
 */

public class MyGrpcClient {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
          .usePlaintext()
          .build();
  
        CreateFoodHistoryGrpc.CreateFoodHistoryBlockingStub stub =
            CreateFoodHistoryGrpc.newBlockingStub(channel);
  
      CreateFoodHistoryResponse createResponse = stub.createFood(
        CreateFoodHistoryRequest.newBuilder()
              .setCategory("Ray")
              .setPortion(18.0f)
              .setOperator("Li")
              .build());
  
      System.out.println(createResponse);
  
      channel.shutdown();
    }
  }
  