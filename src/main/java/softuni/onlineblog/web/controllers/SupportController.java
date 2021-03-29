package softuni.onlineblog.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import softuni.onlineblog.domain.models.binding.TicketBindingModel;
import softuni.onlineblog.services.SupportService;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/support")
public class SupportController {

    private SupportService supportService;

    @Autowired
    public SupportController(SupportService supportService) {
        this.supportService = supportService;
    }

    @PostMapping("/contact-us")
    public ResponseEntity<Void> contactUs(@Valid @RequestBody TicketBindingModel ticketBindingModel, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.toString());
            return ResponseEntity.badRequest().build();
        }else{
            supportService.addTicket(ticketBindingModel.getSubject(),ticketBindingModel.getMessage(),ticketBindingModel.getMessage());

        }


        return ResponseEntity.created(URI.create("/contact-us")).build();
    }
}
