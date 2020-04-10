package sys.auth.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User extends Audit  {
    public User() { }

    public User(@NotBlank(message = "UserName is Required") String userName,
                @NotBlank @javax.validation.constraints.Email(message = "should be email!") String Email,
                @NotBlank(message = "Password is required") String password) {
        this.userName = userName;
        email = Email;
        Password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @Column(columnDefinition = "text", name = "userName")
    @NotBlank(message = "UserName is Required")
    private String userName;

    @NotBlank
    @Email(message = "should be email!")
    @Column(unique = true)
    private String email;
    @NotBlank(message = "Password is required")
    private String Password;
    @Transient
    private String ConfirmPassword;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + id +
                ", UserName='" + userName + '\'' +
                ", Email='" + email + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
