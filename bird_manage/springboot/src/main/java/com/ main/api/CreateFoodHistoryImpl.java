package com.main.api;

import com.main.api.FoodRequest;
import com.main.api.WaterRequest;
import com.main.entity.waterHistoryTbl;
import com.main.entity.foodHistoryTbl;
import com.main.api.FoodHistory;
import com.main.api.WaterHistory;
import com.main.dao.foodDao;
import com.main.api.CreateFoodHistoryRequest;
import com.main.api.CreateFoodHistoryResponse;
import com.main.api.CreateFoodHistoryGrpc;
import io.grpc.stub.StreamObserver;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: zongcan.li
 * @create: 2024/03/30
 */
public class CreateFoodHistoryImpl extends CreateFoodHistoryGrpc.CreateFoodHistoryImplBase{
    @Override
    public void createFood(CreateFoodHistoryRequest request, StreamObserver<CreateFoodHistoryResponse> responseObserver) {
        CreateFoodHistoryResponse rpcResponse = null;
        //Date now=new Date();
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("今天是"+"yyyy年MM月dd日 E kk点mm分");
        SimpleDateFormat nowTime = simpleDateFormat.format( now );
        foodHistoryTbl newRecord = new foodHistoryTbl();
        newRecord.timeStamp = nowTime;
        newRecord.operator = request.getOperator();
        newRecord.category = request.getCategory();
        newRecord.portion = request.getPortion();
        foodDao.insertFoodHistory(newRecord);
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