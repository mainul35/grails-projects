package grails.login.app

class Course {

    Integer id
    String name
    String code
    Integer credits

    static constraints = {
        name shared: "nonEmpty"
        code shared: "nonEmpty", unique: true
        credits shared: "nonEmpty"
    }

    static mapping = {
        version false
    }

}
