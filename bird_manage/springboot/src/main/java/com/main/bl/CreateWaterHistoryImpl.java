package main.java.com.main.bl;

import main.java.com.main.entity.waterHistoryTbl;
import com.main.api.CreateWaterHistoryGrpc;
import com.main.api.CreateWaterHistoryRequest;
import com.main.api.CreateWaterHistoryResponse;
import main.java.com.main.dao.waterDao;

import io.grpc.stub.StreamObserver;

import java.time.LocalDateTime;

/**
 * @author: zongcan.li
 * @create: 2024/03/30
 */
public class CreateWaterHistoryImpl extends CreateWaterHistoryGrpc.CreateWaterHistoryImplBase{
    private waterDao wDI;

    public CreateWaterHistoryImpl(waterDao a) {
        this.wDI = a;
    }

    @Override
    public void createWater(CreateWaterHistoryRequest request, StreamObserver<CreateWaterHistoryResponse> responseObserver) {
        CreateWaterHistoryResponse rpcDateResponse = null;
        LocalDateTime localDateTime = LocalDateTime.now();
        waterHistoryTbl newRecord = new waterHistoryTbl();
        newRecord.timeStamp = localDateTime;
        newRecord.operator = request.getOperator();
        this.wDI.save(newRecord);
        try {
            rpcDateResponse = CreateWaterHistoryResponse
                    .newBuilder()
                    .setMes("this is a response")
                    .build();
        } catch (Exception e) {
            responseObserver.onError(e);
        } finally {
            responseObserver.onNext( rpcDateResponse );
        }
        responseObserver.onCompleted();
    }

}