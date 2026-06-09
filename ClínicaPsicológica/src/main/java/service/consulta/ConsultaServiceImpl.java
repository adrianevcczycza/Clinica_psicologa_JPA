package service.consulta;

import java.util.List;

import org.springframework.stereotype.Service;

import dto.ConsultaRequestDto;
import dto.ConsultaResponseDto;
import lombok.RequiredArgsConstructor;
import mapper.ConsultaMapper;
import model.Consulta;
import repository.ConsultaRepository;

@Service
@RequiredArgsConstructor
public class ConsultaServiceImpl implements ConsultaService{

    private ConsultaRepository consultaRepository;

    private ConsultaMapper consultaMapper;

    @Override
    public ConsultaResponseDto saveConsulta(ConsultaRequestDto consultaRequestDto) {
       // if (consultaRepository) {
        //    return null; 
        //}
        return null;
    }

    @Override
    public ConsultaResponseDto buscarConsultaPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarConsultaPorId'");
    }

    @Override
    public List listarConsultas() {
       List<Consulta> consultas = consultaRepository.findAll();

       return consultas.stream()
       .map(consultaMapper::toResponseDTO)
       .toList();
    }

    @Override
    public ConsultaResponseDto atualizarConsulta(Long id, ConsultaRequestDto consultaRequestDto) {
        Consulta consulta = consultaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Não existe!"));

        consulta.setData(consultaRequestDto.data());
        consulta.setModalidadeConsulta(consultaRequestDto.modalidade());
        consulta.setPaciente(consultaRequestDto.paciente());
        consulta.setPsicologa(consultaRequestDto.psicologa());

        consultaRepository.save(consulta);

        return consultaMapper.toResponseDTO(consulta);

    }

    @Override
    public void deletarConsultaPorId(Long id) {
      if(!consultaRepository.existsById(id)){
        throw new RuntimeException("Não existe!");
      }

      consultaRepository.deleteById(id);
    }

}
