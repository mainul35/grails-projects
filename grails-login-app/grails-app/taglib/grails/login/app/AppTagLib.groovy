package grails.login.app

class AppTagLib {

    AuthService authService
    UserService userService
    StudentService studentService
    static namespace = "App"

    def renderErrorMessage = { attrs, body ->
        def model = attrs.model
        String fieldName = attrs.fieldName
        String errorMessage = attrs.errorMessage? g.message(code: attrs.errorMessage): g.message(code: "invalid.input")
        if (model && model.errors && model.errors.getFieldError(fieldName)){
            out << "<small class='form-text text-danger''><strong>${errorMessage}</strong></small>"
        }
    }

    def menuOnAuthenticationState = { attrs, body ->
        if (authService.isAuthenticated()) {
            out << '<li class="nav-item dropdown show">'
            out << g.link(class: "nav-link dropdown-toggle", "data-toggle": "dropdown") {
                authService.getAuthentication().user.name
            }
            out << '<div class="dropdown-menu">'
            out << g.link(controller: "user", action: "dashboard", class: "dropdown-item") { g.message(code: "profile") }
            out << g.link(controller: "auth", action: "logout", class: "dropdown-item") { g.message(code: "logout") }
            out << "</div>"
        }
    }

    def adminSideNav = { attrs, body ->
        if (authService.isAuthenticated() && authService.getAuthentication().user.role.equals('ROLE_ADMIN')) {
            out << '<nav class="col-sm-3 col-md-2 d-none d-sm-block bg-light sidebar">'
            out << '<ul class="list-group">'
            [
                    [controller: "course", action: "all", name: "Courses"],
                    [controller: "department", action: "all", name: "Departments"],
                    [controller: "semester", action: "all", name: "Semesters"],
                    [controller: "student", action: "all", name: "Students"],
            ].each { menu ->
                out << '<li class="list-group-item">'
                out << g.link(controller: menu.controller, action: menu.action) {
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
            out << g.render(template: '/admin/name_sex_dob', model: [user: attr.user])
        }
    }

    def emailField = { attr, body ->
        out << '<div class="form-group">'
        out << '<label>Email</label>'
        out << g.textField(name: "email", placeholder: "Email", value: attr.email, class: "form-control", required: "true", id: attr.id)
        out << "<span id='${attr.spanId}'></span>"
        out << '</div>'
    }

    def passwordField = { attr, body ->
        out << '<div class="form-group">'
        out << '<label>Password</label>'
        out << g.passwordField(name: "password", placeholder: "Password", value: attr.password, class: "form-control", required: "true")
        out << '</div>'
    }

    def msg = { attr, body ->
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

    def authorized = { attrs, body ->
        if (authService.isAuthenticated()) {
            if (authService.getAuthentication().user.role.equals(attrs.role)) {
                out << body()
            }
        }
    }
}