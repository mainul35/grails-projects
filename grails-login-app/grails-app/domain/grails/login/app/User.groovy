package grails.login.app

class User {
    Long id
    String email
    String password
    String name
    String role
    Integer gender
    Date dateOfBirth
    String profileImageName

    Date dateCreated
    Date lastUpdated

    static constraints = {
        email shared: "nonEmpty", email: true, unique: true
        name shared: "nonEmpty"
        password shared: "nonEmpty"
        role shared: "nonEmpty"
        profileImageName nullable: true, blank: true
        dateOfBirth nullable: true
        gender nullable: true
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
