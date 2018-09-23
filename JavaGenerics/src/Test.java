
class Test {

    public static void main(String[] args) throws ReflectiveOperationException {
        Student student = (Student) ConfigurationInitializer.init(Student.class);
        student.hi();
    }
}
