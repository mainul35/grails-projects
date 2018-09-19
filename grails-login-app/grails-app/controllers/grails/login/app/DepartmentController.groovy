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
            if (returnedResult) {
                status = true
                msg = g.message(code: 'dept.created')
            } else if (!returnedResult) {
                status = false
                msg = g.message(code: 'dept.creation.failed')

            }
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
        if (returnedResult) {
            status = true
            msg = g.message(code: 'dept.updated')
        } else if (!returnedResult) {
            status = false
            msg = g.message(code: 'dept.not.updated')
        }
        flash.message = [info: msg, success: status]
        redirect(controller: 'department', action: 'all')
        return
    }

    def delete(Integer id){
        if(!authService.getAuthentication().user.role.toString().equals('ROLE_ADMIN')){
            redirect(controller: 'auth', action: '403')
            return
        }
        def returnedResult, status, msg
        if(departmentService.getDepartment(id).students.size()>0){
            status = false
            msg = g.message(code: 'dept.has.zero')
            flash.message = [info: msg, success: status]
            redirect(controller: 'department', action: 'all')
            return
        }
        returnedResult = departmentService.deleteDepartment(id)

        if (returnedResult) {
            status = true
            msg = g.message(code: 'dept.deleted')
        } else if (!returnedResult) {
            status = false
            msg = g.message(code: 'dept.not.deleted')
        }
        flash.message = [info: msg, success: status]
        redirect(controller: 'department', action: 'all')
        return
    }

}
