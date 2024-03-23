package org.example.p_hospital.repository;

import org.example.p_hospital.entities.Medcin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository()
public interface MedcinRepository extends JpaRepository<Medcin, Long>{
    Optional<Medcin> findById(Long Id);
    List<Medcin>findByNomContains(String mc);
    @Query("select m from Medcin m where m.nom like:s")
    List<Medcin>search(@Param("s") String mc);
}
