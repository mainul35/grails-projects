package sms

class Student {

    String name
    int age
    static constraints = {
        name unique: true, blank: false, nullable: false
        age range: 0..200
    }

    static mapping = {
        version false
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
