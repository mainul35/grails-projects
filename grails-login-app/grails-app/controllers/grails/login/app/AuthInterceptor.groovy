package grails.login.app

import grails.core.GrailsApplication
import grails.util.Holders

class AuthInterceptor {

    AuthService authService
    RequestMapService requestMapService

//    GrailsApplication grailsApplication

    AuthInterceptor() {
        matchAll()
                .excludes(contrller: 'auth', action: 'login')
                .excludes(contrller: 'user', action: 'register-student')
    }

    boolean before() {

        if (!authService.isAuthenticated()) {
            redirect(controller: "auth", action: "login")
            return false
        }

//        boolean found = false
//        def paths = []
//        for (classes in grailsApplication.controllerClasses) {
//            for (uri in classes.getActions()) {
//                def path = ("/" + classes.logicalPropertyName + "/" + uri)
//                paths.add(path)
//            }
//        }
//        for (def path in paths){
//            log.info("{} : {}", path, request.forwardURI.toString().contains(path))
////            if (request.forwardURI.toString().equals('/')) {
////                continue
////            } else if (request.forwardURI.toString().equals(path)) {
////                found = true
////                break
////                break
////            }
//        }
//
////        if(!found){
////            redirect(controller: "auth", action: "404")
////            return true
////        }
//


//        def reqMaps = RequestMap.findAll()
//
//        for (reqMap in reqMaps) {
//            if (request.forwardURI.toString().equals('/')) {
//                continue
//            }
//
//            def found = false
//            if (request.forwardURI.toString().contains(reqMap.url)) {
//                if (reqMap.role
//                        .equals(authService.getAuthentication()?.user?.role)) {
//                    return true
//                } else {
//                    render('403: Access denied!')
//                    return true
//                }
//            } else {
//
//                for (classes in grailsApplication.controllerClasses) {
//                    for (uri in classes.getActions()) {
//                        def path = ("/" + classes.logicalPropertyName + "/" + uri)
//                        if (path.contains(request.forwardURI.toString())) {
//                            if (!request.forwardURI.toString().equals(reqMap.url)) {
//                                found = true
//                                break
//                            }
//                        } else {
//                            found = false
//                        }
//                    }
//                    if (found) {
//                        render('403: Access denied!')
//                        break
//                    }
//                }
//                if (!found)
//                    render('404: Not Found!')
//            }
//            return true
//        }
        return true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }

}
