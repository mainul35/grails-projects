package sm.trading.erp

import grails.persistence.Entity
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
class User implements UserDetails{
    long id
    String username
    String password
    boolean enabled = true
    String firstName
    String lastName
    String email
    String contact
    String position
    String address
    String profileImage
    Date joiningDate = null
    Date leavingDate = null
    boolean accountExpired = false
    boolean accountLocked = false
    boolean passwordExpired = false
    static hasMany = [roles: Role]
    static constraints = {
        firstName nullable: false, blank: false
        lastName nullable: true, blank: true
        username nullable: true, blank: true, unique: true
        email unique: true, nullable: false, blank: false, email: true
        password nullable: false, blank: false
        address nullable: true
        position nullable: false, blank: false
        contact nullable: false, blank: false
        joiningDate nullable: true
        leavingDate nullable: true
        profileImage nullable: true, blank: true
//        roles nullable: true
    }

    static mapping = {
        version false
    }

    User(String username, String password) {
        this.username = username
        this.password = password
    }


    Collection<? extends GrantedAuthority> getAuthorities() {
        return roles
    }

    @Override
    boolean isAccountNonExpired() {
        return false
    }

    @Override
    boolean isAccountNonLocked() {
        return false
    }

    @Override
    boolean isCredentialsNonExpired() {
        return false
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", roles=" + roles +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", position='" + position + '\'' +
                ", address='" + address + '\'' +
                ", profileImage='" + profileImage + '\'' +
                ", joiningDate=" + joiningDate +
                ", leavingDate=" + leavingDate +
                ", accountExpired=" + accountExpired +
                ", accountLocked=" + accountLocked +
                ", passwordExpired=" + passwordExpired +
                '}';
    }
}
