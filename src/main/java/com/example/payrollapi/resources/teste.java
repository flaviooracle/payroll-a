package com.example.payrollapi.resources;

import com.example.payrollapi.domain.Payroll;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value="/api/teste")
public class teste {

    @GetMapping
    public ResponseEntity<Payroll> faz(){

        return ResponseEntity
                .ok()
                .body(new Payroll("",
                        "....",
                        1.0D,
                        1.0D,
                        1.0D));
    }
}
