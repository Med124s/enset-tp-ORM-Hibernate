package org.example.p_clinique.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Roles")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true, length = 20)
    private String roleName;
    @Column(name = "DESCRIPTION")
    private String desc;

    @ManyToMany(fetch = FetchType.EAGER)

    @JoinTable(name = "USERS_ROLES")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ToString.Exclude //ne pas retourner la list des utilisateur
    private List<User> users = new ArrayList<>();
}
