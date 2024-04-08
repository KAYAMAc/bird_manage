package com.main.bl;

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

import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author: zongcan.li
 * @create: 2024/03/30
 */
public class CreateWaterHistoryImpl extends CreateWaterHistoryGrpc.CreateWaterHistoryImplBase{
    private waterDao waterInterface;

    @Autowired
    public void WaterHistoryService(waterDao waterHistoryRepository) {
        this.waterInterface = waterHistoryRepository;
    }

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
            this.waterInterface.insertWaterHistory(newRecord);
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