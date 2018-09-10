package grails.login.app

class Department {

    Long id
    String name
    static hasMany = [students: Student]
    static constraints = {
        name shared: "nonEmpty"
        students nullable: true
    }

    static mapping = {
        version false
        students(cascade: 'all-delete-orphan')
    }
}
