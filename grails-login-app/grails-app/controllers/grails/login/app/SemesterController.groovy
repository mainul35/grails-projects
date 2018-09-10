package grails.login.app

class SemesterController {

    SemesterService semesterService
    CourseService courseService

    def 'view-all-semesters'() {
        render(view: 'view-all-semesters', model: [semesters: semesterService.all])
    }

    def 'create-semester'() {
        def returnedResult
        log.info('create-semester(): {}', params)
        Semester semester = new Semester()
        semester.name = params?.name
        semester.duration = params?.duration
        semester.academicYear = params?.academicYear
        Set<Course> courses = courseService.getListMatchedWithId(params?.offeredCourses)

        log.info('offered courses: {}', courses)
        semester.offeredCourses = courses
        for (def course in semester.offeredCourses){
            course.semester = semester
        }
        if (semester.validate()) {
            returnedResult = semesterService.createSemester(semester)
            def status, msg
            log.info('create-semester(): {}', returnedResult)
            if (returnedResult) {
                status = true
                msg = 'semester created'
            } else if (!returnedResult) {
                status = false
                msg = 'semester could not be created'
            }
            render(view: 'createSemester', model: [status: status, msg: msg, courses: courseService.all])
        } else {
            render(view: 'createSemester', model: [courses: courseService.all])
        }
    }

    def 'edit'(Integer id) {
        log.info('edit(): {}', id)
        [semester: semesterService.getSemester(id), courses: courseService.all]
    }

    def 'update'() {
        def returnedResult
        returnedResult = semesterService.updateSemester(params)
        def status, msg
        log.info('update(): {}', returnedResult)
        if (returnedResult) {
            status = true
            msg = 'semester updated'
        } else if (!returnedResult) {
            status = false
            msg = 'semester could not be updated'
        }
        render(view: 'view-all-semesters', model: [status: status, msg: msg, semesters: semesterService.all])
    }

    def delete(Integer id){
        def returnedResult
        returnedResult = semesterService.deleteSemester(id)
        def status, msg
        log.info('delete(): {}', returnedResult)
        if (returnedResult) {
            status = true
            msg = 'semester deleted'
        } else if (!returnedResult) {
            status = false
            msg = 'semester could not be deleted'
        }
        render(view: 'view-all-semesters', model: [status: status, msg: msg, semesters: semesterService.all])
    }
}
