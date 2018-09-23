package first.grails.app

import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap

@Transactional
class UserService {

    def createUser(GrailsParameterMap map) {
        User user = new User(map)
        user.save()
        return user
    }
}
