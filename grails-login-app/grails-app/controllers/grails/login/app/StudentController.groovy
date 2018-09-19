package grails.login.app

class StudentController {

    AuthService authService
    StudentService studentService
    SemesterService semesterService
    DepartmentService departmentService
    UploadService uploadService
    UserService userService

    def index(){
        redirect(controller: 'auth', action: '404')
    }

    def dashboard() {
        def id = params?.id ?: authService.authentication.user.id
        def student = studentService.getStudent(id)
        if (student) {
            render(view: 'view-profile', model: [student: student])
        } else {
            redirect(controller: 'auth', action: '404')
        }
    }

    def all() {
        render(view: 'all', model: [students: studentService.getAll()])
    }

    def edit(Integer id) {
        if (!(authService.authentication.user.role.equals('ROLE_ADMIN')
                || authService.authentication.user.role.equals('ROLE_STUDENT'))){
            redirect(controller: 'auth', action: '403')
            return
        }

        if(authService.authentication.user.role.equals('ROLE_ADMIN')
            && !studentService.getStudent(id)){
            redirect(controller: 'auth', action: '404')
            return
        }

        if(authService.authentication.user.role.equals('ROLE_STUDENT')
                && !studentService.getStudent(id)){
            redirect(controller: 'auth', action: '403')
            return
        }

        if(authService.authentication.user.role.equals('ROLE_STUDENT') && !Integer.toString(id).equals(authService.authentication.user.id.toString())){
            redirect(controller: 'auth', action: '403')
            return
        }
        [
                user    : studentService.getStudent(id),
                semesters  : semesterService.getAll(),
                departments: departmentService.getAll()
        ]
    }

    def update() {

        if (!(authService.authentication.user.role.equals('ROLE_ADMIN')
                || authService.authentication.user.role.equals('ROLE_STUDENT'))){
            redirect(controller: 'auth', action: '403')
            return
        }

        if(authService.authentication.user.role.equals('ROLE_STUDENT')
                && !studentService.getStudent(Long.parseLong(params.id))
        ){
            redirect(controller: 'auth', action: '403')
            return
        }

        if(authService.authentication.user.role.equals('ROLE_STUDENT')
                && !Long.toString(Long.parseLong(params.id)).equals(authService.authentication.user.id.toString())){
            redirect(controller: 'auth', action: '403')
            return
        }
        def status, msg
        def returnedResult
        if (params.image) {
            params.profileImageName = uploadService.upload(request.getFile('image'), params)
        }
        returnedResult = studentService.updateStudent(params)

        if (returnedResult) {
            status = true
            authService.getAuthentication().user = userService.getUser(authService.getAuthentication().user.id)
            msg = 'student updated'
        } else if (!returnedResult) {
            status = false
            msg = 'student could not be updated'
        }
        flash.message = [info: msg, success: status]
        flash.id = params.id
        redirect(controller: 'student', action: 'profile')
        return
    }

    def delete(Integer id) {
        if (!authService.authentication.user.role.equals('ROLE_ADMIN')) {
            redirect(controller: 'auth', action: '403')
            return
        }
        def returnedResult
        returnedResult = studentService.deleteStudent(id)
        def status, msg
        if (returnedResult) {
            status = true
            msg = 'student deleted'
        } else if (!returnedResult) {
            status = false
            msg = 'student could not be deleted'
        }
        flash.message = [info: msg, success: status]
        redirect(controller: 'student', action: 'all')
        return
    }


    def profile() {

        def id = params?.id ?Long.parseLong(params?.id):
                flash.id?Long.parseLong(flash.id):
                        authService.authentication.user.id
        if(authService.authentication.user.role.equals('ROLE_STUDENT')){
            if (!studentService.getStudent(id) ||
                    !id.toString().equals(authService.authentication.user.id.toString())) {
                redirect(controller: 'auth', action: '403')
                return
            }
        }

        def student = studentService.getStudent(id)
        if (student) {
            render(view: 'view-profile', model: [student: student])
        } else {
            redirect(controller: 'auth', action: '404')
        }
    }
}
