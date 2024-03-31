package com.main.api;

import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * @author: guangxush
 * @create: 2019/07/07
 */
public class GRPCServer {
    private static final int port = 9998;
    public static void main( String[] args ) throws Exception {
        Server server = ServerBuilder.
                forPort(port)
                .addService( new GetFoodHistoryImpl() )
                .build().start();
        System.out.println( "grpc server started successfully, port:" + port );
        server.awaitTermination();
    }
}