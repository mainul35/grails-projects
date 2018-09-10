package grails.login.app

class Course {

    Long id
    String name
    String code
    String courseCredits
    static belongsTo = [semester: Semester]
    static constraints = {
        name shared: "nonEmpty"
        code shared: "nonEmpty", unique: true
        semester nullable: true
    }

    static mapping = {
        version false

    }
}
