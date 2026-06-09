package dto;

public record PacienteRequestDto(
    String nome,
    String idade,
    String email,
    String telefone 
) {

    public boolean existsByNome(String nome2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsByNome'");
    }

}
