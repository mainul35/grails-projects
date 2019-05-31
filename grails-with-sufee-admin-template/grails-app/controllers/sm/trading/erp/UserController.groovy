package sm.trading.erp

class UserController {

    def 'create-user'() {
        respond (view: '/user/create-user')
    }

    def 'profile'() {
        respond (view: '/user/profile')
    }

    def 'edit'(User user) {
        respond (view: '/user/edit')
    }
}
