package grails.login.app

class Semester {

    Integer id
    String name
    Integer duration
    static hasMany = [offeredCourses: Course]

    static constraints = {
        name shared: "nonEmpty"
        duration shared: "nonEmpty"
    }

    static mapping = {
        version false
    }

}
