package grails.login.app

import grails.core.GrailsApplication
import grails.gorm.transactions.Transactional

import javax.imageio.ImageIO

@Transactional
class UploadService {

    GrailsApplication grailsApplication

    public static final String FILE_PATH = 'C:/temp/'

    def upload(def file, String name){

        try {
            if (file && !file.empty) {
                log.info('upload(): grailsApplication.config.uploadFolder = {}', grailsApplication.config.uploadFolder)
                file.transferTo(new File("${grailsApplication.config.uploadFolder}${name}"))
                log.info('register-student(): {}', 'Image uploaded!')
            } else {
                log.info('register-student(): {}', 'Image upload failed!')
            }
        }
        catch (Exception e) {
            log.error("Exception occurred in uploading image: {}", e)
        }
    }

    def readFile(def fileName){
        return new File()
    }

    byte[] getImage(imageName) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream()
        ImageIO.write(ImageIO.read(new File("${FILE_PATH}${imageName}")), "jpg", baos)
        return baos.toByteArray()
    }
}
