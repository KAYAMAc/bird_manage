package com.main.api;

import com.main.api.FoodRequest;
import com.main.api.WaterRequest;
import com.main.api.FoodHistory;
import com.main.api.WaterHistory;
import com.main.api.CreateWaterHistoryGrpc;
import com.main.api.CreateWaterHistoryRequest;
import com.main.api.CreateWaterHistoryResponse;
import com.main.dao.foodDao;
import com.main.dao.waterDao;
import io.grpc.stub.StreamObserver;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: zongcan.li
 * @create: 2024/03/30
 */
public class CreateWaterHistoryImpl extends CreateWaterHistoryGrpc.CreateWaterHistoryImplBase{

    @Override
    public void createWater(CreateWaterHistoryRequest request, StreamObserver<CreateWaterHistoryResponse> responseObserver) {
        CreateWaterHistoryResponse rpcDateResponse = null;
        Date now=new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("今天是"+"yyyy年MM月dd日 E kk点mm分");
        String nowTime = simpleDateFormat.format( now );
        try {
            rpcDateResponse = CreateWaterHistoryResponse
                    .newBuilder()
                    .setWater(0, "half")
                    .build();
        } catch (Exception e) {
            responseObserver.onError(e);
        } finally {
            responseObserver.onNext( rpcDateResponse );
        }
        responseObserver.onCompleted();
    }

}