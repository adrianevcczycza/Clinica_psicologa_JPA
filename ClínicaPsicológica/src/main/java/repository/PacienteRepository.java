package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Paciente;
@Repository
public interface PacienteRepository extends JpaRepository <Paciente, Long>{
    boolean existsByNome(String nome);

}
