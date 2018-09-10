package grails.login.app

class Student extends User{
    Long id
    String stdId
    String gender
    Date dateOfBirth
    String batch
    String department
    static belongsTo = [semester: Semester]

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
