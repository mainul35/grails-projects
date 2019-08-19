package sm.trading.erp

class Category {

    Long id
    String categoryName
    List<News> newsList

    static constraints = {
        categoryName nullable: false, unique: true
        newsList nullable: true
    }
}
