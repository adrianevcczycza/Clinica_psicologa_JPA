package com.example.ClinicaPsicologica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ClinicaPsicologica.model.Psicologa;

@Repository
public interface PsicologaRepository extends JpaRepository< Psicologa, Long>{

}
