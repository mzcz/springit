package com.marcin.springit.controller;

import com.marcin.springit.domain.Link;
import com.marcin.springit.repository.LinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.swing.text.html.HTMLEditorKit;
import javax.validation.Valid;
import java.util.Optional;

//@RestController
//@RequestMapping("/links")
@Controller
public class LinkCotronller {

    private static final Logger logger = LoggerFactory.getLogger(HTMLEditorKit.LinkController.class);

    private LinkRepository linkRepository;

    public LinkCotronller(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }


    @GetMapping("/")
    public String List(Model model) {
        model.addAttribute("links", linkRepository.findAll());
        return "Link/list";
    }

    @GetMapping("/link/{id}")
    public String read(@PathVariable Long id, Model model) {
        Optional<Link> link = linkRepository.findById(id);
        if( link.isPresent() ) {
            Link currentLink = link.get();
            //Comment comment = new Comment();
            //comment.setLink(currentLink);
            //model.addAttribute("comment",comment);
            model.addAttribute("link",currentLink);
            model.addAttribute("success", model.containsAttribute("success"));
            return "link/view";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/link/submit")
    public String newLinkForm(Model model) {
        model.addAttribute("link",new Link());
        return "link/submit";
    }

    @PostMapping("/link/submit")
    public String createLink(@Valid Link link, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if( bindingResult.hasErrors() ) {
            logger.info("Validation errors were found while submitting a new link. - said Marcin");
            model.addAttribute("link",link);
            return "link/submit";
        } else {
            // save our link
            linkRepository.save(link);
            logger.info("New link was saved successfully- znów Marcin said\"");
            redirectAttributes
                    .addAttribute("id",link.getId())
                    .addFlashAttribute("success",true);
            return "redirect:/link/{id}";
        }
    }

/*
    // list
    @GetMapping("/")
    public List<Link> list() {
        return linkRepository.findAll();
    }

    // CRUD

    @PostMapping("/create")
    public Link create(@ModelAttribute Link link) {
        return linkRepository.save(link);
    }

    @GetMapping("/{id}")
    public Optional<Link> read(@PathVariable Long id) {
        return linkRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Link update(@PathVariable Long id, @ModelAttribute Link link) {
        //get the id
        return linkRepository.save(link);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        linkRepository.deleteById(id);
    }
    */
}
