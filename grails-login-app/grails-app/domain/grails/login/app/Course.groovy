package grails.login.app

class Course {

    Long id
    String name
    String code
    String courseCredits
    static belongsTo = Semester
    static constraints = {
        name shared: "nonEmpty"
        code shared: "nonEmpty", unique: true
        courseCredits shared: "nonEmpty"
    }

    static mapping = {
        version false

    }
}
