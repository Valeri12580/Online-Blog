package softuni.onlineblog.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import softuni.onlineblog.domain.models.binding.TicketBindingModel;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/support")
public class SupportController {

    @PostMapping("/contact-us")
    public ResponseEntity<Void> contactUs(@Valid @RequestBody TicketBindingModel ticketBindingModel, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.toString());
        }
        return ResponseEntity.created(URI.create("/contact-us")).build();
    }
}
