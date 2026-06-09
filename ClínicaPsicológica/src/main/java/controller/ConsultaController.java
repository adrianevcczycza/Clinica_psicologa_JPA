package controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.ConsultaRequestDto;
import dto.ConsultaResponseDto;
import lombok.RequiredArgsConstructor;
import model.Consulta;
import service.consulta.ConsultaService;

@RestController
@RequestMapping("/consultaController")
@RequiredArgsConstructor
public class ConsultaController {
     private final ConsultaService consultaService;

    @PostMapping
    public ConsultaResponseDto postConsulta(
            @RequestBody ConsultaRequestDto requestDto){
        try{
            ConsultaResponseDto responseDto = consultaService.saveConsulta(requestDto);
            return responseDto;
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public Iterable<Consulta> listarConsultas(){

        try{
            Iterable<Consulta> consultas = consultaService.listarConsultas();
            return consultas;
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }   
    }

    @GetMapping("/{id}")
    public ConsultaResponseDto buscaConsultaPorId (@PathVariable Long id){
        try{
            return  consultaService.buscarConsultaPorId(id);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ConsultaResponseDto atualizarConsulta(@PathVariable Long id, @RequestBody ConsultaRequestDto consultaRequestDto){
        try{
            return consultaService.atualizarConsulta(id, consultaRequestDto);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    
    @DeleteMapping("/{id}")
    public  void deletarPacientePorId(@PathVariable Long id){
        try{
            consultaService.deletarConsultaPorId(id);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
