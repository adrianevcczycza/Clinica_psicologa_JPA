package service.psicologa;

import java.util.List;

import org.springframework.stereotype.Service;

import dto.PsicologaRequestDto;
import dto.PsicologaResponseDto;
import lombok.RequiredArgsConstructor;
import mapper.PsicologaMapper;
import model.Psicologa;
import repository.PsicologaRepository;

@Service 
@RequiredArgsConstructor
public class PsicologaServiceImpl implements PsicologaService {

    private final PsicologaRepository psicologaRepository;
    private final PsicologaMapper psicologaMapper;

    @Override
    // pq por nome ? pq o id gera automaticamente depois de criado, então ele ainda não tem id 
    public PsicologaResponseDto savePsicologa(PsicologaRequestDto psicologaRequestDto) {
        
        if (psicologaRepository.existsByNome(psicologaRequestDto.nome())) {
            throw new RuntimeException();
        }
        Psicologa psicologa=psicologaMapper.toEntity(psicologaRequestDto);

        psicologaRepository.save(psicologa);

        return psicologaMapper.tResponseDto(psicologa);
    }

    @Override
    public PsicologaResponseDto buscarPsicologaPorId(Long id) {
      Psicologa psicologa=psicologaRepository.findById(id)
      .orElseThrow(() -> new RuntimeException(" Não existente!"));

      return psicologaMapper.tResponseDto(psicologa);
    }

    @Override
    public List<PsicologaResponseDto> listarPsicologa() {
       List<Psicologa> psicologas = psicologaRepository.findAll();

       return psicologas.stream()
       .map(psicologaMapper::tResponseDto)
       .toList();
    }

    @Override
    public PsicologaResponseDto atualizarPsicologa(Long id, PsicologaRequestDto psicologaRequestDto) {
      Psicologa psicologa = psicologaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException(" Não existe!"));

        psicologa.setNome(psicologaRequestDto.nome());
        psicologa.setTelefone(psicologaRequestDto.telefone());
        psicologa.setEmail(psicologaRequestDto.email());
        psicologa.setEspecialidade(psicologaRequestDto.especialidade());
      
        psicologaRepository.save(psicologa);

        return psicologaMapper.tResponseDto(psicologa);
    }

    @Override
    public void deletarPsicologaPorId(Long id) {
        if (!psicologaRepository.existsById(id)) {
            throw new RuntimeException("Não existe!");   
        }
        psicologaRepository.deleteById(id);
       
    }

}
