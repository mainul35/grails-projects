package grails.login.app

import grails.gorm.transactions.Transactional

@Transactional
class UserService {

    AuthService authService
    def getUser(Serializable id) {
        return User.findById(id)
    }

    def getUser(String email){
        return User.findByEmail(email)
    }

    def exists(String email){
        return getUser(email) instanceof User
    }

    def isDuplicate(String email){
        try{
            if(!email.equals(authService.authentication.user.email)){
                if(getUser(email)){
                    return true
                }else{
                    return false
                }
            }else{
                return false
            }
        }catch (Exception e){
            return false
        }
    }
}
