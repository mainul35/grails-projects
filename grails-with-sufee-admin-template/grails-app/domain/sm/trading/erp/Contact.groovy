package sm.trading.erp

class Contact {

    String email
    String phone
//    static hasOne = [user: User]
//    static belongsTo = [User]
    static constraints = {
        email email: true, nullable: false, blank: false, unique: true, size: 3..25
        phone nullable: false, blank: false, unique: true
    }
    static mapping = {
        version false
    }
}
