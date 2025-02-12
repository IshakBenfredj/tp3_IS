package com.esi.msordonnance.Controller;

import com.esi.msordonnance.Entities.Ordonnance;
import com.esi.msordonnance.Proxy.PatientProxy;
import com.esi.msordonnance.Proxy.RemboursementProxy;
import com.esi.msordonnance.Repository.OrdonnanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class OrdonnancdeAPI {
    final OrdonnanceRepository ordonnanceRepository;
    final PatientProxy patientProxy;
    final RemboursementProxy remboursementProxy;

    @GetMapping("ordonnance/{ido}")
    Ordonnance getOrdonnanceWithPatient(@PathVariable("ido") Long ido) {
        Ordonnance ordonnance =ordonnanceRepository.findById(ido)
                .orElseThrow(() -> new RuntimeException("Ordonnance non trouv<UNK>"));

        ordonnance.setPatientDTO(patientProxy.getPatient(ordonnance.getIdPatient()));

        ordonnance.setRemboursement(remboursementProxy.getReboursement(
                ordonnance.getIdRemboursement(),
                "toOrd"));
        return ordonnance;
    }
}
