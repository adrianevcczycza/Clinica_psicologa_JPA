package service.paciente;

import java.util.List;

import dto.PacienteRequestDto;
import dto.PacienteResponseDto;
import model.Paciente;


public interface PacienteService {
    PacienteResponseDto savePaciente(PacienteRequestDto pacienteRequestDto);
    PacienteResponseDto buscarPacientePorId(Long id);
    List<Paciente>listarPaciente();
    PacienteResponseDto atualizarPaciente(Long id, PacienteRequestDto paciente);
    void deletarPacientePorId(Long id);
}
