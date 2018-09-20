package grails.login.app

import grails.core.GrailsApplication
import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap

import javax.annotation.Resource
import javax.imageio.ImageIO
import javax.servlet.ServletContext

@Transactional
class UploadService {
    def assetResourceLocator
    UserService userService
    AuthService authService

    def writeToDisk(def file, String name) {
        try {
            if (file && !file.empty) {
                file.transferTo(new File("${name}"))
                log.info('register-student(): {}', 'Image uploaded!')
            } else {
                log.info('register-student(): {}', 'Image upload failed!')
            }
        }
        catch (Exception e) {
            log.error("Exception occurred in uploading image: {}", e)
        }
    }

    def upload(def file, GrailsParameterMap params) {
        def uploadedFile
        def fileNameSplittedArr
        def userType = params.role.equals('ROLE_STUDENT') ? 'student' : 'admin'
        def dir, fileName, realPath
        if (!file.filename.isEmpty()) {
            uploadedFile = file
            fileNameSplittedArr = uploadedFile.filename.split('\\.')
            String extension = fileNameSplittedArr[fileNameSplittedArr.length - 1]
            String systemPath = userType + '/' + authService.getAuthentication().user.id + '/'
            realPath = assetResourceLocator.resourceSearchDirectories[0] + 'grails-app/assets/images/'
            log.info('{}', realPath + systemPath)
            //grailsApplication.config.uploadFolder
            dir = new File(realPath + systemPath)
            if (!dir.exists()) {
                dir.mkdirs()
            }
            fileName = System.currentTimeMillis() + '.' + extension
            dir = (realPath + systemPath + fileName)

            writeToDisk(uploadedFile, dir)
            params.profileImageName = systemPath + fileName
        } else {
            try{
                params.profileImageName = userService.getUser(Long.parseLong(params.id)).profileImageName
            }catch (NumberFormatException nfe){
                nfe.printStackTrace()
                params.profileImageName = null
            }
        }
        return params.profileImageName
    }
}

