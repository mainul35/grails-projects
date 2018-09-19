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
//        log.info('create(): {}', params)
        Semester semester = new Semester(params)
        if (semester.validate()) {
            returnedResult = semesterService.createSemester(semester)
            def status, msg
//            log.info('create(): {}', returnedResult)
            if (returnedResult) {
                status = true
                msg = 'semester created'
            } else if (!returnedResult) {
                status = false
                msg = 'semester could not be created'
            }
//            render(view: 'createSemester', model: [status: status, msg: msg, courses: courseService.all])
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
//        log.info('edit(): {}', id)
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
//        log.info('update(): {}', returnedResult)
        if (returnedResult) {
            status = true
            msg = 'semester updated'
        } else if (!returnedResult) {
            status = false
            msg = 'semester could not be updated'
        }
//        render(view: 'all', model: [status: status, msg: msg, semesters: semesterService.all])
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
        returnedResult = semesterService.deleteSemester(id)
        def status, msg
//        log.info('delete(): {}', returnedResult)
        if (returnedResult) {
            status = true
            msg = 'semester deleted'
        } else if (!returnedResult) {
            status = false
            msg = 'semester could not be deleted'
        }
//        render(view: 'all', model: [status: status, msg: msg, semesters: semesterService.all])
        flash.message = [info: msg, success: status]
        redirect(controller: 'semester', action: 'all')
        return
    }
}
