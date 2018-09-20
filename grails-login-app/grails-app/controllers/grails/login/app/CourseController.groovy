package grails.login.app

class CourseController {

    CourseService courseService
    AuthService authService

    def index() {
        redirect(controller: 'auth', action: '404')
    }

    def all() {
        render(view: 'all', model: [courses: courseService.getAll()])
    }

    def create() {
        if (!authService.getAuthentication().user.role.toString().equals('ROLE_ADMIN')) {
            redirect(controller: 'auth', action: '403')
            return
        }
        def returnedResult
        def status, msg
        Course course = new Course()
        course.name = params.name
        course.code = params.code
        try{
            if(params.courseCredits?.toString()?.equals('0')){
                course.courseCredits = null
                status = false
                msg = g.message(code: 'course.credit.non.zero')
                flash.message = [info: msg, success: status]
            }else{
                course.courseCredits = params?.courseCredits
            }

        }catch (Exception e){
            e.printStackTrace()
            course.courseCredits = null
            status = false
            msg = g.message(code: 'invalid.course.credit')
            flash.message = [info: msg, success: status]
        }

        if (course.validate()) {
            returnedResult = courseService.createCourse(course)

            if (returnedResult) {
                status = true
                msg = g.message(code: 'course.created')
            } else if (!returnedResult) {
                status = false
                msg = g.message(code: 'course.creation.failed')

            }
            flash.message = [info: msg, success: status]
            redirect(controller: 'course', action: 'all')
            return
        } else {
            render(view: 'createCourse')
        }
    }

    def edit(Integer id) {
        if (!authService.getAuthentication().user.role.toString().equals('ROLE_ADMIN')) {
            redirect(controller: 'auth', action: '403')
            return
        }
        [course: courseService.getCourse(id)]
    }

    def update() {
        if (!authService.getAuthentication().user.role.toString().equals('ROLE_ADMIN')) {
            redirect(controller: 'auth', action: '403')
            return
        }
        def returnedResult
        returnedResult = courseService.updateCourse(params)
        def status, msg
        if (returnedResult) {
            status = true
            msg = g.message(code: 'course.updated')
        } else if (!returnedResult) {
            status = false
            msg = g.message(code: 'course.not.updated')
        }
        flash.message = [info: msg, success: status]
        redirect(controller: 'course', action: 'all')
        return
    }

    def delete(Integer id) {
        if (!authService.getAuthentication().user.role.toString().equals('ROLE_ADMIN')) {
            redirect(controller: 'auth', action: '403')
            return
        }
        def returnedResult
        returnedResult = courseService.deleteCourse(id)
        def status, msg
        if (returnedResult) {
            status = true
            msg = g.message(code: 'course.deleted')
        } else if (!returnedResult) {
            status = false
            msg = g.message(code: 'course.not.deleted')
        }
        flash.message = [info: msg, success: status]
        redirect(controller: 'course', action: 'all')
        return
    }

    def details() {
        try {
            def course = courseService.getCourse(Long.parseLong(params.id))
            if(!course){
                redirect(controller: 'auth', action: '404')
                return
            }
            render(view: 'details', model: [course: course])
        } catch (Exception e){
            redirect(controller: 'auth', action: '404')

        }
    }

    def find() {
        def response = courseService.list(params)
        render(view: 'all', model: [courses: response.list, total:response.count])
    }
}
