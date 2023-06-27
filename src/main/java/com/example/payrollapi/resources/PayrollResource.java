package com.example.payrollapi.resources;

import com.example.payrollapi.domain.Payroll;
import com.example.payrollapi.service.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/// anotation para deixar automatico o construtor com as injeç de dependencias
@RequiredArgsConstructor
@RestController
@RequestMapping(value="/api/payments")
public class PayrollResource
{
    private final PayrollService payrollService;

    @GetMapping(value="/{workerId}")
    public ResponseEntity<Payroll> getPaymenta(@PathVariable Long workerId, @RequestBody Payroll payment)
    {
        Payroll payroll = payrollService.getPayment(workerId,payment);

        return ResponseEntity
                .ok()
                .body(payroll);

    }
}
