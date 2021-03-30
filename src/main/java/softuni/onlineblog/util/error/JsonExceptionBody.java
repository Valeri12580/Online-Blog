package softuni.onlineblog.util.error;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class JsonExceptionBody {

    private List<Error> errors;
    private int status;
    private LocalDateTime localDateTime;

    public JsonExceptionBody(int status) {
        this.errors = new ArrayList<>();
        this.status = status;
        this.localDateTime = LocalDateTime.now();
    }

    public void addError(Error error) {
        errors.add(error);
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {

            return "Err";
        }

    }
}
