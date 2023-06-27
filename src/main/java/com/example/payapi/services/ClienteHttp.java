package com.example.payapi.services;

import com.example.payapi.domain.Payroll;
import com.example.payapi.domain.User;
import com.example.payapi.services.exceptions.ObjectNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RequiredArgsConstructor
@Slf4j  // habilita logs
@Service
public class ClienteHttp {

    private final Environment env;

   public Payroll findById(Long id, Payroll payroll) throws IOException, InterruptedException {

       String port = "8081"; //env.getProperty("local.server.port");
       String uriUser = String.format("http://localhost:%s/api/users/%s",port,id.toString());

       try{
           HttpResponse<String> response = HttpClient.newHttpClient().send(HttpRequest.newBuilder()
                           .uri(URI.create(uriUser))
                           .build(),
                   HttpResponse.BodyHandlers.ofString());
           String result = response.body();

           ObjectMapper objectMapper = new ObjectMapper();
           User user = objectMapper.readValue(result, User.class);

           return new Payroll(
                   user.getName(),
                   payroll.getDescription(),
                   user.getHourlyPrice(),
                   payroll.getWorkedHours(),
                   user.getHourlyPrice()*payroll.getWorkedHours());
       }catch(IOException ex){
           throw new ObjectNotFoundException("Flavio... Object not Found.");
       }catch(Exception ex){
           throw new IllegalArgumentException("Flavio... Illegal argument Exception");
       }

   }

}
