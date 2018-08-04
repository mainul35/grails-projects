package first.grails.app

class Tag {

    String tagName
    static hasMany = [tasks: Task]
    static belongsTo = Task
    static constraints = {
        tagName blank: false, unique: true
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", tagName='" + tagName + '\'' +
                '}';
    }
}
