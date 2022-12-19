package nl.miwgroningen.ch10.robbin.dvdLibrary.controller;

import nl.miwgroningen.ch10.robbin.dvdLibrary.model.Director;
import nl.miwgroningen.ch10.robbin.dvdLibrary.repository.DirectorRepository;
import nl.miwgroningen.ch10.robbin.dvdLibrary.repository.FilmRepository;
import org.springframework.data.domain.Sort;
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
    private final FilmRepository filmRepository;

    public DirectorController(DirectorRepository directorRepository, FilmRepository filmRepository) {
        this.directorRepository = directorRepository;
        this.filmRepository = filmRepository;
    }

    @GetMapping("/all")
    protected String showAuthorOverview(@RequestParam(required = false) String sortBy, Model model) {
        model.addAttribute("allDirectors", directorRepository.findByOrderByLastNameAsc());

        return "directorOverview";
    }

    @GetMapping("/details/{directorId}")
    protected String showDirectorDetail(@PathVariable("directorId") Long directorId, Model model) {
        Optional<Director> director = directorRepository.findById(directorId);

        if (director.isPresent()) {
            model.addAttribute("directorToShow", director.get());
            return "directorDetails";
        }
        return "redirect:/directors/all";
    }

    @GetMapping("/new")
    protected String showNewDirectorForm(Model model) {
        return showFormForDirector(model, new Director());
    }

    private String showFormForDirector(Model model, Director director) {
        model.addAttribute("director", director);

        return "directorForm";
    }

    @PostMapping("/new")
    protected String addDirector(@ModelAttribute ("director") Director directorToAdd, BindingResult result) {
        if(!result.hasErrors()) {
            directorRepository.save(directorToAdd);
        }

        return "redirect:/directors/all";
    }

}


