package grails.login.app

import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap

@Transactional
class DepartmentService {

    def createDepartment(Department department) {
        if (department.save()) {
            return true
        } else {
            return false
        }
    }

    boolean updateDepartment(GrailsParameterMap params) {
        def department = getDepartment(Long.parseLong(params.id))
        if (department.validate()) {
            department.name = params.name
            if (department.save(flush: true)) {
                return true
            } else {
                return false
            }
        } else {
            return false
        }
    }

    def deleteDepartment(Integer id) {
        def department = getDepartment(id)
        try {
            department.delete(flush: true)
        } catch (Exception e) {
            println(e.getMessage())
            return false
        }
        return true
    }

    def getDepartment(Serializable id){
        return Department.get(id)
    }

    def getAll(){
        return Department.findAll()
    }

}
