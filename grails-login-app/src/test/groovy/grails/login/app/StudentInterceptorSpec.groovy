package grails.login.app

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class StudentInterceptorSpec extends Specification implements InterceptorUnitTest<StudentInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test student interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"student")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
