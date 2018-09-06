package grails.login.app

class RequestMap implements Serializable{
    Long id
    String url
    String role

    static constraints = {
        url shared: "nonEmpty"
        role shared: "nonEmpty"
//        id composite: ['url', 'role']
    }

    static mapping = {
        version: false
    }
}
