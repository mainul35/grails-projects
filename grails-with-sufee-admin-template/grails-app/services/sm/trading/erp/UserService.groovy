package sm.trading.erp

import grails.gorm.transactions.Transactional

@Transactional
class UserService {

    def createUser(User user) {
        log.info 'in createUser method call: '
        for (def role1: user.roles){
            role1.user = user
        }
        if ((User.findByEmail(user.email) == null) && (User.findByUsername(user.username) == null)) {
            user.save(failOnError: true, flush: true)
        } else {
            return false
        }
    }

    User getUserByUsername(String username) {
        User user1 = User.findByUsername(username)
        return user1
    }
}
