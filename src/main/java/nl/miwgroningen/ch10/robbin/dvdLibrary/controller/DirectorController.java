package nl.miwgroningen.ch10.robbin.dvdLibrary.controller;

import lombok.Getter;
import nl.miwgroningen.ch10.robbin.dvdLibrary.model.Director;
import nl.miwgroningen.ch10.robbin.dvdLibrary.repository.DirectorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
@Controller @RequestMapping("/directors")
public class DirectorController {
    private final DirectorRepository directorRepository;

    public DirectorController(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @GetMapping("/all")
    protected String showAuthorOverview(@RequestParam(required = false) String sortBy, Model model) {
        model.addAttribute("allDirectors", directorRepository.findByOrderByLastNameAsc());

        return "directorOverview";
    }

    @GetMapping("/new/directorId")
    protected String showDirectorDetail(@PathVariable("directorId") Long directorId, Model model) {
        Optional<Director> director = directorRepository.findById(directorId);

        if (director.isPresent()) {
            model.addAttribute("directorToShow", director.get());
            return "directorDetails";
        }
        return "redirect:/directors/all";
    }
}


