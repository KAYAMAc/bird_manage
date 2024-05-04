package main.java.com.main.bl;

import com.main.api.FoodRequest;
import com.main.api.FoodHistory;
import io.grpc.stub.StreamObserver;
import main.java.com.main.dao.foodDao;
import main.java.com.main.entity.foodHistoryTbl;

import com.main.api.GetFoodHistoryGrpc;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author: zongcan.li
 * @create: 2024/03/30
 */
@Service
public class GetFoodHistoryImpl extends GetFoodHistoryGrpc.GetFoodHistoryImplBase{

    private foodDao fDI;

    public GetFoodHistoryImpl(foodDao a) {
        this.fDI = a;
    }
    @Override
    public void getFood(FoodRequest request, StreamObserver<FoodHistory> responseObserver) {
        FoodHistory rpcResponse = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime start = LocalDateTime.parse(request.getStartDate(), formatter);
        LocalDateTime end = LocalDateTime.parse(request.getEndDate(), formatter);
        List<foodHistoryTbl> records = this.fDI.findRecordsByTimeRange(start, end);
        ArrayList<String> result = new ArrayList<String>();
        for(foodHistoryTbl record : records) {
            result.add(record.getCategory() + " ; " + record.getPortion() + " ; " + record.getTimeStamp() + " ; " + record.getOperator());
        }
        try {
            rpcResponse = FoodHistory
                    .newBuilder()
                    .addAllFood( result )
                    .build();
        } catch (Exception e) {
            responseObserver.onError(e);
        } finally {
            responseObserver.onNext( rpcResponse );
        }
        responseObserver.onCompleted();
    }
}