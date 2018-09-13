package grails.login.app

class FileController {
    UploadService uploadService

    def getImage() {

        byte[] imageInBytes = new File(grailsApplication.config.uploadFolder + params.fileName).bytes

        response.with {
            setHeader('Content-length', imageInBytes.length.toString())
            contentType = 'image/jpg' // or the appropriate image content type
            outputStream << imageInBytes
            outputStream.flush()
        }
    }

    def 'files'(){
        ApplicationHolder.getApplication().getParentContext().getResource("file/recsys").getFile();
    }
}
