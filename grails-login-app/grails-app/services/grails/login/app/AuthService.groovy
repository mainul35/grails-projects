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
            log.info('setAuthentication(): {}', authentication)
            AppUtil.getAuthSession()[AUTHENTICATED] = authentication
        }else{
            def authentication = [isAuthenticated: false, user: user]
            log.info('setAuthentication(): {}', authentication)
            AppUtil.getAuthSession()[AUTHENTICATED] = authentication
        }
    }

    def getAuthentication() {
        log.info('getAuthentication(): {}', AppUtil.getAuthSession()[AUTHENTICATED])
        return AppUtil.getAuthSession()[AUTHENTICATED]
    }

    def doLogin(String email, String password){
        password = password.encodeAsBase64()
        log.info('doLogin(): email={}', email)
        def user = User.findByEmail(email)
        log.info('doLogin(): {}', user)
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
