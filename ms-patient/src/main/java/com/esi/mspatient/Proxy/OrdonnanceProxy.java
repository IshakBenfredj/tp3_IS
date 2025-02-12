package com.esi.mspatient.Proxy;

import com.esi.mspatient.DTO.OrdonnanceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="ms-ordonnance", url="localhost:8082")
public interface OrdonnanceProxy {

    //  ?idPatient=1&projection=toPatient
    @GetMapping("ordonnances/search/findOrdonnancesByIdPatient")
    CollectionModel<OrdonnanceDTO> getOrdonancesByIdpatient(@RequestParam("idPatient") Long idPatient,
                                                            @RequestParam("projection") String projection );
}
