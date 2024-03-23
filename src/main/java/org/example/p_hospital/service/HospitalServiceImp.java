package org.example.p_hospital.service;

import jakarta.transaction.Transactional;
import org.example.p_hospital.entities.Consultation;
import org.example.p_hospital.entities.Medcin;
import org.example.p_hospital.entities.Patient;
import org.example.p_hospital.entities.RendezVous;
import org.example.p_hospital.repository.ConsultationRepository;
import org.example.p_hospital.repository.MedcinRepository;
import org.example.p_hospital.repository.PatientRepository;
import org.example.p_hospital.repository.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class HospitalServiceImp implements IHospitalService {
    private final PatientRepository patientRepository;
    private final ConsultationRepository consultationRepository;
    private final MedcinRepository medcinRepository;
    private final RendezVousRepository rendezVousRepository;

    public HospitalServiceImp(PatientRepository patientRepository, ConsultationRepository consultationRepository, MedcinRepository medcinRepository, RendezVousRepository rendezVousRepository) {
        this.patientRepository = patientRepository;
        this.consultationRepository = consultationRepository;
        this.medcinRepository = medcinRepository;
        this.rendezVousRepository = rendezVousRepository;
    }

    @Override
    public void AddPatient(Patient patient) {
        patientRepository.save(patient);
    }
    @Override
    public void DeletePatient(Long id) {
        patientRepository.deleteById(id);
    }
    @Override
    public void UpdatePatient(Long id, Patient patient) {
        Patient patient1 = patientRepository.findById(id).get();
        patient1.setNom(patient1.getNom());
        patient1.setScore(patient.getScore());
        patient1.setMalade(patient.isMalade());
        patient1.setDateNaissance(patient1.getDateNaissance());
        patientRepository.save(patient);
    }
    @Override
    public List<Patient> listPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient patient(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Patient> findPatients(String nom) {
        return patientRepository.search(nom);
    }
    @Override
    public List<Patient> findPatientsByMc(String mc) {
        return patientRepository.findByNomContains(mc);
    }

    @Override
    public Consultation SaveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public List<RendezVous> rendezVousList() {
        return rendezVousRepository.findAll();
    }
    @Override
    public RendezVous SaveRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Medcin medcin(Long id) {
        return medcinRepository.findById(id).orElse(null);
    }

    @Override
    public Medcin SaveMedcin(Medcin medcin) {
        return medcinRepository.save(medcin);
    }
}
