package nl.miwgroningen.ch10.robbin.dvdLibrary.controller;

import nl.miwgroningen.ch10.robbin.dvdLibrary.model.Director;
import nl.miwgroningen.ch10.robbin.dvdLibrary.model.Film;
import nl.miwgroningen.ch10.robbin.dvdLibrary.repository.DirectorRepository;
import nl.miwgroningen.ch10.robbin.dvdLibrary.repository.DiscRepository;
import nl.miwgroningen.ch10.robbin.dvdLibrary.repository.FilmRepository;
import org.springframework.cglib.beans.FixedKeySet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
@Controller @RequestMapping("/statistics")
public class StatisticsController {
    private final DirectorRepository directorRepository;
    private final DiscRepository discRepository;
    private final FilmRepository filmRepository;

    public StatisticsController(DirectorRepository directorRepository, DiscRepository discRepository, FilmRepository filmRepository) {
        this.directorRepository = directorRepository;
        this.discRepository = discRepository;
        this.filmRepository = filmRepository;
    }

    @GetMapping("/all")
    protected String showStatisticsOverview(Model model) {
        model.addAttribute("allDirectors", directorRepository.findAll());
        model.addAttribute("allDiscs", discRepository.findAll());
        model.addAttribute("allFilms", filmRepository.findAll());
        model.addAttribute("directorMostFilms", findDirectorWithMostFilm());

        return "statisticsOverview";
    }

    protected Director findDirectorWithMostFilm() {
        Director tempDirector = new Director();
        Set<Film> films = new HashSet<>();
        tempDirector.setFilms(films);

        for (Director director : directorRepository.findAll()) {
            if (tempDirector.getFilms().size() <= director.getFilms().size()) {
                tempDirector = director;
            }
        }
        return tempDirector;
    }
}
