package dto;

public record PacienteResponseDto(
    Long id,
    String nome,
    String idade,
    String email,
    String telefone  
){

}