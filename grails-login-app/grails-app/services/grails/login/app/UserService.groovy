package grails.login.app

import grails.gorm.transactions.Transactional

@Transactional
class UserService {

    def getUser(Serializable id) {
        return User.findById(id)
    }
}
