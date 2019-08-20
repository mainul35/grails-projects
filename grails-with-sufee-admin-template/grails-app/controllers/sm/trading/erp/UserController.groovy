package sm.trading.erp

import grails.plugin.springsecurity.annotation.Secured

class UserController {

    @Secured("ROLE_USER")
    def 'newsfeed'() {
        List<Category> categories = Category.findAll {
            max: 10
            offset: 10
        }


        render(view: '/user/newsfeed', model: [categoryItems: categories])
    }

    def 'profile'() {
        respond (view: '/user/profile')
    }

    def 'edit'(User user) {
        respond (view: '/user/edit')
    }
}
