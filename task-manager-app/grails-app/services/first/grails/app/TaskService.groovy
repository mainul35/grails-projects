package first.grails.app

import grails.gorm.transactions.Transactional

@Transactional
class TaskService {

    def saveTask(Task task){
        task.setDateCreated(new Date(System.currentTimeMillis()));
        task.setStatus("Open")


        for(Tag t: task.getTags()){
            task.addToTags(t);
        }

        task.save(flush: true)
    }
}
