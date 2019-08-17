package sm.trading.erp

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.PathVariable

@Secured('ROLE_ADMIN')
class AdminController {
    RoleService roleService
    UserService userService
    UploadService uploadService

    def 'dashboard'() {
        render view: '/admin/dashboard'
    }

    def 'add-role'(Role role) {
        def created = false
        def status, msg
        if (role?.authority) {
            if (roleService.createRole(role)) {
                created = true
            }
            if (created == true) {
                render(view: '/admin/add-role', model: [status: message(code: 'alert.status.success'), msg: 'Created successfully!'])
                return
            } else {
                render(view: '/admin/add-role', model: [status: message(code: 'alert.status.danger'), msg: 'Failed to create!'])
                return
            }
        } else {
            render(view: '/admin/add-role', model: [status: '', msg: ''])
            return
        }
    }

    def 'view-roles'() {
        [roles: Role.findAll()]
    }

    def "add-user" () {
        render(view: "/admin/add-user", model: [status: '', msg: ''])
    }

    def 'save'() {
        def saved = false
        def roles = Role.findAll()
        log.info 'in /admin/add-user action call: {}', params

        User user = new User()
        String status = "create"
        String message = ""
        String code = ""

        if (params.id) {
            user = User.findById(params.id)
            status = "update"
        }

        if (params.firstName) {
            user.firstName = params.firstName
        }

        if (params.lastName) {
            user.lastName = params.lastName
        }

        if (params.email) {
            user.email = params.email
        }

        if (params.password) {
            user.password = params.password
        }

        if (params.contact) {
            user.contact = params.contact
        }

        if (params.position) {
            user.position = params.position
        }

        if (params.address) {
            user.address = params.address
        }

        if (params.joiningDate) {
            user.joiningDate = params.joiningDate
        }

        Role role = roleService.getRoleMatchingWithName("ROLE_USER")
        if (!role) {
            role = new Role()
            role.setAuthority("USER")
            roleService.createRole(role)
        }
        user.roles = new ArrayList<Role>()
        user.roles.add(role)

        def fileName = uploadService.uploadFile(request.getFile('file'), user.id)
        if (fileName) {
            user.profileImage = fileName
        }

        if (status == "create") {
            user.username = user.email.split('@')[0]
            log.info '{}', user
            if (userService.save(user)) {
                saved = true
            }
            if (saved) {
                message = "Created Successfully!"
                code = 'alert.status.success'
            } else {
                message = "Failed to Create!"
                code = 'alert.status.danger'
            }
            render(view: '/admin/add-user', model: [status: g.message(code: code, default: ''), msg: message, roles: roles])
            return
        } else {
            if (userService.save(user)) {
                saved = true
            }

            if (saved) {
                message = "Updated Successfully!"
                code = 'alert.status.success'
            }
            else {
                message = "Failed to Update!"
                code = 'alert.status.danger'
            }
            render(view: '/admin/add-user', model: [status: g.message(code: code, default: ''), msg: message, user: user])
            return
        }
    }

    def 'edit'(){
        User user = User.findById(params.id)
        render(view: "edit-user", model: [user: user])
    }

    def 'view-users'() {
        def users = User.findAll()
//        int page = Integer.parseInt(params.page ?: '0')
//        int offset = Integer.parseInt(params.offset ?: '10')
//        def collectedUsers = new ArrayList<User>()
//        for (int x = (10 * page); x < (10 * page + offset); x++) {
//            if (x + 1 > users.size)
//                break;
//            collectedUsers.add(users.get(x))
//        }
        [users: users, page: params.page, offset: params.offset]
    }

    def 'view-profile'() {
        log.info 'in /admin/view-profile action call: {}'
        render(view: '/admin/view-profile', model: [user: userService.getUserByUsername(params.username)])
    }

    def 'change-lock-status'() {
        User user = User.load(params.id)
        log.info 'in /admin/change-lock-status action call: {}', user
        user.accountLocked = !user.accountLocked
        user.save(failOnError: true, flush: true)
        redirect(controller: "admin", action: "view-users")
    }

    def 'change-expire-status'() {
        User user = User.load(params.id)
        log.info 'in /admin/change-expire-status action call: {}', user
        user.accountExpired = !user.accountExpired
        user.accountExpired ? (user.leavingDate = new Date()) : (user.leavingDate = null)
        user.save(failOnError: true, flush: true)
        redirect(controller: "admin", action: "view-users")
    }

    def 'search-user'() {
        def users = User.findAll()
        def collectedUsers = new ArrayList()
        println params.searchTerm
        for (User user : users) {
            if (user.firstName.contains(params.searchTerm) || user.lastName.contains(params.searchTerm) || user.email.contains(params.searchTerm)) {
                collectedUsers.add(user)
            }else if(params.searchTerm.isEmpty()){
                collectedUsers = users
            }
        }
        render(collectedUsers as grails.converters.JSON ?: "{}")
    }
}