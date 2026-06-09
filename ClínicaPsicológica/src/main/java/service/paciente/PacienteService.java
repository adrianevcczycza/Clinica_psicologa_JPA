package service.paciente;

import java.util.List;

import dto.PacienteRequestDto;
import dto.PacienteResponseDto;


public interface PacienteService {
    PacienteResponseDto savePaciente(PacienteRequestDto pacienteRequestDto);
    PacienteResponseDto buscarPacientePorId(Long id);
    List<PacienteResponseDto>listarPaciente();
    PacienteResponseDto atualizarPaciente(Long id, PacienteRequestDto paciente);
    void deletarPacientePorId(Long id);
  
}
