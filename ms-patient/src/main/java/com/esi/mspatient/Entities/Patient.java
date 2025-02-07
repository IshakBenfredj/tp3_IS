package com.esi.mspatient.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatient;

    private String nom;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private Set<AntecedentMedical> antecedentsMedicaux;
}
