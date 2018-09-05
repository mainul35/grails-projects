package grails.login.app

class UserController {

    UserService userService
    AuthService authService
    def dashboard() {
        log.info('dashboard(): {}', authService.getAuthentication())
        [user: authService.getAuthentication().user]
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
