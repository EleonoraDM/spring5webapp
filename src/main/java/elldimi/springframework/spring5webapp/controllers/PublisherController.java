package elldimi.springframework.spring5webapp.controllers;

import elldimi.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublisherController {
    private PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @RequestMapping("/publishers")
    public String getPublishers(Model model) {

        model.addAttribute("publishers", this.publisherRepository.findAll());

        return "publishers/list";
    }
}
