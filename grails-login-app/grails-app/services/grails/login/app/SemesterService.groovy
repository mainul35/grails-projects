package grails.login.app

import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap

@Transactional
class SemesterService {
    CourseService courseService

    def createSemester(Semester semester) {
        log.info('createSemester(): {}', semester)
        if (semester.save()) {
            return true
        } else {
            return false
        }
    }

    boolean updateSemester(GrailsParameterMap params) {
        def semester = getSemester(Long.parseLong(params.id))
        if (semester.validate()) {
            semester.name = params?.name
            semester.duration = params?.duration
            semester.academicYear = params?.academicYear
            semester.offeredCourses.clear()
            semester.offeredCourses.addAll(courseService.getListMatchedWithId(params.offeredCourses))
            for (def course in semester.offeredCourses){
                course.semester = semester
            }
            log.info('updateSemester(): {}', semester)
            if (semester.save(flush: true)) {
                return true
            } else {
                return false
            }
        } else {
            return false
        }
    }

    def deleteSemester(Integer id) {
        def semester = getSemester(id)
        try {
            semester.delete(flush: true)
        } catch (Exception e) {
            println(e.getMessage())
            return false
        }
        return true
    }

    def getSemester(Serializable id){
        return Semester.findById(id)
    }

    def getAll(){
        return Semester.findAll()
    }

    Set<Semester> getListMatchedWithId(def ids) {
        Set<Semester> semesters = new HashSet<>();
        for(def id in ids){
            semesters.add(getSemester(id))
        }
        return semesters
    }

}
