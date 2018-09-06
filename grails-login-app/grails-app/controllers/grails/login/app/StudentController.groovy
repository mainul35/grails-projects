package grails.login.app

class StudentController {

    AuthService authService

    def dashboard() {
        log.info('dashboard(): {}', authService.getAuthentication())
        [user: authService.getAuthentication().user]
    }
}
