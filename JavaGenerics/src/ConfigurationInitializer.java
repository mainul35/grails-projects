public class ConfigurationInitializer {

    public static Object init(Class<Student> domin) throws ReflectiveOperationException {
        return new SomeClass<Domain>().init(Domain.class);
    }


}
