package grails.login.app

import grails.gorm.transactions.Transactional

class GlobalConfigService {
    CourseService courseService
    DepartmentService departmentService
    SemesterService semesterService

    public static boolean isBuilding = false;
    public static boolean isGeneratingSchema = false;

    def itemsPerPage() {
        return 5
    }

    public static String getUID(){
        return UUID.randomUUID().toString().toUpperCase();
    }

}
