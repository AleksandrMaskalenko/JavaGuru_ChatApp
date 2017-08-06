package lv.javaguru.api;


import java.util.List;

public class Response {

    private boolean success;
    private List<Error> errors;

    public static Response createSuccessResponce(){
        return new Response(false, null);}

    public Response(boolean success, List<Error> errors) {
        this.success = success;
        this.errors = errors;
    }
    public boolean isSuccess(){return success;}

    public  boolean isFail(){return !success;}

    public List<Error> getErrors() {
        return errors;
    }
}
