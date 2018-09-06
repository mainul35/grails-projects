package grails.login.app

import grails.gorm.transactions.Transactional

@Transactional
class StudentService {

    def create(params) {
        Student user = new Student()
        user.name = params.name
        user.email = params.email
        user.password = params.password

//        user.save(flash:true)
        log.info("create(): {}", user)
        return user.save()
    }
}
