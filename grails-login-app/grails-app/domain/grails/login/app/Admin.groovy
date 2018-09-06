package grails.login.app

class Admin extends User{

    static constraints = {
        role shared: "nonEmpty"
    }

    static mapping = {
        autoTimestamp true
        version false
    }
}
