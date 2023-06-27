package com.example.payapi.controller;

import com.example.payapi.domain.Payroll;
import com.example.payapi.services.ClienteHttp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping(value="/api/pay")
public class teste {

    @Autowired
    private final ClienteHttp clienteHttp;
    @GetMapping(value="/{workerId}")
    public ResponseEntity<Payroll> getResponse(@PathVariable Long workerId, @RequestBody Payroll payment) throws IOException, InterruptedException {

        Payroll pay = clienteHttp.findById(workerId,payment);

        return ResponseEntity
                .ok()
                .body(pay);
    }

}
