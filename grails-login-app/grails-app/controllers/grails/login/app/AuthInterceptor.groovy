package grails.login.app

import grails.util.Holders


class AuthInterceptor {

    AuthService authService
    RequestMapService requestMapService

    AuthInterceptor() {
        matchAll()
                .excludes(contrller: 'auth', action: 'login')
                .excludes(contrller: 'user', action: 'register')
    }

    boolean before() {
        if (!authService.isAuthenticated()) {
            redirect(controller: "auth", action: "login")
            return false
        }

//        if(request.getRequestURL().toString().contains('/user/dashboard') || request.getRequestURL().toString().equals(Holders.servletContext.contextPath)){
//            redirect(uri: request.getRequestURL().toString()+'/user/dashboard')
//            return true
//        }

        RequestMap.findAll().each { reqMap ->
            println reqMap
            if (request.forwardURI.toString().contains(reqMap.url)) {
                if (!reqMap.role.toString().equals(authService.getAuthentication()?.user?.role.toString())) {
                    println reqMap
                    render('403: Access denied!')
                    return true
                }
//                else{
//                    if(authService.getAuthentication()?.user?.role.toString().equals('ROLE_ADMIN')){
//                        redirect(controller: "admin", action: "dashboard")
//                        return true
//                    }else if(authService.getAuthentication()?.user?.role.toString().equals('ROLE_STUDENT')){
//                        redirect(controller: "student", action: "dashboard")
//                        return true
//                    }
//                }
            } else {
                render('403: Access denied!')
                return true
            }
        }
//        redirect(uri: request.getRequestURL().toString()+'/user/dashboard')
        return true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
