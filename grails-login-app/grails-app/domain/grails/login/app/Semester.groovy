package grails.login.app

class Semester {

    Long id
    String name
    String duration
    static hasMany = [offeredCourses: Course]

    static constraints = {
        name shared: "nonEmpty"
        duration shared: "nonEmpty"
    }

    static mapping = {
        version false
//        offeredCourses(cascade: 'all-delete-orphan')
    }

}
