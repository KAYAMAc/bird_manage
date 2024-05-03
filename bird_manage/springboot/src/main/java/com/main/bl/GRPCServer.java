/*
package main.java.com.main.bl;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

import java.lang.reflect.InvocationTargetException;
import main.java.com.main.dao.*;
import main.java.com.main.bl.GetFoodHistoryImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

 */

/**
 * @author: guangxush
 * @create: 2019/07/07
 */
/*
@Service
public class GRPCServer {
    

    private static final int port = 9998;
    public static void main( String[] args ) throws Exception {
        try {
            Server server = ServerBuilder.
            forPort(port)
            .addService( new GetFoodHistoryImpl() )
            .addService( new GetWaterHistoryImpl() )
            .addService( new CreateFoodHistoryImpl() )
            .addService( new CreateWaterHistoryImpl() )
            .addService(ProtoReflectionService.newInstance())
            .build().start();
            System.out.println( "grpc server started successfully, port:" + port );
            server.awaitTermination();        
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        
    }
} */