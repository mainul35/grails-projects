package sm.trading.erp

import grails.core.GrailsApplication
import grails.gorm.transactions.Transactional

import javax.imageio.ImageIO
import javax.servlet.ServletContext
import java.awt.image.BufferedImage

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
            String filePath = '/students/' + userId + '/'
            realPath = grailsApplication.config.uploadFolder = grailsApplication.mainContext.getResource('/WEB-INF/resources').file.getAbsolutePath()
            dir = new File(realPath + filePath)
            if (!dir.exists()) {
                dir.mkdirs()
            }
            fileName = UUID.randomUUID().toString() + '.' + extension
            dir = (realPath + filePath + fileName)

            boolean isUploaded = upload(file, dir)
            if (isUploaded) {
                file = filePath + fileName
                return file
            }
        }
        return null
    }

    def getFile(String filePath) {
        try {
            File file = new File(grailsApplication.mainContext.getResource('/WEB-INF/resources').file.getAbsolutePath() + filePath)

            return file.bytes.encodeBase64().toString()
        } catch (Exception e) {
            e.printStackTrace()
        }
    }
}
