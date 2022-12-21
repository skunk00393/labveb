package mk.finki.ukim.mk.lab.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;

@Data
@Entity
@Table(name = "balloon_users")
public class User implements UserDetails {

    private Long id;
    @Id
    private String username;
    private String name;
    private String surname;
    private String password;
    private LocalDate dateOfBirth;

    public User(){}
    public User(String username, String name, String surname, String password, Role role){
        this.username=username;
        this.name = name;
        this.surname = surname;
        this.password= password;
        this.role = role;
    }

    @Enumerated(value = EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<ShoppingCart> carts;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
