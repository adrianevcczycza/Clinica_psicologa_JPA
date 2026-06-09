package service.consulta;

import java.util.List;

import dto.ConsultaRequestDto;
import dto.ConsultaResponseDto;
import model.Consulta;

public interface ConsultaService {
    ConsultaResponseDto saveConsulta(ConsultaRequestDto consultaRequestDto);
    ConsultaResponseDto buscarConsultaPorId(Long id);
    List<Consulta>listarConsultas();
    ConsultaResponseDto atualizarConsulta(Long id, ConsultaRequestDto consulta);
    void deletarConsultaPorId(Long id);
}

/// salvar uma consulta 
/// agendar nova consulta
/// buscar consulta por id
/// deletar consulta por id 
/// atualizar consulta
/// listar consultas