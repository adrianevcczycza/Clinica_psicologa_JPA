package mapper;

import dto.PsicologaRequestDto;
import dto.PsicologaResponseDto;
import model.Psicologa;

public class PsicologaMapper {
    public Psicologa toEntity(PsicologaRequestDto PsicologaRequestDto){
        return new Psicologa(
            PsicologaRequestDto.nome(),
            PsicologaRequestDto.email(),
            PsicologaRequestDto.telefone(),
            PsicologaRequestDto.especialidade()
        );
    }
    public PsicologaResponseDto  tResponseDto( Psicologa psicologa){
        return new PsicologaResponseDto(
            psicologa.getId(),
            psicologa.getNome(),
            psicologa.getEmail(),
            psicologa.getTelefone(),
            psicologa.getEspecialidade()
        );
    }
}
