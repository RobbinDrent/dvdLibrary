package nl.miwgroningen.ch10.robbin.dvdLibrary.controller;

import nl.miwgroningen.ch10.robbin.dvdLibrary.model.Film;
import nl.miwgroningen.ch10.robbin.dvdLibrary.repository.FilmRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.activation.FileTypeMap;
import java.util.Optional;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */

@Controller
public class FilmController {

    private final FilmRepository filmRepository;

    public FilmController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @GetMapping({"/films/all", "/"})
    protected String showFilmOverview(Model model) {
        model.addAttribute("allFilms", filmRepository.findAll());

        return "filmOverview";
    }

    @GetMapping("/films/new")
    protected String showNewFilmForm(Model model) {
        model.addAttribute("film", new Film());

        return "filmForm";
    }

    @GetMapping("/films/edit/{filmId}")
    protected String showEditBookForm(@PathVariable("filmId") Long filmId, Model model) {
        Optional<Film> film = filmRepository.findById(filmId);

        if (film.isPresent()) {
            model.addAttribute("film", film.get());
            return "filmForm";
        }
        return "redirect:/films/all";
    }


    @PostMapping({"/films/new"})
    protected String saveBook(@ModelAttribute("film") Film filmToBeSaved, BindingResult result) {
        if (!result.hasErrors()) {
            filmRepository.save(filmToBeSaved);
        }
        return "redirect:/films/all";
    }

    @GetMapping("/films/delete/{filmId}")
    protected String deleteFilm(@PathVariable("filmId") Long filmId) {
        Optional<Film> film = filmRepository.findById(filmId);

        if (film.isPresent()) {
            filmRepository.delete(film.get());
        }

        return "redirect:/films/all";
    }
}
