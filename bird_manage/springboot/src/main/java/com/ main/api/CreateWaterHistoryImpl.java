package com.main.api;

import com.main.api.FoodRequest;
import com.main.api.WaterRequest;
import com.main.api.FoodHistory;
import com.main.api.WaterHistory;
import com.main.entity.waterHistoryTbl;
import com.main.entity.foodHistoryTbl;
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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = simpleDateFormat.format( now );
        waterHistoryTbl newRecord = new waterHistoryTbl();
        newRecord.timeStamp = nowTime;
        newRecord.operator = request.getOperator();
        try{
            waterDao.insertWaterHistory(newRecord);
        }catch(Exception e){
            System.out.println("exception happened");
        }
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