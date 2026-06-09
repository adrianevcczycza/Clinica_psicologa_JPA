package dto;

public record PacienteRequestDto(
    String nome,
    String idade,
    String email,
    String telefone 
) {

}
