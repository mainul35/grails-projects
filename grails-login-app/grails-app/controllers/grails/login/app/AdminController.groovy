package grails.login.app

class AdminController {

    AuthService authService
    StudentService studentService
    SemesterService semesterService
    DepartmentService departmentService
    UploadService uploadService

    def dashboard() {
        log.info('dashboard(): {}', authService.getAuthentication())
        [user: authService.getAuthentication().user]
    }

    def 'create-semester'() {
        render(view: '/semester/createSemester', model: [courses: Course.findAll()])
    }

    def 'register-student'() {
        if (!params) {
            render(view: 'createStudent')
            return
        } else {
            def returnedResult
            //            uploadService.upload(file)

            Student student = new Student()
//            student.properties = params
            student.name = params?.name
            student.email = params?.email
            student.password = params?.password
            student.role = 'ROLE_STUDENT'
            student.stdId = params?.stdId
            student.gender = params?.gender ? params.gender.toInteger() : 0
            student.dateOfBirth = params?.dateOfBirth
            student.semester = semesterService.getSemester(params?.semester ? params?.semester.toInteger() : 0)
            student.department = departmentService.getDepartment(params?.department ? params?.department.toInteger() : 0)


            def uploadedFile
            if ((params.image)) {
                uploadedFile = request.getFile('image')
                def fileNameSplittedArr = uploadedFile.filename.split('\\.')
                String extension = fileNameSplittedArr[fileNameSplittedArr.length - 1]
                String tempName = '' + System.currentTimeMillis() + '.' + extension
                uploadService.upload(uploadedFile, tempName)
                student.profileImageName = tempName
            }

            if (student.validate()) {
                returnedResult = studentService.createStudent(student)
                def status, msg
                log.info('create-student(): {}', returnedResult)
                if (returnedResult) {
                    status = true
                    msg = 'student created'
                } else if (!returnedResult) {
                    status = false
                    msg = 'student could not be created'
                }

                render(view: 'createStudent',
                        model: [
                                status     : status,
                                msg        : msg,
                                semesters  : semesterService.getAll(),
                                departments: departmentService.getAll()
                        ]
                )
            } else {
                render(view: 'createStudent',
                        model: [
                                semesters  : semesterService.getAll(),
                                departments: departmentService.getAll()
                        ]
                )
            }
        }
    }
}