package grails.login.app

class AuthController {

    AuthService authService
    def login() {
        log.info('login(): {}', params)
        if(authService.doLogin(params.email, params.password)){
            redirect(controller: 'user', action: 'dashboard')
            return
        }
    }

    def logout(){
        authService.logout()
        redirect(controller: 'auth', action: 'login')
        return
    }
}
