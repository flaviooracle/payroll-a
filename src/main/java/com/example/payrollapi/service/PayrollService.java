package com.example.payrollapi.service;

import com.example.payrollapi.domain.Payroll;
import com.example.payrollapi.feignClients.UserFeign;
import com.example.payrollapi.service.exceptions.ObjectNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Slf4j
@Service
public class PayrollService
{
    private final Environment env;
    private final UserFeign feign;
    public Payroll getPayment(Long workId, Payroll payroll){
      log.info("PayrollService... Get request on "+env.getProperty("local.server.port")+" Port.");
      try{
            var user = feign.findById(workId).getBody();
            if(Objects.nonNull(user)){
                return new Payroll(
                        user.getName(),
                        payroll.getDescription(),
                        user.getHourlyPrice(),
                        payroll.getWorkedHours(),
                        user.getHourlyPrice()*payroll.getWorkedHours());
            }

      }catch(FeignException.NotFound ex){
          throw new ObjectNotFoundException("Flavio... Object Not Found");
      }catch(Exception ex){
          throw new IllegalArgumentException("Flavio... Illegal argument Exception");
      }
      return null;
    }
}
