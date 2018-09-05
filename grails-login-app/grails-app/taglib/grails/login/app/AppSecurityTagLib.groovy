package grails.login.app

class AppSecurityTagLib {

    AuthService authService
    UserService userService
    static namespace = "AppSecurity"

    def menuOnAuthenticationState = {attrs, body ->
        log.info('authenticated? = {}', authService.isAuthenticated())
        if(authService.isAuthenticated()){
            out << '<li class="nav-item dropdown show">'
            out << g.link(class:"nav-link dropdown-toggle", "data-toggle":"dropdown"){authService.getAuthentication().user.name}
            out << '<div class="dropdown-menu">'
            out << g.link(controller: "auth", action: "logout", class: "dropdown-item"){g.message(code:"logout")}
            out << "</div></li>"
        }else{
            out << g.link(controller: "user", action: "register", class: "btn btn-primary"){g.message(code:"signup")}
        }
    }
}
