package grails.login.app

class FileController {

    UploadService uploadService

    def getImage() {
        byte[] imageInBytes = uploadService.getImage(params.imageName)
        response.with {
            setHeader('Content-length', imageInBytes.length.toString())
            contentType = 'image/jpg' // or the appropriate image content type
            outputStream << imageInBytes
            outputStream.flush()
        }
    }
}
