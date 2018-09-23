package app

import grails.plugins.rest.client.RestBuilder
import grails.testing.mixin.integration.Integration
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

//implements ControllerUnitTest<PersonController>

@Integration
class PersonControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }

    def '/person endpoints return one of the names'() {

        given:
        RestBuilder rest = new RestBuilder()

        when:
        def resp = rest.get("http://localhost:${serverPort}/person")

        then:
        OCI.PEOPLE.contains resp.text
    }
}
