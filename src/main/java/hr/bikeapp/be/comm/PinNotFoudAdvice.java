package hr.bikeapp.be.comm;

import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class PinNotFoudAdvice {

	  @ResponseBody
	  @ExceptionHandler(PinNotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  String pinNotFoundHandler(PinNotFoundException ex) {
	    return ex.getMessage();
	  }
	  
}
