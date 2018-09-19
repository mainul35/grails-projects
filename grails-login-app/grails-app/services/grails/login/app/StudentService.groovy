package grails.login.app

import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap

@Transactional
class StudentService {


    SemesterService semesterService
    DepartmentService departmentService

    def createStudent(Student student) {
        if (student.save()) {
            student.semester.students = semesterService.getStudentsBySemesterId(student.semester.id)
            student.semester.students.add(student)
            student.semester.save(flush: true)
            return true
        } else {
            return false
        }
    }

    boolean updateStudent(GrailsParameterMap params) {
        def student = getStudent(Long.parseLong(params.id))
        student.properties =  params
        if (student.validate()) {
            if (student.save()) {
                student.semester.students = semesterService.getStudentsBySemesterId(student.semester.id)
                student.semester.students.add(student)
                student.semester.save(flush: true)
                return true
            } else {
                return false
            }
        } else {
            return false
        }
    }

    def deleteStudent(Integer id) {
        def student = getStudent(id)
        try {
            student.delete(flush: true)
        } catch (Exception e) {
            println(e.getMessage())
            return false
        }
        return true
    }

    def getStudent(Serializable id) {
        return Student.get(id)
    }

    def getAll() {
        return Student.findAll()
    }

}
