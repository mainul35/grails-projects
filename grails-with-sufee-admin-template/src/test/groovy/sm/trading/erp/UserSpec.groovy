package sm.trading.erp

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class UserSpec extends Specification implements DomainUnitTest<User> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == true
    }

    void "Test that user has properties userName and email"() {
        when: "A user is created with the given userName and email"
        String firstName = 'FirstName'
        String lastName = null
        String username = null
        String email  = 'test@user.com'
//        long id = System.currentTimeMillis()
        String password = 'secret'
        boolean enabled = true
        String contact = '01634440004'
        String position = 'Admin'
        String address = 'Avijan 9/2, Academy Road, College Gate, Tongi, Gazipur'
        String profileImage = null
        Date joiningDate = new Date()
        Date leavingDate = null
        boolean accountExpired = false
        boolean accountLocked = false
        boolean passwordExpired = false
        Set roles = new HashSet<Role>()
        roles.add(new Role(id: System.currentTimeMillis(), authority: 'ROLE_ADMIN'))
        roles.add(new Role(id: System.currentTimeMillis(), authority: 'ROLE_MANAGINGDIRECTOR'))
        User user = new User(
                firstName: firstName,
                lastName: lastName,
                username: username,
                email:email,
                password: password,
//                id: id,
                enabled: enabled,
                contact: contact,
                position: position,
                address: address,
                profileImage: profileImage,
                joiningDate: joiningDate,
                leavingDate: leavingDate,
                roles: roles
        )
        then: "user is valid"
        assert user.validate()
    }

}
