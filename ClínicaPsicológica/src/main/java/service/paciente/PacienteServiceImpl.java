package service.paciente;

import java.util.List;

import org.springframework.stereotype.Service;

import dto.PacienteRequestDto;
import dto.PacienteResponseDto;
import lombok.RequiredArgsConstructor;
import mapper.PacienteMapper;
import model.Paciente;
import repository.PacienteRepository;

@Service
@RequiredArgsConstructor

public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

    private final PacienteMapper pacienteMapper;

    public PacienteResponseDto savePaciente(PacienteRequestDto pacienteRequestDto) {
      if(pacienteRequestDto.existsByNome(pacienteRequestDto.nome())){
        throw new RuntimeException("Não existe!");
      }
      Paciente paciente= pacienteMapper.toEntity(pacienteRequestDto);

      pacienteRepository.save(paciente);

      return pacienteMapper.tResponseDto(paciente);
    }


    public PacienteResponseDto buscarPacientePorId(Long id) {
      Paciente paciente= pacienteRepository.findById(id)
      .orElseThrow(() ->  new RuntimeException("Não existe!"));

      return pacienteMapper.tResponseDto(paciente);
    }


    public List<PacienteResponseDto> listarPaciente() {
       List<Paciente> pacientes = pacienteRepository.findAll();

       return pacientes.stream()
       .map(pacienteMapper:: tResponseDto)
       .toList();
    }


    @Override
    public PacienteResponseDto atualizarPaciente(Long id, PacienteRequestDto pacienteRequestDto) {
       Paciente paciente = pacienteRepository.findById(id)
       .orElseThrow(() -> new RuntimeException("Não existe!"));

       paciente.setNome(pacienteRequestDto.nome());
       paciente.setEmail(pacienteRequestDto.email());
       paciente.setIdade(pacienteRequestDto.idade());
       paciente.setTelefone(pacienteRequestDto.telefone());

       return pacienteMapper.tResponseDto(paciente);
    }

    @Override
    public void deletarPacientePorId(Long id) {
     if(!pacienteRepository.existsById(id)){
        throw new RuntimeException("Não existe");
     }
     pacienteRepository.deleteById(id);
    }
}
