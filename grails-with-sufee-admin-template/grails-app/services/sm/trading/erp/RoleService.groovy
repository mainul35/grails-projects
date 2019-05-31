package sm.trading.erp

import grails.gorm.transactions.Transactional

@Transactional
class RoleService {

    def createRole(Role role) {
        role.authority = ('ROLE_'+role.authority.toUpperCase())
        return role.save(flush: true)
    }

    def getRolesMatchingWithIds(def ids){
        def roles = new HashSet<Role>()
        for(def id : ids){
            roles.add(Role.findById(Long.parseLong(''+id)))
        }
        return roles
    }
}
