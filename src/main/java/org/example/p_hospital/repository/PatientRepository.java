package org.example.p_hospital.repository;

import org.example.p_hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository()

public interface PatientRepository extends JpaRepository<Patient, Long>{
    Optional<Patient> findById(Long Id);
    List<Patient>findByNomContains(String mc);
    @Query("select p from Patient p where p.nom like:s")
    List<Patient>search(@Param("s") String mc);
}
