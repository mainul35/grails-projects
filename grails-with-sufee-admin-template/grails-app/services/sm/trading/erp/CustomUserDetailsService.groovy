package sm.trading.erp

import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CustomUserDetailsService implements UserDetailsService{
    UserService userService

    org.springframework.security.core.userdetails.User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = User.findByUsername(username)
        org.springframework.security.core.userdetails.User user1 = new org.springframework.security.core.userdetails.User(user.username, user.password, user.authorities)
        return user1
    }
}
