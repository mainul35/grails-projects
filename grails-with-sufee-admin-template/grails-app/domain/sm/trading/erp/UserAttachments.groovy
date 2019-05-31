package sm.trading.erp

class UserAttachments {

    User user
    Attachment attachment

    static constraints = {
        user nullable: false
        attachment nullable: false
    }
}
