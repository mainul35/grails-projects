package grails.login.app

class User {

    String email
    String password
    String name = 'Anonymous'

    Date created
    Date updated

    static constraints = {
        email email: true, nullable: false, blank: false, unique: true
        name blank: false, size: 2..30
        password nullable: false, blank: false, size: 5..20
    }
    
    static mapping = {
        version false
    }

    def beforeInsert (){
        this.password = this.password.encodeAsBase64()
    }


    def beforeUpdate(){
        this.password = this.password.encodeAsBase64()
    }
}
