package first.grails.app

import org.springframework.http.HttpStatus

class TaskController {
    static scaffold = Task

    def viewAllTasks() {
        List<Task> tasks = Task.findAll()
        def message = tasks.size() < 1 ? "Sorry, No data Found!" : "Displaying all data"
        [tasks: tasks, message: message]
    }

    def addTask() {}

    def addTask_POST(Task task) {
        println (task.toString());
        if (task == null) {
            render status: HttpStatus.NOT_FOUND
            return
        }

        if (task.hasErrors()) {
            println "Task error found"
            respond task.errors, view: '/task/addTask'
            return
        }

        task.setDateCreated(new  Date(System.currentTimeMillis()));
        task.setStatus("Open")
        task.save()
        flush: true
        request.withFormat {
            form multipartForm {redirect(controller: "task", action: "viewAllTasks") }
            '*' {respond task, status: HttpStatus.CREATED}
        }
    }
}
