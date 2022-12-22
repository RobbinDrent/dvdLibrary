package nl.miwgroningen.ch10.robbin.dvdLibrary.controller;

import nl.miwgroningen.ch10.robbin.dvdLibrary.model.Director;
import nl.miwgroningen.ch10.robbin.dvdLibrary.model.Film;
import nl.miwgroningen.ch10.robbin.dvdLibrary.repository.DirectorRepository;
import nl.miwgroningen.ch10.robbin.dvdLibrary.repository.FilmRepository;
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
@Controller @RequestMapping("/films")
public class FilmController {

    private final FilmRepository filmRepository;
    private final DirectorRepository directorRepository;

    public FilmController(FilmRepository filmRepository, DirectorRepository directorRepository) {
        this.filmRepository = filmRepository;
        this.directorRepository = directorRepository;
    }

    @GetMapping("/all")
    protected String showFilmOverview(@RequestParam(required = false) String sortBy, Model model) {
        if(sortBy == null){
            model.addAttribute("allFilms", filmRepository.findByOrderByTitleAsc());
        } else if (sortBy.equals("titleDesc")){
            model.addAttribute("allFilms", filmRepository.findByOrderByTitleDesc());
        } else if (sortBy.equals("titleAsc")){
            model.addAttribute("allFilms", filmRepository.findByOrderByTitleAsc());
        } else if (sortBy.equals("releaseYearDesc")){
            model.addAttribute("allFilms", filmRepository.findByOrderByReleaseYearDesc());
        } else if (sortBy.equals("releaseYearAsc")){
            model.addAttribute("allFilms", filmRepository.findByOrderByReleaseYearAsc());
        }

        return "filmOverview";
    }

    @GetMapping("/details/{filmId}")
    protected String showFilmDetails(@PathVariable("filmId") Long filmId, Model model) {
        Optional<Film> film = filmRepository.findById(filmId);

        if (film.isPresent()) {
            model.addAttribute("filmToShow", film.get());
            model.addAttribute("directorsOfFilm", film.get().getDirectors());

            return "filmDetails";
        }
        return "redirect:/films/all";
    }

    @GetMapping("/new")
    protected String showNewFilmForm(Model model) {
        return showFormForFilm(model, new Film());
    }

    private String showFormForFilm(Model model, Film film) {
        model.addAttribute("film", film);

        return "filmForm";
    }

    @PostMapping("/new")
    protected String addDirector(@ModelAttribute ("film") Film filmToAdd, BindingResult result) {
        if(!result.hasErrors()) {
            filmRepository.save(filmToAdd);
        }

        return "redirect:/directors/all";
    }

    @GetMapping("/edit/{filmId}")
    protected String showEditFilmForm(@PathVariable("filmId") Long filmId, Model model) {
        Optional<Film> film = filmRepository.findById(filmId);

        if (film.isPresent()) {
            return showFormForFilm(model, film.get());
        }

        return "redirect:/directors/all";
    }
}
