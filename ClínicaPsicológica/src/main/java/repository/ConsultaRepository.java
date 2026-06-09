package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Consulta;
@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}
