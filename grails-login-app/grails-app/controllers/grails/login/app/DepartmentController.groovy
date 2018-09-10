package grails.login.app

class DepartmentController {

    DepartmentService departmentService

    def 'view-all-departments'() {
        render(view: 'view-all-departments', model: [departments: departmentService.getAll()])
    }

    def 'create-department'() {
        def returnedResult
        Department department = new Department()
        department.name = params.name
        if (department.validate()) {
            returnedResult = departmentService.createDepartment(department)
            def status, msg
            log.info('create-department(): {}', returnedResult)
            if (returnedResult) {
                status = true
                msg = 'department created'
            } else if (!returnedResult) {
                status = false
                msg = 'department could not be created'

            }
            render(view: 'createDepartment', model: [status: status, msg: msg])
        } else {
            render(view: 'createDepartment')
        }
    }

    def 'edit'(Integer id) {
        log.info('edit(): {}', id)
        [department: departmentService.getDepartment(id)]
    }

    def 'update'() {
        def returnedResult
        returnedResult = departmentService.updateDepartment(params)
        def status, msg
        log.info('update(): {}', returnedResult)
        if (returnedResult) {
            status = true
            msg = 'department updated'
        } else if (!returnedResult) {
            status = false
            msg = 'department could not be updated'
        }
        render(view: 'view-all-departments', model: [status: status, msg: msg, departments: departmentService.getAll()])
    }

    def delete(Integer id){
        def returnedResult
        returnedResult = departmentService.deleteDepartment(id)
        def status, msg
        log.info('delete(): {}', returnedResult)
        if (returnedResult) {
            status = true
            msg = 'department deleted'
        } else if (!returnedResult) {
            status = false
            msg = 'department could not be deleted'
        }
        render(view: 'view-all-departments', model: [status: status, msg: msg, departments: departmentService.getAll()])
    }

}
