package grails.login.app

class UserController {

    UserService userService
    AuthService authService
    def dashboard() {
        User user = authService.getAuthentication().user
        log.info('dashboard(): admin = {}', user)
        if(user.role.equals('ROLE_ADMIN')){
                redirect(controller: "admin", action: "dashboard")
                return
        }else if(user.role.equals('ROLE_STUDENT')){
                redirect(controller: "student", action: "dashboard")
                return
        }
    }

    def register(){

        def msg = ''
        def status
        if(request.method == 'POST'){
            def user = userService.create(params)
            log.info('register(): user={}', user)
            if(!user){
                msg = 'Sorry, Failed to save!'
                status = false
                [msg: msg, status: status, user: user]
            }else{
                msg = 'Saved successfully!'
                status = true
                [msg: msg, status: status]
            }
        }
    }
}
