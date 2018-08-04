package first.grails.app

import grails.databinding.BindingFormat
import grails.rest.Resource

//@Resource(uri = "/tasks", formats = ['json', 'xml'])
class Task {

    String title
    String details
    Date dateCreated
    @BindingFormat('yyyy-MM-dd')
    Date deadline
    Long timeSpent = 0L
    String status = "Open"
    static hasMany = [tags:Tag]
    static constraints = {
        title blank: false, unique: true
        status inList: ["Open", "Done"], nullable: true
        details blank: false, maxSize: 1000
        deadline nullable: true
        timeSpent min: 0L
    }


    @Override
    public String toString() {
        return "Task{" +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", dateCreated=" + dateCreated +
                ", deadline=" + deadline +
                ", timeSpent=" + timeSpent +
                ", status='" + status + '\'' +
                '}';
    }
}
