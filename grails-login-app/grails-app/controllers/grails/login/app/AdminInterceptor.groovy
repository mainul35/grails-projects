//package grails.login.app
//
//
//class AdminInterceptor {
//
//    AuthService authService
//    RequestMapService requestMapService
//
//    boolean before() {
//        request.getRequestURL().toString().split('/').eachWithIndex { path, index ->
//            requestMapService.getMatchedUriList(path).each{ reqMap ->
//                if(!reqMap.role.equals(authService.getAuthentication()?.user?.role)){
//                    render('403: Access denied!')
//                    return false
//                }
//            }
//        }
//    }
//
//    boolean after() { true }
//
//    void afterView() {
//        // no-op
//    }
//}
