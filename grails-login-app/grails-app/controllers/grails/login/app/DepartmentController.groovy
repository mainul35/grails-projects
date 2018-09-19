package grails.login.app

class DepartmentController {

    DepartmentService departmentService
    AuthService authService

    def index(){
        redirect(controller: 'auth', action: '404')
    }

    def all() {
        render(view: 'all', model: [departments: departmentService.getAll()])
    }

    def create() {
        if(!authService.getAuthentication().user.role.toString().equals('ROLE_ADMIN')){
            redirect(controller: 'auth', action: '403')
            return
        }
        def returnedResult
        Department department = new Department()
        department.name = params.name
        if (department.validate()) {
            returnedResult = departmentService.createDepartment(department)
            def status, msg
//            log.info('create(): {}', returnedResult)
            if (returnedResult) {
                status = true
                msg = 'department created'
            } else if (!returnedResult) {
                status = false
                msg = 'department could not be created'

            }
//            render(view: 'createDepartment', model: [status: status, msg: msg])
            flash.message = [info: msg, success: status]
            redirect(controller: 'department', action: 'all')
            return
        } else {
            render(view: 'createDepartment')
        }
    }

    def edit(Integer id) {
        if(!authService.getAuthentication().user.role.toString().equals('ROLE_ADMIN')){
            redirect(controller: 'auth', action: '403')
            return
        }
//        log.info('edit(): {}', id)
        [department: departmentService.getDepartment(id)]
    }

    def update() {
        if(!authService.getAuthentication().user.role.toString().equals('ROLE_ADMIN')){
            redirect(controller: 'auth', action: '403')
            return
        }
        def returnedResult
        returnedResult = departmentService.updateDepartment(params)
        def status, msg
//        log.info('update(): {}', returnedResult)
        if (returnedResult) {
            status = true
            msg = 'department updated'
        } else if (!returnedResult) {
            status = false
            msg = 'department could not be updated'
        }
//        render(view: 'all', model: [status: status, msg: msg, departments: departmentService.getAll()])
        flash.message = [info: msg, success: status]
        redirect(controller: 'department', action: 'all')
        return
    }

    def delete(Integer id){
        if(!authService.getAuthentication().user.role.toString().equals('ROLE_ADMIN')){
            redirect(controller: 'auth', action: '403')
            return
        }
        def returnedResult
        returnedResult = departmentService.deleteDepartment(id)
        def status, msg
//        log.info('delete(): {}', returnedResult)
        if (returnedResult) {
            status = true
            msg = 'department deleted'
        } else if (!returnedResult) {
            status = false
            msg = 'department could not be deleted'
        }
//        render(view: 'all', model: [status: status, msg: msg, departments: departmentService.getAll()])
        flash.message = [info: msg, success: status]
        redirect(controller: 'department', action: 'all')
        return
    }

}
