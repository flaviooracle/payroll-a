package com.example.payrollapi.feignClients;

import com.example.payrollapi.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Component
@FeignClient(name = "user-api", url = "http://localhost:8081")
public interface UserFeign
{
    @GetMapping(value = "/api/users/{id}")
    ResponseEntity<User> findById(@PathVariable Long id);
    @GetMapping(value="/api/users")
    ResponseEntity<List<User>> findAll();
}
