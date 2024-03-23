package org.example.p_hospital.repository;

import org.example.p_hospital.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()

public interface ConsultationRepository extends JpaRepository<Consultation, Long>{

}
