package grails.login.app

class AppTagLib {

    AuthService authService
    UserService userService
    StudentService studentService
    static namespace = "App"

    def menuOnAuthenticationState = { attrs, body ->
//        log.info('authenticated? = {}', authService.isAuthenticated())
        if (authService.isAuthenticated()) {
            out << '<li class="nav-item dropdown show">'
            out << g.link(class: "nav-link dropdown-toggle", "data-toggle": "dropdown") {
                authService.getAuthentication().user.name
            }
            out << '<div class="dropdown-menu">'
            out << g.link(controller: "auth", action: "logout", class: "dropdown-item") { g.message(code: "logout") }
            out << "</div></li>"
        } else {
//            out << g.link(controller: "user", action: "register", class: "btn btn-primary") {
//                g.message(code: "signup")
//            }
        }
    }

    def adminMenues = { attr, body ->
        if (authService.isAuthenticated() && authService.getAuthentication().user.role.equals('ROLE_ADMIN')) {

            out << '<li class="nav-item dropdown show">'
            out << g.link(class: "nav-link dropdown-toggle", "data-toggle": "dropdown") {
                'Manage Courses'
            }
            out << '<div class="dropdown-menu">'
            out << g.link(controller: "course", action: "create", class: "dropdown-item") { 'Create course' }
            out << g.link(controller: "course", action: "all", class: "dropdown-item") { 'View courses' }
            out << "</div></li>"

            out << '<li class="nav-item dropdown show">'
            out << g.link(class: "nav-link dropdown-toggle", "data-toggle": "dropdown") {
                'Manage Departments'
            }
            out << '<div class="dropdown-menu">'
            out << g.link(controller: "department", action: "create", class: "dropdown-item") {
                'Create department'
            }
            out << g.link(controller: "department", action: "all", class: "dropdown-item") {
                'View departments'
            }
            out << "</div></li>"

            out << '<li class="nav-item dropdown show">'
            out << g.link(class: "nav-link dropdown-toggle", "data-toggle": "dropdown") {
                'Manage Semesters'
            }
            out << '<div class="dropdown-menu">'
            out << g.link(controller: "semester", action: "create", class: "dropdown-item") {
                'Create semester'
            }
            out << g.link(controller: "semester", action: "all", class: "dropdown-item") {
                'View semesters'
            }
            out << "</div></li>"

            out << '<li class="nav-item dropdown show">'
            out << g.link(class: "nav-link dropdown-toggle", "data-toggle": "dropdown") {
                'Manage Students'
            }
            out << '<div class="dropdown-menu">'
            out << g.link(controller: "admin", action: "register-student", class: "dropdown-item") {
                'Register student'
            }
            out << g.link(controller: "student", action: "all", class: "dropdown-item") {
                'View students'
            }
            out << "</div></li>"
        }
    }

    def adminSideNav = { attrs, body ->
        if (authService.isAuthenticated() && authService.getAuthentication().user.role.equals('ROLE_ADMIN')) {
            out << '<nav class="col-sm-3 col-md-2 d-none d-sm-block bg-light sidebar">'
            out << '<ul class="list-group">'
            [
                    [controller: "admin", action: "profile", name: "View profile"],
                    [controller: "admin", action: "edit", name: "Edit Profle"],
            ].each { menu ->
                out << '<li class="list-group-item">'
                out << g.link(controller: menu.controller, action: menu.action, params: [id: authService.getAuthentication().user.id]) {
                    g.message(code: menu.name, args: [''])
                }
                out << '</li>'
            }
            out << '</ul></nav>'
            out << body()
        }
    }

    def studentSideNav = { attrs, body ->
        if (authService.isAuthenticated() && authService.getAuthentication().user.role.equals('ROLE_STUDENT')) {
            out << '<nav class="col-sm-3 col-md-2 d-none d-sm-block bg-light sidebar">'
            out << '<ul class="list-group">'
            [
                    [controller: "student", action: "profile", name: "View profile"],
                    [controller: "student", action: "edit", name: "Edit Profle"],
            ].each { menu ->
                out << '<li class="list-group-item">'
                out << g.link(controller: menu.controller, action: menu.action, params: [id: authService.getAuthentication().user.id]) {
                    g.message(code: menu.name, args: [''])
                }
                out << '</li>'
            }
            out << '</ul></nav>'
            out << body()
        }
    }


    def isAuthenticated = { attrs, body ->
        if (authService.isAuthenticated().equals(Boolean.parseBoolean('' + attrs.authFlag))) {
            out << body()
        }
    }

    def editProfile = { attr, body ->
        if (authService.isAuthenticated()) {
            if (authService.getAuthentication().user.role.equals('ROLE_ADMIN')) {
                out << g.render(template: '/admin/name_sex_dob', model: [user: attr.user])
                out << emailPasswordFields(email: attr.email, password: attr.password)
            } else if (authService.getAuthentication().user.role.equals('ROLE_STUDENT')) {
                out << g.render(template: '/admin/name_sex_dob', model: [user: attr.user])
                out << emailPasswordFields(email: attr.email, password: attr.password)
            }
        }
    }

    def emailPasswordFields = { attr, body ->
        out << '<div class="form-group">'
        out << '<label>Email</label>'
        out << g.textField(name: "email", placeholder: "Email", value: attr.email, class: "form-control", required: "true")
        out << '</div>'
        out << '<div class="form-group">'
        out << '<label>Password</label>'
        out << g.passwordField(name: "password", placeholder: "Password", value: attr.password, class: "form-control", required: "true")
        out << '</div>'
    }

    def msg = { attr, body ->
//        log.info('attributes: {}', attr)
        if (attr.status == true) {
            out << '<div class="alert alert-success">'
            out << '<strong>'
            out << attr.msg
            out << '</strong>'
            out << '</div>'
        }
        if (attr.status == false) {
            out << '<div class="alert alert-danger">'
            out << '<strong>'
            out << attr.msg
            out << '</strong>'
            out << '</div>'
        }
    }

    def img = { attr, body ->
        byte[] imageInBytes = new File(grailsApplication.config.uploadFolder + attr.src).bytes

        if (imageInBytes) {
            response.setContentLength(imageInBytes.length)
            response.setContentType(attr.type)
            response.outputStream.write(imageInBytes)
        } else {
            response.sendError(404)
        }
    }

    def authorized = {attrs, body->
        if(authService.isAuthenticated()){
            if(authService.getAuthentication().user.role.equals(attrs.role)){
                out << body()
            }
        }
    }
}