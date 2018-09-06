package grails.login.app

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class AdminInterceptorSpec extends Specification implements InterceptorUnitTest<AdminInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test admin interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"admin")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
