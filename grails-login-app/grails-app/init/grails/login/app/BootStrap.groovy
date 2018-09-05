package grails.login.app

class BootStrap {

    def init = { servletContext ->
        User user = new User()
        user.name = 'Mainul Hasan'
        user.email = 'mainul@bitmascot.com'
        user.password = 'secret'
        user.save(failOnError: true, flush: true)
    }
    def destroy = {
    }
}
