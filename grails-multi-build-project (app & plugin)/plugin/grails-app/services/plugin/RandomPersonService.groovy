package plugin

import demo.OCI
import grails.gorm.transactions.Transactional
import groovy.transform.CompileStatic

@Transactional
@CompileStatic
class RandomPersonService {

        String randomOciPersonName() {
            List<String> people = OCI.PEOPLE
            Collections.shuffle(people)
            people.first()
        }
}
