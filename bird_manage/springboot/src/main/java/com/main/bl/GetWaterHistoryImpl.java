package main.java.com.main.bl;

import com.main.api.WaterRequest;
import com.main.api.WaterHistory;
import io.grpc.stub.StreamObserver;
import main.java.com.main.dao.waterDao;
import main.java.com.main.entity.waterHistoryTbl;

import com.main.api.GetWaterHistoryGrpc;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * @author: zongcan.li
 * @create: 2024/03/30
 */
@Service
public class GetWaterHistoryImpl extends GetWaterHistoryGrpc.GetWaterHistoryImplBase{

    private waterDao wDI;

    public GetWaterHistoryImpl(waterDao a) {
        this.wDI = a;
    }
    
    @Override
    public void getWater(WaterRequest request, StreamObserver<WaterHistory> responseObserver) {
        WaterHistory rpcDateResponse = null;
        LocalDateTime currentDate = LocalDateTime.now();
        LocalDateTime threeDaysAgo = currentDate.minusDays(3);
        List<waterHistoryTbl> records = this.wDI.findRecordsByTimeRange(threeDaysAgo, currentDate);
        ArrayList<String> result = new ArrayList<String>();
        for(waterHistoryTbl record : records) {
            result.add(record.getTimeStamp() + " ; " + record.getOperator());
        }
        try {
            rpcDateResponse = WaterHistory
                    .newBuilder()
                    .addAllWater( result )
                    .build();
        } catch (Exception e) {
            responseObserver.onError(e);
        } finally {
            responseObserver.onNext( rpcDateResponse );
        }
        responseObserver.onCompleted();
    }

}