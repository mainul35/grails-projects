package grails.login.app

class Student extends User{
    String stdId
    int gender
    Date dateOfBirth
    String profileImageName
    static belongsTo = [semester: Semester, department: Department]

    static constraints = {
        name shared: "nonEmpty"
        role shared: "nonEmpty"
        semester nullable: true
        department nullable: true
        profileImageName nullable: true, blank: true
    }

    static mapping = {
        version false
        autoTimestamp true
    }
}
