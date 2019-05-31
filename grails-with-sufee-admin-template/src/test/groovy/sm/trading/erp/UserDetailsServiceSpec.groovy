package sm.trading.erp

import grails.testing.services.ServiceUnitTest
import org.springframework.security.core.userdetails.UserDetailsService
import spock.lang.Specification

class UserDetailsServiceSpec extends Specification implements ServiceUnitTest<UserDetailsService>{

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
