package bookstore;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import bookstore.web.controllers.BookstoreController;

@ControllerAdvice
public class REEH extends ResponseEntityExceptionHandler {

	private BookstoreController bC;

	public REEH(BookstoreController bC) {
		this.bC = bC;
	}

	@ExceptionHandler({ AccessDeniedException.class })
	public String handleAccessDeniedException(Exception e, WebRequest wR) {
		bC.setErrorMessage("Access denied, sorry!");
		return "redirect:/booklist";
	}

}
