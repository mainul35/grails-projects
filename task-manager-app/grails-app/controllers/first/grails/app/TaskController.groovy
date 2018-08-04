package first.grails.app

import grails.converters.JSON
import org.springframework.http.HttpStatus

class TaskController {

    TaskService taskService
    static scaffold = Task

    def viewAllTasks() {
        List<Task> tasks = Task.findAll()
        def message = tasks.size() < 1 ? "Sorry, No data Found!" : "Displaying all data"
        [tasks: tasks, message: message]
    }

    def addTask() {
        def tags = Tag.findAll();
        [tags: tags]
    }

    def addTask_POST(Task task) {
        if (task == null) {
            render status: HttpStatus.NOT_FOUND
            return
        }

        if (task.hasErrors()) {
            println "Task error found"
            respond task.errors, view: '/task/addTask'
            return
        }

        taskService.saveTask(task)

        def tags = Tag.findAll()
        [message: "Task saved successfully.", tags: tags]
        request.withFormat {
            form multipartForm { redirect(controller: "task", action: "viewAllTasks") }
            '*' { respond task, status: HttpStatus.CREATED }
        }
    }

    def viewMore(String title) {
        render Task.findByTitle(title == null ? "" : title) == null ? "Sorry, nothing to show!" : Task.findByTitle(title) as JSON
    }
}
