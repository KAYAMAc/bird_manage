/* 
package main.java.com.main.bl;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

import java.lang.reflect.InvocationTargetException;
import main.java.com.main.dao.*;
import main.java.com.main.bl.GetFoodHistoryImpl;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

*/
/**
 * @author: zongcan.li
 * @create: 2024/05/01
 */
/*
@SpringBootApplication
@ComponentScan("main.java.com.main.dao")
public class GRPCServer {
    
    private static final int port = 9998;
    public static void main( String[] args ) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(GRPCServer.class, args);
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
        foodDao fd = context.getBean(foodDao.class);
        
        try {
            Server server = ServerBuilder.
            forPort(port)
            .addService( new GetFoodHistoryImpl() )
            .addService( new GetWaterHistoryImpl() )
            .addService( new CreateFoodHistoryImpl(fd) )
            .addService( new CreateWaterHistoryImpl() )
            .addService(ProtoReflectionService.newInstance())
            .build().start();
            System.out.println( "grpc server started successfully, port:" + port );
            server.awaitTermination();        
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        
    }
} 
 */