package org.example.p_clinique.web;

import org.example.p_clinique.entities.Medcin;
import org.example.p_clinique.entities.Patient;
import org.example.p_clinique.entities.RendezVous;
import org.example.p_clinique.service.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestHospital {
    @Autowired
    private IHospitalService hospitalService;

    @GetMapping("/patient/{id}")
    private Patient getPatient(@PathVariable(name = "id")Long id){
        return hospitalService.patient(id);
    }
    @GetMapping("/patients")
    private List<Patient> patientList(){
        return hospitalService.listPatients();
    }

    @GetMapping("/patients/{nom}")
    private List<Patient> getPatientsByNom(@PathVariable(name = "nom")String nom){
        return hospitalService.findPatients(nom);
    }

    @GetMapping("/patientByMc/{mc}")
    private List<Patient> getPatientsByMc(@PathVariable(name = "mc")String mc){
        return hospitalService.findPatientsByMc(mc);
    }

    @PostMapping("/newPatient")
    private void addPatient(Patient patient){
        hospitalService.AddPatient(patient);
    }

    @PutMapping("/updatePatient/{id}")
    private void updatePatient(@PathVariable(name = "id")Long id,Patient patient){
        hospitalService.UpdatePatient(id,patient);
    }

    @GetMapping("/medcin/{id}")
    private Medcin getMedcin(@PathVariable(name = "id")Long id){
        return hospitalService.medcin(id);
    }

    @GetMapping("/renDVS")
    private List<RendezVous> rendezVousList(){
        return hospitalService.rendezVousList();
    }
}
