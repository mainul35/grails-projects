package sm.trading.erp

class News {

    Long id
    String description
    Date publishingTime
    Category category
    User postedBy

    static constraints = {
        description(nullable: false, blank: false)
        publishingTime nullable: false
        category nullable: true
        postedBy nullable: false
    }

    static mapping = {
        description(sqlType: "longText")
        category insertable: false, updateable: false
    }
}
