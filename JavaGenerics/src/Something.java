class Something<T> {

    public T resources;

    public T init(Class<T> resources) throws ReflectiveOperationException {
        this.resources = (T)resources.newInstance();
        return this.resources;
    }
}