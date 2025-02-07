package com.esi.msordonnance.Entities;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "toPatient", types = {Ordonnance.class})
public interface OrdonnanceProjection {

    Long getIdOrdonnance();

    List<MedicamentDTO> getMedicaments();

    public interface MedicamentDTO{
        String getNom();
        double getCout();
    }
}
