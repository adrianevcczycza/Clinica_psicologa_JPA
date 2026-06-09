package dto;

public record PsicologaRequestDto(
    String nome,
    String email,
    String telefone,
    String especialidade
) {
}
