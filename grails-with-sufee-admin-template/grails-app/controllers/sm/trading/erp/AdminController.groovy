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

    def 'add-user'() {
        def created = false
        def roles = Role.findAll()
        log.info 'in /admin/add-user action call: {}', params
        User user = params
        user.roles = roleService.getRolesMatchingWithIds(params.roles)
        user.id = System.currentTimeMillis()
        if (user.validate()) {
            user.username = user.email.split('@')[0]
            log.info '{}', user
            def fileName = uploadService.uploadFile(request.getFile('file'), user.id)
            if (fileName) {
                user.profileImage = fileName
            }
            if (userService.createUser(user)) {
                created = true
            }
            if (created) {
                render(view: '/admin/add-user', model: [status: message(code: 'alert.status.success', default: ''), msg: 'Created successfully!', roles: roles])
                return
            } else {
                render(view: '/admin/add-user', model: [status: message(code: 'alert.status.danger', default: ''), msg: 'Creation failed!', roles: roles])
                return
            }
        } else if (user && (user.email == null || user.password == null || user.contact == null || user.firstName == null || user.lastName == null || user.roles == null || user.address != null)) {
            log.debug 'some fields are missing'
            render(view: '/admin/add-user', model: [status: message(code: 'alert.status.warning', default: ''), msg: 'Could not create!', user: user])
            return
        } else {
            render(view: '/admin/add-user', model: [status: '', msg: '', roles: roles])
            return
        }
    }

    def 'edit-profile'(){
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