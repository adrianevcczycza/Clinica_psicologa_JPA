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

import dto.PacienteRequestDto;
import dto.PacienteResponseDto;
import lombok.RequiredArgsConstructor;
import service.paciente.PacienteService;

@RestController
@RequestMapping ("/pacienteController")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @PostMapping
    public PacienteResponseDto postPaciente(
            @RequestBody PacienteRequestDto requestDto){
        try{
            PacienteResponseDto responseDto = pacienteService.savePaciente(requestDto);
            return responseDto;
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<PacienteResponseDto> listarPaciente(){

        try{
            List<PacienteResponseDto> pacientes = pacienteService.listarPaciente();
            return pacientes;
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }   
    }

    @GetMapping("/{id}")
    public PacienteResponseDto buscaPacientePorId (@PathVariable Long id){
        try{
            return  pacienteService.buscarPacientePorId(id);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public PacienteResponseDto atualizarPaciente(@PathVariable Long id, @RequestBody PacienteRequestDto pacienteRequestDto){
        try{
            return pacienteService.atualizarPaciente(id, pacienteRequestDto);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    
    @DeleteMapping("/{id}")
    public  void deletarPacientePorId(@PathVariable Long id){
        try{
            pacienteService.deletarPacientePorId(id);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}

