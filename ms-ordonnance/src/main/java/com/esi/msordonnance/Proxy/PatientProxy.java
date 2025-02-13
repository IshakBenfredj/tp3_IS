package com.esi.msordonnance.Proxy;


import com.esi.msordonnance.DTO.PatientDTO;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-patient")
@LoadBalancerClient(name = "ms-patient")
public interface PatientProxy {
    @GetMapping("/patients/{idp}")
    PatientDTO getPatient(@PathVariable("idp") Long idPatient);
}
