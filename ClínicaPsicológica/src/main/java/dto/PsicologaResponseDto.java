package dto;

public record PsicologaResponseDto(
    Long id,
    String nome,
    String email,
    String telefone,
    String especialidade
) {

}
