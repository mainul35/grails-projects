package grails.login.app

import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap

@Transactional
class SemesterService {
    CourseService courseService
    GlobalConfigService globalConfigService
    def createSemester(Semester semester) {
        if (semester.save(flush: true)) {
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

    def getSemester(String name){
        return Semester.findByName(name)
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

    Set<Student> getStudentsBySemesterId(Serializable id){
        Semester.findById(id).students
    }

    def list(GrailsParameterMap params) {
        params.max = params.max ?: globalConfigService.itemsPerPage()
        List<Semester> semesterList = Semester.createCriteria().list(params) {
            if (params?.colName && params?.colValue) {
                like(params.colName, "%" + params.colValue + "%")
            }
            if (!params.sort) {
                order("id", "desc")
            }
        }
        return [list: semesterList, count: Semester.count()]
    }
}
