package exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class EntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorMessage> handleAllExceptions(Exception ex, WebRequest request) {

		ErrorMessage errorMsg = new ErrorMessage(ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorMsg, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}