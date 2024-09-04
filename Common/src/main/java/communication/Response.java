package communication;

import java.io.Serializable;

/**
 *
 * @author Radin
 */
public class Response implements Serializable{
    Exception exception;
    Object result;

    public Response() {
    }

    public Response(Exception exception, Object result) {
        this.exception = exception;
        this.result = result;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}