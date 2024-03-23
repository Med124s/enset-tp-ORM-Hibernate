package org.example.p_clinique;
import org.example.p_clinique.entities.*;
import org.example.p_clinique.repository.MedcinRepository;
import org.example.p_clinique.repository.PatientRepository;
import org.example.p_clinique.repository.RendezVousRepository;
import org.example.p_clinique.service.HospitalServiceImp;
import org.example.p_clinique.service.IUserRoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class PCliniqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(PCliniqueApplication.class, args);
	}

	@Bean
	CommandLineRunner start(
			HospitalServiceImp hospitalServiceImp,
			PatientRepository patientRepository,
			MedcinRepository medcinRepository,
			RendezVousRepository rendezVousRepository,
			IUserRoleService userRoleService
			) {
		return args -> {

			Stream.of("Mohamed","Ali","Damia")
					.forEach(name->{
						Patient patient = new Patient();
						patient.setNom(name);
						patient.setScore(10);
						patient.setDateNaissance(new Date());
						patient.setMalade(true);
						patientRepository.save(patient);
					});
			Stream.of("amin","hussin","naim").forEach(name->{
				        Medcin medcin = Medcin.builder().nom(name)
						.dateNaissance(new Date())
						.specialite(Math.random()>0.5?"Cardio":"Boms")
						.build();
				         hospitalServiceImp.SaveMedcin(medcin);
			});

			Patient patient = patientRepository.findById(1L).orElse(null);
			Medcin medcin = medcinRepository.findById(1L).orElse(null);

			RendezVous rendezVous = new RendezVous();
			rendezVous.setDateRDV(new Date());
			rendezVous.setHeureRDV(10);
			rendezVous.setPatient(patient);
			rendezVous.setStatusRDV(StatusRDV.PENDING);
			rendezVous.setMedcin(medcin);
			hospitalServiceImp.SaveRendezVous(rendezVous);

			RendezVous rendezVous1 = rendezVousRepository.findById(1L).orElse(null);

			Consultation consultation1 = new Consultation();
			consultation1.setDateConsultation(rendezVous1.getDateRDV());
			consultation1.setRapport("Rapport Consultation 1");
			consultation1.setRendezVous(rendezVous1);
			hospitalServiceImp.SaveConsultation(consultation1);

			System.out.println("****************** USERS ROLES ******************");
			// ADD NEW ROLES
				Role admin = new Role();
				admin.setDesc("Description...");
				admin.setRoleName("ADMIN");

				Role userRole = new Role();
			    userRole.setDesc("Description...");
			    userRole.setRoleName("USER");

				userRoleService.AddRole(admin);
				userRoleService.AddRole(userRole);

			// ADD NEW USERS
			   User user1 = new User();
			   user1.setPassword("123456");
			   user1.setUsername("user1");
			   userRoleService.AddUser(user1);

			   User admin1 = new User();
			   admin1.setPassword("123456");
			   admin1.setUsername("admin");
			   userRoleService.AddUser(admin1);

				userRoleService.AddRoleToUser("user1","USER");
			    userRoleService.AddRoleToUser("admin","ADMIN");
			    userRoleService.AddRoleToUser("admin","USER");

			System.out.println("****************** Authentication ******************");
			try {
				User user = userRoleService.autentication("admin", "12345");
				System.out.println("*****Roles*****");
				user.getRoles().forEach(r -> System.out.println("Roles=>" + r));
			}
			catch (Exception e){
				e.printStackTrace();
			}
		};
	}

	}

