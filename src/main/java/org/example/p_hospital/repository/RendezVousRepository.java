package org.example.p_hospital.repository;

import org.example.p_hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()

public interface RendezVousRepository extends JpaRepository<RendezVous, Long>{

}
