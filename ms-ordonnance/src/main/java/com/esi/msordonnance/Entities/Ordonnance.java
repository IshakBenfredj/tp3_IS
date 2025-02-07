package com.esi.msordonnance.Entities;

import com.esi.msordonnance.DTO.PatientDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data @AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ordonnance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrdonnance;

    private Date dateOrdonnance;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "ordonnance", cascade = CascadeType.ALL)
    private List<Medicament> medicaments;

    private Long idPatient;

    @Transient
    private PatientDTO patientDTO;
}
