package grails.login.app

import grails.gorm.transactions.Transactional

@Transactional
class UserService {

    def create(params) {
        User user = new User()
        user.name = params.name
        user.email = params.email
        user.password = params.password
//        user.save(flash:true)
        log.info("create(): {}", user)
        return user.save()
    }
}
