package grails.login.app

import grails.core.GrailsApplication
import org.grails.io.support.PathMatchingResourcePatternResolver
import org.grails.plugins.web.controllers.ControllersGrailsPlugin
import org.grails.web.util.GrailsApplicationAttributes
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry

class BootStrap {

    RequestMapService requestMapService
    ControllersGrailsPlugin.GrailsWebMvcConfigurer configurer
//    ApplicationContext applicationContext

    def init = { servletContext ->

//        Admin user = new Admin()
//        user.name = 'Administrator'
//        user.email = 'admin@campus.com'
//        user.password = 'secret'
//        user.role = 'ROLE_ADMIN'
//        user.gender = 1
//        user.dateOfBirth = new Date()
//        user.save(failOnError: true)
    }
    def destroy = {
    }
}
