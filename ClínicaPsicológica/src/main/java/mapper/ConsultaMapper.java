package mapper;

import org.springframework.stereotype.Component;

import dto.ConsultaRequestDto;
import dto.ConsultaResponseDto;
import model.Consulta;

@Component
public class ConsultaMapper {

    public Consulta toEntity(ConsultaRequestDto consultaRequestDto){
        return new Consulta(
            consultaRequestDto.psicologa(),
            consultaRequestDto.paciente(),
            consultaRequestDto.modalidade(),
            consultaRequestDto.data()
        );     
    }
    public ConsultaResponseDto toResponseDTO  (Consulta consulta){
        return new ConsultaResponseDto(
            consulta.getId(),
            consulta.getPsicologa(),
            consulta.getPaciente(),
            consulta.getModalidadeConsulta(),
            consulta.getData()
        );  
    }
}
