package sm.trading.erp

import grails.gorm.transactions.Transactional

@Transactional
class UserService {

    def save(User user) {
        log.info 'in createUser method call: '
//        for (def role1: user.roles){
//            role1.user = user
//        }
        user.save(flush: true, failOnError: true)
    }

    User getUserByUsername(String username) {
        User user1 = User.findByUsername(username)
        return user1
    }
}
