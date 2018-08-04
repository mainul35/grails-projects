package first.grails.app

import grails.converters.JSON
import org.springframework.http.HttpStatus

class TagController {

    static scaffold = Tag

    def saveTagPage(){}

    def saveTag_POST(Tag tag){
        if (tag == null) {
            render status: HttpStatus.NOT_FOUND
            return
        }

        if (tag.hasErrors()) {
            println tag.toString();
            respond tag.errors, view: '/tag/saveTagPage'
            return
        }

        tag.save()
        def message = "Tag saved successfully."
        [message: message]
        flush: true
        request.withFormat {
            form multipartForm {redirect(controller: "tag", action: "saveTagPage") }
            '*' {respond tag, status: HttpStatus.CREATED}
        }
    }

    def findAllTags(Long id) {
        render Tag.findById(id == null ? "" : id) == null ? "Sorry, no tag found!" : Tag.findById(id) as JSON
    }
}
