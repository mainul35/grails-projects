package grails.login.app

import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap

@Transactional
class CourseService {
    GlobalConfigService globalConfigService

    def createCourse(Course course) {
        if (course.save()) {
            return true
        } else {
            return false
        }
    }

    boolean updateCourse(GrailsParameterMap params) {
        def course = getCourse(Long.parseLong(params.id))
        if (course.validate()) {
            course.name = params.name
            course.code = params.code
            course.courseCredits = params.courseCredits

            if (course.save(flush: true)) {
                return true
            } else {
                return false
            }
        } else {
            return false
        }
    }

    def deleteCourse(Integer id) {
        def course = getCourse(id)
        try {
            course.delete(flush: true)
        } catch (Exception e) {
            println(e.getMessage())
            return false
        }
        return true
    }

    def getCourse(Serializable id){
        return Course.get(id)
    }

    def getAll(){
        return Course.findAll()
    }

    Set<Course> getListMatchedWithId(def ids) {
        Set<Course> courses = new HashSet<>();
        for(def id in ids){
            courses.add(getCourse(id))
        }
        return courses
    }

    def list(GrailsParameterMap params) {
        params.max = params.max ?: globalConfigService.itemsPerPage()
        List<Course> courseList = Course.createCriteria().list(params) {
            if (params?.colName && params?.colValue) {
                like(params.colName, "%" + params.colValue + "%")
            }
            if (!params.sort) {
                order("id", "desc")
            }
//            eq("member", memberService.getCurrentMember())
        }
        return [list: courseList, count: Course.count()]
    }
}
