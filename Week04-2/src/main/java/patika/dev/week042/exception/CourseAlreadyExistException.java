package patika.dev.week042.exception;

public class CourseAlreadyExistException extends RuntimeException {

    public CourseAlreadyExistException(String message) {
        super(message);
    }
}
