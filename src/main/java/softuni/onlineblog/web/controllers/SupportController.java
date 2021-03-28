package softuni.onlineblog.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import softuni.onlineblog.domain.models.binding.TicketBindingModel;

@RestController
@RequestMapping(value = "/support")
public class SupportController {

    @PostMapping("/contact-us")
    public ResponseEntity<Void> contactUs(@RequestBody TicketBindingModel ticketBindingModel) {
        System.out.println(ticketBindingModel);

        return ResponseEntity.ok().build();
    }
}
