package grails.login.app

class Student extends User{

    String stdId
    String gender
    Date dateOfBirth
    String batch
    Semester currentSemester
    String department

    static constraints = {
        name shared: "nonEmpty"
        batch shared: "nonEmpty"
        department shared: "nonEmpty"
        role shared: "nonEmpty"
    }

    static mapping = {
        version false
        autoTimestamp true
    }
}
