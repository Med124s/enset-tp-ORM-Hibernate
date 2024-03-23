package org.example.p_clinique.repository;

import org.example.p_clinique.entities.Consultation;
import org.example.p_clinique.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()

public interface ConsultationRepository extends JpaRepository<Consultation, Long>{

}
