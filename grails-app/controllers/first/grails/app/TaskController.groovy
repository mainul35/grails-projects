package first.grails.app

class TaskController {
    static scaffold = Task

    def random() {
        def staticAuthor = "Anonymous"
        def staticContent = "Real Programmers don't eat much quiche"
        [ author: staticAuthor, content: staticContent]
    }
}
