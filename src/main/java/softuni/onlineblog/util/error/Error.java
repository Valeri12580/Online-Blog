package softuni.onlineblog.util.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Error {
    private String fieldName;
    private String message;


}
