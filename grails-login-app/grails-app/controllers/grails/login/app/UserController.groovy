package grails.login.app

import grails.converters.JSON

class UserController {

    UserService userService
    AuthService authService

    def index(){
        redirect(controller: 'auth', action: '404')
    }

    def dashboard() {
        User user = authService.getAuthentication()?.user
        if(user?.role?.equals('ROLE_ADMIN')){
                flash.message = flash.message
                redirect(controller: "admin", action: "dashboard")
                return
        }else if(user?.role?.equals('ROLE_STUDENT')){
                flash.message = flash.message
                redirect(controller: "student", action: "dashboard")
                return
        }
    }

    def checkEmailInDb(){
        if(params.email){
            render userService.isDuplicate(params.email)?'200':'404'
        }
    }
}
