package sm.trading.erp

class News {

    Long id
    String description
    Date publishingTime
    Category category

    static constraints = {
        description(nullable: false, blank: false)
        publishingTime nullable: false
        category nullable: false
    }

    static mapping = {
        description(sqlType: "longText")
        category insertable: false, updateable: false
    }
}
