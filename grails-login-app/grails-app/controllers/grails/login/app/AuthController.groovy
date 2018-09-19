package grails.login.app

class AuthController {

    AuthService authService

    def index(){
        redirect(controller: 'auth', action: '404')
    }

    def login() {
        if(params?.email && params?.password){
            if(authService.doLogin(params.email, params.password)){
                flash.message = [info: 'Log in Successful!', success: true]
                redirect(controller: 'user', action: 'dashboard')
                return
            } else {
                flash.message = [info: 'Log in Failed!', success: false]
            }
        }
    }

    def logout(){
        authService.logout()
        flash.message = [info: 'Log out Successful!', success: true]
        redirect(controller: 'auth', action: 'login')
        return
    }

    def '403'(){}

    def '404'(){}
}
