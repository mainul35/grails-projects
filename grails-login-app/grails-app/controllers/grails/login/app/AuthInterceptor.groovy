package grails.login.app


class AuthInterceptor {

    AuthService authService

    AuthInterceptor(){
        matchAll()
                .excludes(contrller: 'auth', action: 'login')
                .excludes(contrller: 'user', action: 'register')
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
