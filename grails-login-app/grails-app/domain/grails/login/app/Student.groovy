package grails.login.app

class Student extends User{
    String stdId
    static belongsTo = [Semester, Department]
    Semester semester
    Department department
    static constraints = {
        name shared: "nonEmpty"
        role shared: "nonEmpty"
    }

    static mapping = {
        version false
        autoTimestamp true
    }
}
