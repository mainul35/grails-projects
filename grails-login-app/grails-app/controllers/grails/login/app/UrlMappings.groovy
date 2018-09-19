package grails.login.app

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: 'user', action: 'dashboard')
        "500"(view:'/error')
        "404"(controller: 'auth', action: '404')
    }
}
