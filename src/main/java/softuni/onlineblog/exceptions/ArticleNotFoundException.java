package softuni.onlineblog.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ArticleNotFoundException  extends Exception{
    public ArticleNotFoundException(String message) {
        super(message);
    }
}
