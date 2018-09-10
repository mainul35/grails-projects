package grails.login.app

class AuthController {

    AuthService authService
    def login() {
        log.info('login(): {}', params)
        if(params?.email && params?.password){
            if(authService.doLogin(params.email, params.password)){
                redirect(controller: 'user', action: 'dashboard')
                return
            } else {
                [msg: 'Log in failed!', status: false]
            }
        }
    }

    def logout(){
        authService.logout()
        redirect(controller: 'auth', action: 'login', model: [msg: 'Logged out successfully!', action: true])
        return
    }
}
