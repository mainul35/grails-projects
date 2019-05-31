package sm.trading.erp

class BootStrap {

    def init = { servletContext ->
        Role role = new Role('ROLE_ADMIN')
        User user = new User('mainul35', 'secret')

        user.email = "mainuls18@gmail.com"
        user.firstName = 'Syed Mainul'
        user.lastName = 'Hasan'
        user.position = 'Admin'
        user.contact = '+8801634440004'
        user.address = 'Avijan 9/2, Academy Road, College Gate, Tongi, Gazipur'
        user.joiningDate = new Date()

        user.roles = new HashSet<Role>()
        user.roles.add(role)
        for (def role1: user.roles){
            role1.user = user
        }
//        User.exists(user)?:
        user.save(flush: true, failOnError: true)

        log.info('role: {}', role.toString())
        log.info('user: {}', user.toString())
    }

    def destroy = {
    }
}
