package grails.login.app

class User {
    Long id
    String email
    String password
    String name
    String role

    Date dateCreated
    Date lastUpdated

    static constraints = {
        email shared: "nonEmpty", email: true, unique: true
        name shared: "nonEmpty", size: 2..30
        password shared: "nonEmpty", size: 5..20
        role shared: "nonEmpty"
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
