package first.grails.app

class UserController {

    UserService userService
    def index() { }

    def 'user-post'(){
        userService.createUser(params)
        render(view: 'index', model: [name: params.name])
    }
}
