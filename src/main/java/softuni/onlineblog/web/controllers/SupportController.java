package softuni.onlineblog.web.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import softuni.onlineblog.domain.models.binding.TicketBindingModel;
import softuni.onlineblog.exceptions.InvalidDataException;
import softuni.onlineblog.services.SupportService;
import softuni.onlineblog.util.error.Error;
import softuni.onlineblog.util.error.JsonExceptionBody;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/support")
public class SupportController {

    private SupportService supportService;

    @Autowired
    public SupportController(SupportService supportService) {
        this.supportService = supportService;
    }

    @PostMapping("/contact-us")
    public ResponseEntity<String> contactUs(@Valid @RequestBody TicketBindingModel ticketBindingModel, BindingResult bindingResult) throws JsonProcessingException, InvalidDataException {


        if (bindingResult.hasErrors()) {
            JsonExceptionBody jsonExceptionBody=new JsonExceptionBody(HttpStatus.BAD_REQUEST.value());
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                jsonExceptionBody.addError(new Error(fieldError.getField(),fieldError.getDefaultMessage()));
            }
                throw new InvalidDataException(jsonExceptionBody.toString());


        }else{
            supportService.addTicket(ticketBindingModel.getSubject(),ticketBindingModel.getMessage(),ticketBindingModel.getMessage());

        }


        return ResponseEntity.created(URI.create("/contact-us")).build();
    }
}
