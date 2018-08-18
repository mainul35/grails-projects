package sms

import grails.converters.JSON
import org.springframework.http.HttpStatus

class SmsController {

    def 'add'(Student student) {

        if (student == null) {
//            render status: HttpStatus.NOT_FOUND
            respond view: '/sms/add'
            return
        }

        if (Student.findByName(student.name)) {
            respond student.errors, view: '/sms/add'
            return
        }

        if (student.hasErrors()) {
            respond student.errors, view: '/sms/add'
            return
        }

        student.save(flush: true)

        request.withFormat {
            form multipartForm { redirect(controller: "sms", action: "display-all") }
            '*' { respond student, status: HttpStatus.CREATED }
        }
        
        
        if (!Student.findByName(student.name)){
            student.save(flush: true)
            redirect(controller: "sms", action: "display-all")
        }else {

        }
    }

    def 'find-by-name'(String name) {
        render(Student.findByName(name) as JSON ?: "{}")
    }

    def 'display-all'() {
        List<Student> students = Student.findAll()
        def message = students.size() < 1 ? "Sorry, No data Found!" : "Displaying all data"
        [students: students, message: message]
    }

    def 'search'(String name) {
    }
}
