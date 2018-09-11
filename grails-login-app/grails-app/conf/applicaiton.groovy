grails.gorm.default.constraints = {
    nonEmpty(nullable: false, blank: false)
}

environments {
    production {
        grails.assets.storagePath = "/full/path/to/storage"
    }
}