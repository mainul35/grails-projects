package sm.trading.erp

class BootStrap {

    def init = { servletContext ->
        Role role1 = new Role('ROLE_ADMIN')
        User user = new User('mainul35', 'secret')

        user.email = "mainuls18@gmail.com"
        user.firstName = 'Syed Mainul'
        user.lastName = 'Hasan'
        user.position = 'Admin'
        user.contact = '+8801634440004'
        user.address = 'Avijan 9/2, Academy Road, College Gate, Tongi, Gazipur'
        user.joiningDate = new Date()

        Role.findByAuthority(role1.authority) ?: role1.save(flush: true, failOnError: true)
        user.roles = new ArrayList<Role>()
        user.roles.add(role1)
//        for (def r: user.roles){
//            r.user = user
//        }
        User.findByUsername(user.username) ?: user.save(flush: true, failOnError: true)

        log.info('role1: {}', role1.toString())
        log.info('user: {}', user.toString())
    }

    def destroy = {
    }
}
