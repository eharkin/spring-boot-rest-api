package com.spring.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(info = @Info(description = "Awesome Resources"), servers = {@Server(url = "https://students.org")})
public interface ApiDocConfig {
}
