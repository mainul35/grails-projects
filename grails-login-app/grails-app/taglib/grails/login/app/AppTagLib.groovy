package grails.login.app

class AppTagLib {

    AuthService authService
    UserService userService
    static namespace = "AppSecurity"

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
            out << '<li class="nav-item active">'
            out << '<a class="nav-link" href="/course/create-course">Create Course </a>'
            out << '</li>'
            out << '<li class="nav-item active">'
            out << '<a class="nav-link" href="/semester/create-semester">Create Semester </a>'
            out << '</li>'
            out << '<li class="nav-item active">'
            out << '<a class="nav-link" href="/student/create-student">Create Student </a>'
            out << '</li>'
        }
    }

    def studentMenues = { attr, body ->
        if (authService.isAuthenticated() && authService.getAuthentication().user.role.equals('ROLE_STUDENT')) {
            out << '<li class="nav-item active">'
            out << '<a class="nav-link" href="/admin/create-student">Create Student </a>'
            out << '</li>'
        }
    }

    def emailPasswordFields = { attr, body ->
        out << '<div class="form-group">'
        out << g.textField(name: "email", placeholder: "Email", class: "form-control", required: "true")
        out << '</div>'
        out << '<div class="form-group">'
        out << g.passwordField(name: "password", placeholder: "Password", class:"form-control", required: "true")
        out << '</div>'
    }

    def msg = { attr, body ->
//        log.info('attributes: {}', attr)
        if(attr.status==true) {
            out << '<div class="alert alert-success">'
            out << '<strong>'
            out << attr.msg
            out << '</strong>'
            out << '</div>'
        }
        if(attr.status==false){
            out << '<div class="alert alert-danger">'
            out << '<strong>'
            out << attr.msg
            out << '</strong>'
            out << '</div>'
        }
    }
}