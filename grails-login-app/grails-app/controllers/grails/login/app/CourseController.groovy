package grails.login.app

class CourseController {

    CourseService courseService
    AuthService authService

    def index(){
        redirect(controller: 'auth', action: '404')
    }

    def all() {
        render(view: 'all', model: [courses: courseService.getAll()])
    }

    def create() {
        if(!authService.getAuthentication().user.role.toString().equals('ROLE_ADMIN')){
            redirect(controller: 'auth', action: '403')
            return
        }
        def returnedResult
        Course course = new Course()
        course.name = params.name
        course.code = params.code
        course.courseCredits = params.courseCredits
        if (course.validate()) {
            returnedResult = courseService.createCourse(course)
            def status, msg
//            log.info('create(): {}', returnedResult)
            if (returnedResult) {
                status = true
                msg = 'Course created'
            } else if (!returnedResult) {
                status = false
                msg = 'Course could not be created'

            }
//            render(view: 'createCourse', model: [status: status, msg: msg])
            flash.message = [info: msg, success: status]
            redirect(controller: 'course', action: 'all')
            return
        } else {
            render(view: 'createCourse')
        }
    }

    def edit(Integer id) {
        if(!authService.getAuthentication().user.role.toString().equals('ROLE_ADMIN')){
            redirect(controller: 'auth', action: '403')
            return
        }
//        log.info('edit(): {}', id)
        [course: courseService.getCourse(id)]
    }

    def update() {
        if(!authService.getAuthentication().user.role.toString().equals('ROLE_ADMIN')){
            redirect(controller: 'auth', action: '403')
            return
        }
        def returnedResult
        returnedResult = courseService.updateCourse(params)
        def status, msg
//        log.info('update(): {}', returnedResult)
        if (returnedResult) {
            status = true
            msg = 'Course updated'
        } else if (!returnedResult) {
            status = false
            msg = 'Course could not be updated'
        }
//        render(view: 'all', model: [status: status, msg: msg, courses: courseService.getAll()])
        flash.message = [info: msg, success: status]
        redirect(controller: 'course', action: 'all')
        return
    }

    def delete(Integer id){
        if(!authService.getAuthentication().user.role.toString().equals('ROLE_ADMIN')){
            redirect(controller: 'auth', action: '403')
            return
        }
        def returnedResult
        returnedResult = courseService.deleteCourse(id)
        def status, msg
//        log.info('delete(): {}', returnedResult)
        if (returnedResult) {
            status = true
            msg = 'Course deleted'
        } else if (!returnedResult) {
            status = false
            msg = 'Course could not be deleted'
        }
//        render(view: 'all', model: [status: status, msg: msg, courses: courseService.getAll()])
        flash.message = [info: msg, success: status]
        redirect(controller: 'course', action: 'all')
        return
    }

}
