package grails.login.app

class Semester {

    Long id
    String name
    String duration
    Date academicYear
    static hasMany = [offeredCourses: Course, students: Student]

    static constraints = {
        name shared: "nonEmpty"
        duration shared: "nonEmpty"
        offeredCourses nullable: true
        students nullable: true
    }

    static mapping = {
        version false
        students(cascade: 'all-delete-orphan')
    }

}
