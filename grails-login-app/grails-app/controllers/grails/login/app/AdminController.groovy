package grails.login.app

class AdminController {

    AuthService authService
    StudentService studentService
    SemesterService semesterService
    DepartmentService departmentService
    UploadService uploadService
    AdminService adminService
    def assetResourceLocator
    UserService userService

    def index(){
        redirect(controller: 'auth', action: '404')
    }

    def dashboard() {
        if(!authService.getAuthentication().user.role.toString().equals('ROLE_ADMIN')){
            redirect(controller: 'auth', action: '403')
            return
        }
        [admin: authService.getAuthentication().user]
    }


    def 'register-student'() {
        if(!authService.getAuthentication().user.role.toString().equals('ROLE_ADMIN')){
            redirect(controller: 'auth', action: '403')
            return
        }
        if (!params) {
            render(view: 'createStudent')
            return
        } else {
            def returnedResult
            Student student = new Student(params)
            student.role = 'ROLE_STUDENT'
            if (params.image) {
                student.profileImageName = uploadService.upload(request.getFile('image'), params)
            }
            if (student.validate()) {
                returnedResult = studentService.createStudent(student)
                def status, msg
                if (returnedResult) {
                    status = true
                    msg = g.message(code: 'student.created')
                } else if (!returnedResult) {
                    status = false
                    msg = g.message(code: 'student.creation.failed')
                }
                flash.message = [info: msg, success: status]
                redirect(controller: 'student', action: 'all')
            } else {

                render(view: 'createStudent',
                        model: [
                                semesters  : semesterService.getAll(),
                                departments: departmentService.getAll()
                        ]
                )
            }
        }
    }

    def edit(Integer id) {
        if (!Integer.toString(id).equals(authService.authentication.user.id.toString())) {
            redirect(controller: 'auth', action: '403')
            return
        }
        [user: adminService.getAdmin(id)]
    }

    def update() {
        if (authService.authentication.user.role.equals('ROLE_ADMIN')) {
            if (!params.id.toString().equals(authService.authentication.user.id.toString())) {
                redirect(controller: 'auth', action: '403')
                return
            }
        } else {
            redirect(controller: 'auth', action: '403')
            return
        }
        def status, msg
        def returnedResult
        if (params.image) {
            params.profileImageName = uploadService.upload(request.getFile('image'), params)
        }
        returnedResult = adminService.updateAdmin(params)
        if (returnedResult) {
            status = true
            authService.getAuthentication().user = userService.getUser(authService.getAuthentication().user.id)
            msg = g.message(code: 'admin.profile.updated')
        } else if (!returnedResult) {
            status = false
            msg = g.message(code: 'admin.profile.update.failed')
        }
        flash.message = [info: msg, success: status]
        redirect(controller: 'admin', action: 'profile')
        return
    }

    def profile() {
        if(!authService.getAuthentication().user.role.toString().equals('ROLE_ADMIN')){
            redirect(controller: 'auth', action: '403')
            return
        }
        Long id = params.id ?Long.parseLong(params.id): authService.getAuthentication().user.id

        if (!adminService.getAdmin(id) || !id.toString().equals(authService.authentication.user.id.toString())) {
            redirect(controller: 'auth', action: '403')
            return
        }
        def admin = adminService.getAdmin(id)
        if (admin) {
            render(view: 'dashboard', model: [admin: admin])
        } else {
            redirect(controller: 'auth', action: '404')
        }
    }
}