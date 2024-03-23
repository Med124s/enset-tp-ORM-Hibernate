package org.example.p_clinique.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@NoArgsConstructor
@AllArgsConstructor @Getter @Setter @Builder @ToString
public class RendezVous implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateRDV;
    private int heureRDV;
    @Enumerated(EnumType.STRING)
    private StatusRDV statusRDV;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)

    private Patient patient;
    @ManyToOne
    private Medcin medcin;
    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation;
}
