package uz.pdp.g30springjpa.exception;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String message) {
        super(message);
    }

    public static DataNotFoundException withId(Long id){
        return new DataNotFoundException("Data not found with id: " + id);
    }
}
