package com.example.push;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class SpringWebSocketConfig implements WebSocketConfigurer{
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(new WebSocketHander(),"/veg").addInterceptors(new HandshakeInterceptor());
        webSocketHandlerRegistry.addHandler(new WebSocketHander(), "/com/veg").addInterceptors(new HandshakeInterceptor()).withSockJS();
    }

}
