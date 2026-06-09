package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Psicologa;

@Repository
public interface PsicologaRepository extends JpaRepository<Psicologa, Long>{
    boolean existsByNome(String nome);
}
