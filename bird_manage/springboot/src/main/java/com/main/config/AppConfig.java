package main.java.com.main.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.grpc.protobuf.services.ProtoReflectionService;
import io.grpc.ServerBuilder;

/**
 * @author: zongcan.li
 * @create: 2024/05/04
 */

@Configuration
public class AppConfig {

    @Bean
    public ServerBuilder<?> grpcServerBuilder() {
        ServerBuilder<?> serverBuilder = ServerBuilder.forPort(8080); // Change the port as needed

        // Enable reflection
        serverBuilder.addService(ProtoReflectionService.newInstance());

        return serverBuilder;
    }
}