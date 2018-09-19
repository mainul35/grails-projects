package grails.login.app

import grails.core.GrailsApplication
import grails.util.Holders

class AuthInterceptor {

    AuthService authService
    RequestMapService requestMapService

    AuthInterceptor() {
        matchAll()
                .excludes(contrller: 'auth', action: 'login')
                .excludes(contrller: 'user', action: 'register-student')
    }

    boolean before() {

        if (!authService.isAuthenticated()) {
            redirect(controller: "auth", action: "login")
            return false
        }
        return true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }

}
