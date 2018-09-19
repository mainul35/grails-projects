package grails.login.app

import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap

@Transactional
class AdminService {

    Admin getAdmin(Serializable id) {
        return Admin.findById(id)
    }

    boolean updateAdmin(GrailsParameterMap params) {
        Admin admin = getAdmin(Long.parseLong(params.id))

        admin.properties = params

        if (admin.validate()) {
//            log.info('updateAdmin(): {}', admin)
            if (admin.save(flush: true)) {
                return true
            } else {
                return false
            }
        } else {
            return false
        }
    }
}
