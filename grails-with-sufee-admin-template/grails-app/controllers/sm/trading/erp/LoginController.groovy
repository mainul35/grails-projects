package sm.trading.erp

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.authentication.encoding.BCryptPasswordEncoder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.annotation.Secured
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.savedrequest.HttpSessionRequestCache
import org.springframework.security.web.savedrequest.SavedRequest

import javax.servlet.http.HttpServletResponse


class LoginController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    UserService userService

    def 'auth'() {
        if(SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            Set<String> roles = (Set<String>) SecurityContextHolder.getContext().getAuthentication().getAuthorities()
            for (def role : roles) {
                if (role.authority.equals('ROLE_ADMIN')) {
                    redirect(controller: 'admin', action: 'dashboard')
                    return
                }
            }
        } else {
            render(view: '/login/auth')
        }
    }

    def 'secure'() {
        if(SecurityContextHolder.getContext().getAuthentication().isAuthenticated()){
            Set<String> roles = (Set<String>)SecurityContextHolder.getContext().getAuthentication().getAuthorities()
            for (def role : roles) {
                if (role.authority.equals('ROLE_ADMIN')) {
                    redirect(controller: 'admin', action: 'dashboard')
                    return
                }else {

                    redirect(controller: 'user', action: 'newsfeed')
/*                    render 'you have been logged in but no page has been found \n\
                            for you. Please contact Admin with your registered \n\
                            email address mentioning the issue.'*/
                }
            }
        } else {
            redirect(controller: 'login', action: 'auth')
        }
    }

    def 'processing'(User user) {

        User user1 = user.username?.contains('@')?User.findByEmail(user.username):User.findByUsername(user.username)
        log.info 'in login/processing : {}', user1
        if (user1) {
            if (passwordEncoder.isPasswordValid(user1.getPassword(), user.getPassword(), null)) {
                Authentication authentication = new CustomAuthentication(user1)
                authentication.setAuthenticated(true);
                SecurityContextHolder.getContext().setAuthentication(authentication);

                //springSecurityService.setAuthenticated(true)
                //set our response to OK status
                response.setStatus(HttpServletResponse.SC_OK);

                //since we have created our custom success handler, its up to us to where
                //we will redirect the user after successfully login
                SavedRequest savedRequest = new HttpSessionRequestCache().getRequest(request, response);
                //String requestUrl = savedRequest.getRedirectUrl();
                response.sendRedirect("/login/secure/"); //requestUrl!=null?requestUrl:
                return
            }
        }else{
            render view: '/login/auth'
            return
        }
    }
}
