public class MyCheckedException extends Exception{
    public MyCheckedException(String message) {
        super(message);
    }

    public MyCheckedException(String message, Throwable cause) {
        super(message, cause);
    }
}
