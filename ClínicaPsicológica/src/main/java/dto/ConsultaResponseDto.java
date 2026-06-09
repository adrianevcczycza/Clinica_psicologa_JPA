package dto;

import java.time.LocalDate;

import model.Paciente;
import model.Psicologa;

public record ConsultaResponseDto(
    Long id,
    Psicologa psicologa,
    Paciente paciente,
    String modalidade,
    LocalDate data 
) {

}
