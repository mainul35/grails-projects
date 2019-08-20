package sm.trading.erp

class News {

    Long id
    String title
    String description
    Date publishingTime
    List<Attachment> attachments
    Category category

    static constraints = {
        title(nullable: false, blank: false)
        description(nullable: false, blank: false)
        publishingTime nullable: false
        attachments(nullable: true)
        category nullable: false
    }

    static mapping = {
        description(sqlType: "longText")
        category insertable: false, updateable: false
    }
}
