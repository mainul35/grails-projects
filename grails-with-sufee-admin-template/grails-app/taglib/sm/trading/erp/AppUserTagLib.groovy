package sm.trading.erp

class AppUserTagLib {
    static namespace = "appUser"
//    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    def nameField = {attr, body ->
        out << g.render(template: '/templates/user/name_form', model: [firstName: attr.firstName, lastName: attr.lastName])
    }

    def emailPasswordField = {attr, body->
        out << g.render(template: '/templates/user/authentication_form', model: [email: attr.email, password: attr.password])
    }

    def contactField = {attr, body->
        out << g.render(template: '/templates/user/contact_form', model: [contact: attr.contact])
    }

    def positionField = {attr, body->
        out << g.render(template: '/templates/user/position_form', model: [position: attr.position])
    }

    def addressField = {attr, body->
        out << g.render(template: '/templates/user/address_form', model: [address: attr.address])
    }

    def roleAssigningField = {attr, body->
        out << g.render(template: '/templates/user/role_assigning_form', model: [roles: attr.roles, allRoles: Role.findAll()])
    }
}
