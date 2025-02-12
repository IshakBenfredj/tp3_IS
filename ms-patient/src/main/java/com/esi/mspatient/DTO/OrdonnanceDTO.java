package com.esi.mspatient.DTO;

import lombok.Data;

import java.util.List;

@Data
public class OrdonnanceDTO {
    Long idOrdonnance;
    List<MedicamentInfo> medicaments;
}
