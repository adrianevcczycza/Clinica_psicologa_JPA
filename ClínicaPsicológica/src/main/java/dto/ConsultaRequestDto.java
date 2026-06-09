package dto;

import java.time.LocalDate;

import model.Paciente;
import model.Psicologa;

public record ConsultaRequestDto(
    Psicologa psicologa,
    Paciente paciente,
    String modalidade,
    LocalDate data 
) {

}
