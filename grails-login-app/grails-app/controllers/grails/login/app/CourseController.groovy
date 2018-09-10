package grails.login.app

class CourseController {

    CourseService courseService


    def 'view-all-courses'() {
        render(view: 'view-all-courses', model: [courses: courseService.getAll()])
    }

    def 'create-course'() {
        def returnedResult
        Course course = new Course()
        course.name = params.name
        course.code = params.code
        course.courseCredits = params.courseCredits
        if (course.validate()) {
            returnedResult = courseService.createCourse(course)
            def status, msg
            log.info('create-course(): {}', returnedResult)
            if (returnedResult) {
                status = true
                msg = 'Course created'
            } else if (!returnedResult) {
                status = false
                msg = 'Course could not be created'

            }
            render(view: 'createCourse', model: [status: status, msg: msg])
        } else {
            render(view: 'createCourse')
        }
    }

    def 'edit'(Integer id) {
        log.info('edit(): {}', id)
        [course: courseService.getCourse(id)]
    }

    def 'update'() {
        def returnedResult
        returnedResult = courseService.updateCourse(params)
        def status, msg
        log.info('update(): {}', returnedResult)
        if (returnedResult) {
            status = true
            msg = 'Course updated'
        } else if (!returnedResult) {
            status = false
            msg = 'Course could not be updated'
        }
        render(view: 'view-all-courses', model: [status: status, msg: msg, courses: Course.findAll()])
    }

    def delete(Integer id){
        def returnedResult
        returnedResult = courseService.deleteCourse(id)
        def status, msg
        log.info('delete(): {}', returnedResult)
        if (returnedResult) {
            status = true
            msg = 'Course deleted'
        } else if (!returnedResult) {
            status = false
            msg = 'Course could not be deleted'
        }
        render(view: 'view-all-courses', model: [status: status, msg: msg, courses: Course.findAll()])
    }

}
