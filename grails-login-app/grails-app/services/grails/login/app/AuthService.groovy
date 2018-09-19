package grails.login.app

import grails.gorm.transactions.Transactional

@Transactional
class AuthService {

    private static final String AUTHENTICATED = 'AUTHENTICATED'

    boolean isAuthenticated() {
        return (getAuthentication()?.isAuthenticated ? true : false)
    }

    private def setAuthentication(User user){
        if (user){
            def authentication = [isAuthenticated: true, user: user]
            AppUtil.getAuthSession()[AUTHENTICATED] = authentication
        }else{
            def authentication = [isAuthenticated: false, user: user]
            AppUtil.getAuthSession()[AUTHENTICATED] = authentication
        }
    }

    def getAuthentication() {
        return AppUtil.getAuthSession()[AUTHENTICATED]
    }

    def doLogin(String email, String password){
        password = password.encodeAsBase64()
        def user = User.findByEmail(email)
        if(user?.password && user.password.equals(password)){
            setAuthentication(user)
            return true
        }
        setAuthentication(null)
        return false
    }

    def logout(){
        setAuthentication(null)
    }
}
