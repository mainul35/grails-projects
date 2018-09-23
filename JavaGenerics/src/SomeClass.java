public class SomeClass<T> {

    public T init(Class<T> clazz) throws ReflectiveOperationException {
        return (T) new Something<T>().init(clazz);
    }

}
