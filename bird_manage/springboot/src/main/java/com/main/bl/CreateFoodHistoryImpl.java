package main.java.com.main.bl;

import main.java.com.main.entity.foodHistoryTbl;
import main.java.com.main.dao.foodDao;
import com.main.api.CreateFoodHistoryRequest;
import com.main.api.CreateFoodHistoryResponse;
import com.main.api.CreateFoodHistoryGrpc;
import io.grpc.stub.StreamObserver;

import java.time.LocalDateTime;

import net.devh.boot.grpc.server.service.GrpcService;

/**
 * @author: zongcan.li
 * @create: 2024/03/30
 */


 @GrpcService
 public class CreateFoodHistoryImpl extends CreateFoodHistoryGrpc.CreateFoodHistoryImplBase{

    
    private foodDao fDI;

    public CreateFoodHistoryImpl(foodDao a) {
        this.fDI = a;
    }
    
    
    @Override
    public void createFood(CreateFoodHistoryRequest request, StreamObserver<CreateFoodHistoryResponse> responseObserver) {
        CreateFoodHistoryResponse rpcResponse = null;
        LocalDateTime localDateTime = LocalDateTime.now();
        foodHistoryTbl newRecord = new foodHistoryTbl();
        newRecord.timeStamp = localDateTime;
        newRecord.operator = request.getOperator();
        newRecord.category = request.getCategory();
        newRecord.portion = request.getPortion();
        this.fDI.save(newRecord);
        try {
            rpcResponse = CreateFoodHistoryResponse
                    .newBuilder()
                    .setMes( "this is a response" )
                    .build();
        } catch (Exception e) {
            responseObserver.onError(e);
        } finally {
            responseObserver.onNext( rpcResponse );
        }
        responseObserver.onCompleted();
    }
}