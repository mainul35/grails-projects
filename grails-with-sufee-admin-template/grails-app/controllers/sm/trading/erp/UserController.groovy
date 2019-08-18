package sm.trading.erp

import grails.plugin.springsecurity.annotation.Secured

class UserController {

    @Secured("ROLE_USER")
    def 'newsfeed'() {
        respond (view: '/user/newsfeed')
    }

    def 'profile'() {
        respond (view: '/user/profile')
    }

    def 'edit'(User user) {
        respond (view: '/user/edit')
    }
}
