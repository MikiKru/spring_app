package net.atos.spring_webapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

@NoArgsConstructor
@Data
@Entity                 // Obiekt User jest mapowany na encję w DB
@Table(name = "user")   // Nadpisuje nazwę tabeli z BD
public class User {
    @Id                                                      // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // AI in TABLE
    @Column(name = "user_id")
    private Long userId;
    @Email                                                  // waliduje adres emial
    @NotBlank                                               //@NotNull + @NotEmpty = @NotBlank
    private String email;
//    @Pattern(regexp = "^[A-Za-z0-9-_.]+[^#]$", message = "xxx")
//    @Min(value = 6)
//    @Size(min = 6, max = 255)
    private String password;
//    @DateTimeFormat(pattern = "YYYY-mm-dd HH:MM:SS")
    private LocalDateTime registerDate = LocalDateTime.now();
    @Basic(optional = true)
    private Boolean enable = true;
    @Transient                                              // wykluczenie z mapowania
    private Character gender;

    public void addPermission(Permission permission){
        this.roles.add(permission);
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_permission",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private Set<Permission> roles = new HashSet<>();

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "author")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "receiver")
    private List<Message> messages = new ArrayList<>();

    @OneToMany(mappedBy = "reviewer")
    private List<Comment> comments = new ArrayList<>();
}
