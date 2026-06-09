package controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.PsicologaRequestDto;
import dto.PsicologaResponseDto;
import lombok.RequiredArgsConstructor;
import service.psicologa.PsicologaService;

@RestController
@RequestMapping("/psicologaController")
@RequiredArgsConstructor
public class PsicologaController {
    
    private final PsicologaService psicologaService;

    @PostMapping
    public PsicologaResponseDto postPsicologa(
            @RequestBody PsicologaRequestDto requestDto){
        try{
            PsicologaResponseDto responseDto = psicologaService.savePsicologa(requestDto);
            return responseDto;
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<PsicologaResponseDto> listarPsicologa(){

        try{
            List<PsicologaResponseDto>psicologas = psicologaService.listarPsicologa();
            return psicologas;
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }   
    }

    @GetMapping("/{id}")
    public PsicologaResponseDto buscaPsicologaPorId(@PathVariable Long id){
        try{
            return  psicologaService.buscarPsicologaPorId(id);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    
    @PutMapping("/{id}")
    public PsicologaResponseDto atualizarPsicologa(@PathVariable Long id, @RequestBody PsicologaRequestDto psicologaRequestDto){
        try{
            return psicologaService.atualizarPsicologa(id, psicologaRequestDto);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    
    @DeleteMapping("/{id}")
    public  void deletarPsicologaPorId(@PathVariable Long id){
        try{
            psicologaService.deletarPsicologaPorId(id);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
