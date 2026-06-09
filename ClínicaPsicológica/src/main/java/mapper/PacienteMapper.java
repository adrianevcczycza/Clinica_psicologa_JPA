package mapper;

import dto.PacienteRequestDto;
import dto.PacienteResponseDto;
import model.Paciente;

public class PacienteMapper {
    public Paciente toEntity(PacienteRequestDto pacienteRequestDto){
        return new Paciente(
            pacienteRequestDto.nome(),
            pacienteRequestDto.idade(),
            pacienteRequestDto.email(),
            pacienteRequestDto.telefone()
        );
    }
    public PacienteResponseDto tResponseDto(Paciente paciente){
        return new PacienteResponseDto(
            paciente.getId(),
            paciente.getNome(),
            paciente.getIdade(),
            paciente.getEmail(),
            paciente.getTelefone()
        );
    }
}
