package grails.login.app

class AppTagLib {

    AuthService authService
    UserService userService
    static namespace = "App"

    def menuOnAuthenticationState = { attrs, body ->
        log.info('authenticated? = {}', authService.isAuthenticated())
        if (authService.isAuthenticated()) {
            out << '<li class="nav-item dropdown show">'
            out << g.link(class: "nav-link dropdown-toggle", "data-toggle": "dropdown") {
                authService.getAuthentication().user.name
            }
            out << '<div class="dropdown-menu">'
            out << g.link(controller: "auth", action: "logout", class: "dropdown-item") { g.message(code: "logout") }
            out << "</div></li>"
        } else {
            out << g.link(controller: "user", action: "register", class: "btn btn-primary") {
                g.message(code: "signup")
            }
        }
    }

    def adminMenues = { attr, body ->
        if (authService.isAuthenticated() && authService.getAuthentication().user.role.equals('ROLE_ADMIN')) {

            out << '<li class="nav-item dropdown show">'
            out << g.link(class: "nav-link dropdown-toggle", "data-toggle": "dropdown") {
                'Manage Courses'
            }
            out << '<div class="dropdown-menu">'
            out << g.link(controller: "course", action: "create-course", class: "dropdown-item") { 'Create course' }
            out << g.link(controller: "course", action: "view-all-courses", class: "dropdown-item") { 'View courses' }
            out << "</div></li>"

            out << '<li class="nav-item dropdown show">'
            out << g.link(class: "nav-link dropdown-toggle", "data-toggle": "dropdown") {
                'Manage Departments'
            }
            out << '<div class="dropdown-menu">'
            out << g.link(controller: "department", action: "create-department", class: "dropdown-item") {
                'Create department'
            }
            out << g.link(controller: "department", action: "view-all-departments", class: "dropdown-item") {
                'View departments'
            }
            out << "</div></li>"

            out << '<li class="nav-item dropdown show">'
            out << g.link(class: "nav-link dropdown-toggle", "data-toggle": "dropdown") {
                'Manage Semesters'
            }
            out << '<div class="dropdown-menu">'
            out << g.link(controller: "semester", action: "create-semester", class: "dropdown-item") {
                'Create semester'
            }
            out << g.link(controller: "semester", action: "view-all-semesters", class: "dropdown-item") {
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
            out << g.link(controller: "student", action: "view-all-students", class: "dropdown-item") {
                'View students'
            }
            out << "</div></li>"
        }
    }


    def studentMenues = { attr, body ->
        if (authService.isAuthenticated() && authService.getAuthentication().user.role.equals('ROLE_STUDENT')) {
            out << '<li class="nav-item dropdown show">'
            out << g.link(class: "nav-link dropdown-toggle", "data-toggle": "dropdown") {
                'Profile'
            }
            out << '<div class="dropdown-menu">'
            out << g.link(controller: "student", action: "profile", params: [id: authService.getAuthentication().user.id], class: "dropdown-item") {
                'View'
            }
            out << g.link(controller: "student", action: "edit", params: [id: authService.getAuthentication().user.id], class: "dropdown-item") {
                'Edit'
            }
            out << "</div></li>"
        }
    }

    def editStudent = { attr, body ->
        if (authService.isAuthenticated()) {
            if (authService.getAuthentication().user.role.equals('ROLE_ADMIN')) {
                out << g.render(template: '/admin/name_sex_dob')
                out << emailPasswordFields(email: attr.email, password: attr.password)
                out << g.render(template: '/admin/semester_department')
            } else if (authService.getAuthentication().user.role.equals('ROLE_STUDENT')) {
                out << g.render(template: '/admin/name_sex_dob')
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
}