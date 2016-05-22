package exceptions;

public class EntityNotFoundException extends Exception {

    public EntityNotFoundException() {
        super();
    }

    public EntityNotFoundException(String msg)
    {
        super(msg);
    }

    public EntityNotFoundException(Throwable cause) {
        super(cause);
    }

     public EntityNotFoundException(String msg, Throwable cause){
         super(msg, cause);
     }
}