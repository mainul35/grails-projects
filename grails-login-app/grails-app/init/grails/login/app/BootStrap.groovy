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

//        ApplicationContext appContext = (ApplicationContext) servletContext.getAttribute(GrailsApplicationAttributes.APPLICATION_CONTEXT);
//        Admin user = new Admin()
//        user.name = 'Administrator'
//        user.email = 'admin@campus.com'
//        user.password = 'secret'
//        user.role = 'ROLE_ADMIN'
//        user.save(failOnError: true)
//
//        requestMapService.create('/admin/dashboard', user.role)
//        requestMapService.create('/admin/create-semester', user.role)

//        grailsApplication.controllerClasses.each {
//            it.	getActions().each {uri ->
//                println  "${it.logicalPropertyName}/${uri}"
//            }
//        }

//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver()
//        resolver.properties.classLoader = 'file:///c:/temp/'

//        log.info("servletContext = {} {}", resolver, appContext)


//        ResourceHandlerRegistry registry = new ResourceHandlerRegistry(appContext, servletContext)
//
//        registry.addResourceHandler(
//                "/temp/**",
//                "/admin/temp/**",
//                "/student/temp/**"
//        )
//        .addResourceLocations(
//                "file:///C:/temp/"
//        )
//
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/")
//                .setCachePeriod(999999999)
//        registry.addResourceHandler('/static/**')
//                .addResourceLocations("classpath:/META-INF/resources/", "classpath:/resources/",
//                "classpath:/static/", "classpath:/public/")
//                .setCachePeriod(999999999)
//
//        configurer.addResourceHandlers(registry)

    }
    def destroy = {
    }
}
