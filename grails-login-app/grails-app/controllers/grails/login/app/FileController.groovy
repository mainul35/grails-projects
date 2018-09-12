package grails.login.app

class FileController {
    UploadService uploadService

    def getImage() {

        byte[] imageInBytes = new File(UploadService.FILE_PATH + params.fileName).bytes

        response.with {
            setHeader('Content-length', imageInBytes.length.toString())
            contentType = 'image/jpg' // or the appropriate image content type
            outputStream << imageInBytes
            outputStream.flush()
        }
    }

    def 'get-image'(){
        g.resource(dir: grailsApplication.config.uploadFolder, file: params.imageName, absolute: true)
    }
}
