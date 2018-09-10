package grails.login.app

class AdminController {

    AuthService authService
    StudentService studentService

    def dashboard() {
        log.info('dashboard(): {}', authService.getAuthentication())
        [user: authService.getAuthentication().user]
    }

    def 'create-semester'(){
        render(view: '/semester/createSemester', model: [courses: Course.findAll()])
    }

    def 'create-student'(){
        render(view: 'createStudent', model: [semesters: Semester.findAll()])
    }

    def 'register-student'(Student student){
        def msg = ''
        def status
        if(request.method == 'POST'){
            def user = studentService.create(params)
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
