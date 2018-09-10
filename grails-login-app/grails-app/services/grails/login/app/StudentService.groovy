package grails.login.app

import grails.gorm.transactions.Transactional

@Transactional
class StudentService {

    def create(params) {
        Student user = new Student()
        user.name = params.name
        user.email = params.email
        user.password = params.password

        if(user.validate()){
//        user.save(flash:true)
            user.save()
            log.info("create(): {}", user)
            return true
        }else{
            return false
        }
    }
}
