package net.citizensnpcs.api.scripting;

/**
 * Represents a script written in a scripting language such as Lua, Ruby, Python
 * or JavaScript.
 * 
 */
public interface Script {
    /**
     * Fetches the attribute with the specified name, or null if not found. The
     * returned attribute can be user-stored or a script variable, such as a
     * function. Script objects should be accessed through
     * {@link Script#invoke(String, Object...)}
     * 
     * @param name
     *            The key of the attribute
     * @return The attribute
     */
    public Object getAttribute(String name);

    /**
     * Sets the attribute with the given name and value.
     */
    public void setAttribute(String name, Object value);

    /**
     * Invokes a root-level method using the method name and args and returns
     * the result.
     * 
     * @param name
     * @param args
     * @return The result of the method call, or null if there was none
     */
    public Object invoke(String name, Object... args) throws NoSuchMethodException;

    /**
     * Invokes a method on the given object, which should be a return value or
     * scripting object.
     * 
     * @param instance
     *            The object instance to invoke the method on
     * @param name
     *            The name of the method
     * @param args
     *            The method arguments
     * @return The result of the method, if any
     * @throws NoSuchMethodException
     *             If no such method was found on the object
     */
    public Object invoke(Object instance, String name, Object... args) throws NoSuchMethodException;

    /**
     * Converts an object returned by a script to the given Java interface. The
     * class should be an interface, as although abstract classes are accepted
     * by the Rhino engine, this is not standard behaviour.
     * 
     * @param obj
     *            The object to convert
     * @param expected
     *            The expected interface
     * @return The converted class
     */
    public <T> T asInterface(Object obj, Class<T> expected);
}
