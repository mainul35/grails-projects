package sm.trading.erp

import grails.core.GrailsApplication
import grails.gorm.transactions.Transactional

@Transactional
class UploadService {

    GrailsApplication grailsApplication

    private def upload(def file, String name){

        try {
            if (file && !file.empty) {
                file.transferTo(new File("${name}"))
                log.info('register(): {}', 'Image uploaded!')
                return true
            } else {
                log.info('register(): {}', 'Image upload failed!')
                return false
            }
        }
        catch (Exception e) {
            log.error("Exception occurred in uploading image: {}", e)
            return false
        }
    }


    def uploadFile(def file, def userId){
        def fileNameSplittedArr
        def dir, fileName, realPath
        if (file) {
            fileNameSplittedArr = file.filename.split('\\.')
            String extension = fileNameSplittedArr[fileNameSplittedArr.length - 1]
            String systemPath = '/students/' + userId + '/'
            realPath = grailsApplication.config.uploadFolder
            dir = new File(realPath + systemPath)
            if (!dir.exists()) {
                dir.mkdirs()
            }
            fileName = System.currentTimeMillis() + '.' + extension
            dir = (realPath + systemPath + fileName)

            upload(file, dir)
            file = systemPath + fileName
            return file
        }
        return null
    }
}
