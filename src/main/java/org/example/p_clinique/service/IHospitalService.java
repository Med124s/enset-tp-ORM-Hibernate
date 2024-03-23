package org.example.p_clinique.service;

import org.example.p_clinique.entities.Consultation;
import org.example.p_clinique.entities.Medcin;
import org.example.p_clinique.entities.Patient;
import org.example.p_clinique.entities.RendezVous;

import java.util.List;

public interface IHospitalService {
    void AddPatient(Patient patient);
    void DeletePatient(Long id);
    void UpdatePatient(Long id, Patient patient);
    List<Patient> listPatients();
    Patient patient(Long id);
    List<Patient>findPatients(String nom);
    List<Patient> findPatientsByMc(String mc);

    Consultation SaveConsultation(Consultation consultation);

    List<RendezVous> rendezVousList();

    RendezVous SaveRendezVous(RendezVous rendezVous);
    Medcin medcin(Long id);
    Medcin SaveMedcin(Medcin medcin);

}
