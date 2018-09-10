package grails.login.app

class StudentController {

    AuthService authService
    StudentService studentService
    SemesterService semesterService
    DepartmentService departmentService
    UploadService uploadService

    def dashboard() {
        log.info('dashboard(): {}', authService.getAuthentication())
        [user: authService.getAuthentication().user]
    }

    def 'view-all-students'() {
        render(view: 'view-all-students', model: [students: studentService.getAll()])
    }

    def 'edit'(Integer id) {
        log.info('edit(): {}', id)
        [
                student: studentService.getStudent(id),
                semesters: semesterService.getAll(),
                departments: departmentService.getAll()
        ]
    }

    def 'update'() {
        def returnedResult
        def uploadedFile

        if((params.image)){
            uploadedFile = request.getFile('image')
            def fileNameSplittedArr = uploadedFile.filename.split('\\.')
            String extension = fileNameSplittedArr[fileNameSplittedArr.length-1]
            String tempName = ''+System.currentTimeMillis()+'.'+extension
            uploadService.upload(uploadedFile, tempName)
            params.profileImageName = tempName
        }
        returnedResult = studentService.updateStudent(params)
        def status, msg


        log.info('update(): {}', returnedResult)
        if (returnedResult) {
            status = true
            msg = 'student updated'
        } else if (!returnedResult) {
            status = false
            msg = 'student could not be updated'
        }
        render(view: 'view-all-students', model: [status: status, msg: msg, students: studentService.getAll()])
    }

    def delete(Integer id) {
        def returnedResult
        returnedResult = studentService.deleteStudent(id)
        def status, msg
        log.info('delete(): {}', returnedResult)
        if (returnedResult) {
            status = true
            msg = 'student deleted'
        } else if (!returnedResult) {
            status = false
            msg = 'student could not be deleted'
        }
        render(view: 'view-all-students', model: [status: status, msg: msg, students: studentService.getAll()])
    }

    def 'profile'(){
        def id = params.id
        render(view: 'view-profile', model: [student: studentService.getStudent(id)])
    }
}
