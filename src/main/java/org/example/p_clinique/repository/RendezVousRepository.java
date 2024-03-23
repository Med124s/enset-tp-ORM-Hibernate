package org.example.p_clinique.repository;

import org.example.p_clinique.entities.Patient;
import org.example.p_clinique.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository()

public interface RendezVousRepository extends JpaRepository<RendezVous, Long>{

}
