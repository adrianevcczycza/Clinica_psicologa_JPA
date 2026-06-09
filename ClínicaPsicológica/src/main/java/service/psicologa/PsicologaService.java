package service.psicologa;

import java.util.List;

import dto.PsicologaRequestDto;
import dto.PsicologaResponseDto;
import model.Psicologa;

public interface PsicologaService {

    PsicologaResponseDto savePsicologa(PsicologaRequestDto psicologaRequestDto);
    PsicologaResponseDto buscarPsicologaPorId(Long id);
    List<Psicologa>listarPsicologa();
    PsicologaResponseDto atualizarPsicologa(Long id,PsicologaRequestDto psicologa);
    void deletarPsicologaPorId(Long id);
}
