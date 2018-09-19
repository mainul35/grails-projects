package grails.login.app

class SemesterController {

    SemesterService semesterService
    CourseService courseService
    AuthService authService

    def index(){
        redirect(controller: 'auth', action: '404')
    }

    def all() {
        render(view: 'all', model: [semesters: semesterService.all])
    }

    def create() {
        if(!authService.getAuthentication().user.role.toString().equals('ROLE_ADMIN')){
            redirect(controller: 'auth', action: '403')
            return
        }
        def returnedResult
        Semester semester = new Semester(params)
        if (semester.validate()) {
            returnedResult = semesterService.createSemester(semester)
            def status, msg
            if (returnedResult) {
                status = true
                msg = g.message(code: 'semester.created')
            } else if (!returnedResult) {
                status = false
                msg = g.message(code: 'semester.not.created')
            }
            flash.message = [info: msg, success: status]
            redirect(controller: 'semester', action: 'all')
            return
        } else {
            render(view: 'createSemester', model: [courses: courseService.getAll()])
        }
    }

    def edit(Integer id) {
        if(!authService.getAuthentication().user.role.toString().equals('ROLE_ADMIN')){
            redirect(controller: 'auth', action: '403')
            return
        }
        [semester: semesterService.getSemester(id), courses: courseService.all]
    }

    def update() {
        if(!authService.getAuthentication().user.role.toString().equals('ROLE_ADMIN')){
            redirect(controller: 'auth', action: '403')
            return
        }
        def returnedResult
        returnedResult = semesterService.updateSemester(params)
        def status, msg
        if (returnedResult) {
            status = true
            msg = 'semester updated'
        } else if (!returnedResult) {
            status = false
            msg = 'semester could not be updated'
        }
        flash.message = [info: msg, success: status]
        redirect(controller: 'semester', action: 'all')
        return
    }

    def delete(Integer id){
        if(!authService.getAuthentication().user.role.toString().equals('ROLE_ADMIN')){
            redirect(controller: 'auth', action: '403')
            return
        }
        def returnedResult
        def status, msg
        if(semesterService.getSemester(id).students.size()>0){
            status = false
            msg = 'Semester could not be deleted because it contains students.'
            flash.message = [info: msg, success: status]
            redirect(controller: 'department', action: 'all')
            return
        }
        returnedResult = semesterService.deleteSemester(id)
        if (returnedResult) {
            status = true
            msg = 'semester deleted'
        } else if (!returnedResult) {
            status = false
            msg = 'semester could not be deleted'
        }
        flash.message = [info: msg, success: status]
        redirect(controller: 'semester', action: 'all')
        return
    }

    def details() {
        try {
            def semester = semesterService.getSemester(Long.parseLong(params.id))
            render(view: 'details', model: [semester: semester])
        } catch (Exception e){
            redirect(controller: 'auth', action: '404')

        }
    }
}
