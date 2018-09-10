package grails.login.app

import grails.core.GrailsApplication

class BootStrap {

//    GrailsApplication grailsApplication
    RequestMapService requestMapService

    def init = { servletContext ->
        Admin user = new Admin()
        user.name = 'Administrator'
        user.email = 'admin@campus.com'
        user.password = 'secret'
        user.role = 'ROLE_ADMIN'
        user.save(failOnError: true)

        requestMapService.create('/admin/dashboard', user.role)
        requestMapService.create('/admin/create-semester', user.role)

//        grailsApplication.controllerClasses.each {
//            it.	getActions().each {uri ->
//                println  "${it.logicalPropertyName}/${uri}"
//            }
//        }
    }
    def destroy = {
    }
}
