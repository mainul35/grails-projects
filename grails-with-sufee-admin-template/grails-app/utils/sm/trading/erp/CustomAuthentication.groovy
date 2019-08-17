package sm.trading.erp;

import grails.plugin.springsecurity.authentication.encoding.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CustomAuthentication implements Authentication {
    private boolean authenticated;
    private User user = new User()

    CustomAuthentication() {
        user = new User()
        user.username = 'anonymous'
        Role role = new Role()
        role.setAuthority('ROLE_ANONYMOUS')
        user.roles = new ArrayList<Role>()
        user.roles.add(role)
//        for (def role1: user.roles){
//            role1.user = user
//        }
        user.setEnabled(false)
    }

    public CustomAuthentication(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities();
    }

    @Override
    public Object getCredentials() {
        return user.getPassword();
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.user;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return this.user.getUsername();
    }


    @Override
    public String toString() {
        return "CustomAuthentication{" +
                "authenticated=" + authenticated +
                ", user=" + user +
                '}';
    }
}
