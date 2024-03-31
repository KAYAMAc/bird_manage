package com.main.api;

import com.main.api.FoodRequest;
import com.main.api.WaterRequest;
import com.main.api.FoodHistory;
import com.main.api.WaterHistory;
import io.grpc.stub.StreamObserver;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: zongcan.li
 * @create: 2024/03/30
 */
public class GetFoodHistoryImpl extends GetFoodHistoryGrpc.GetFoodHistoryImplBase{
    @Override
    public void getFood(FoodRequest request, StreamObserver<FoodHistory> responseObserver) {
        FoodHistory rpcDateResponse = null;
        Date now=new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("今天是"+"yyyy年MM月dd日 E kk点mm分");
        String nowTime = simpleDateFormat.format( now );
        try {
            rpcDateResponse = FoodHistory
                    .newBuilder()
                    .setFood( 0, "rice" )
                    .build();
        } catch (Exception e) {
            responseObserver.onError(e);
        } finally {
            responseObserver.onNext( rpcDateResponse );
        }
        responseObserver.onCompleted();
    }
}