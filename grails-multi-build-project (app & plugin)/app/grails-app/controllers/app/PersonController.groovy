package app

import groovy.transform.CompileStatic
import plugin.RandomPersonService

@CompileStatic
class PersonController {

    RandomPersonService randomPersonService
    def index() {
        render randomPersonService.randomOciPersonName()
    }
}
