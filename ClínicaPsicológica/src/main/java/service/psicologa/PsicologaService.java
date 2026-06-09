package service.psicologa;

import java.util.List;

import dto.PsicologaRequestDto;
import dto.PsicologaResponseDto;

public interface PsicologaService {

    PsicologaResponseDto savePsicologa(PsicologaRequestDto psicologaRequestDto);
    PsicologaResponseDto buscarPsicologaPorId(Long id);
    List<PsicologaResponseDto>listarPsicologa();
    PsicologaResponseDto atualizarPsicologa(Long id,PsicologaRequestDto psicpRequestDto);
    void deletarPsicologaPorId(Long id);
}
