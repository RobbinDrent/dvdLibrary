package nl.miwgroningen.ch10.robbin.dvdLibrary.controller;

import nl.miwgroningen.ch10.robbin.dvdLibrary.model.Director;
import nl.miwgroningen.ch10.robbin.dvdLibrary.model.Disc;
import nl.miwgroningen.ch10.robbin.dvdLibrary.model.Film;
import nl.miwgroningen.ch10.robbin.dvdLibrary.repository.DirectorRepository;
import nl.miwgroningen.ch10.robbin.dvdLibrary.repository.DiscRepository;
import nl.miwgroningen.ch10.robbin.dvdLibrary.repository.FilmRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
@Controller
public class SeedController {

    private final DirectorRepository directorRepository;
    private final FilmRepository filmRepository;
    private final DiscRepository discRepository;

    public SeedController(DirectorRepository directorRepository, FilmRepository filmRepository, DiscRepository discRepository) {
        this.directorRepository = directorRepository;
        this.filmRepository = filmRepository;
        this.discRepository = discRepository;
    }

    @GetMapping("/seed")
    protected String seedDatabase(){
        Director Scorsese = new Director();
        Scorsese.setFirstName("Martin");
        Scorsese.setLastName("Scorsese");
        Scorsese.setCountry("Verenigde Staten");
        Scorsese.setDateOfBirth(1942);

        Director Kurosawa = new Director();
        Kurosawa.setFirstName("Akira");
        Kurosawa.setLastName("Kurosawa");
        Kurosawa.setCountry("Japan");
        Kurosawa.setDateOfBirth(1910);

        Director Altman = new Director();
        Altman.setFirstName("Robert");
        Altman.setLastName("Altman");
        Altman.setCountry("Verenigde Staten");
        Altman.setDateOfBirth(1925);

        Director ECoen = new Director();
        ECoen.setFirstName("Ethan");
        ECoen.setLastName("Coen");
        ECoen.setCountry("Verenigde Staten");
        ECoen.setDateOfBirth(1957);

        Director JCoen = new Director();
        JCoen.setFirstName("Joel");
        JCoen.setLastName("Coen");
        JCoen.setCountry("Verenigde Staten");
        JCoen.setDateOfBirth(1954);

        directorRepository.save(Scorsese);
        directorRepository.save(Kurosawa);
        directorRepository.save(Altman);
        directorRepository.save(ECoen);
        directorRepository.save(JCoen);

        Film taxiDriver = new Film();
        taxiDriver.setTitle("Taxi Driver");
        taxiDriver.setReleaseYear(1976);

        Film sevenSamurai = new Film();
        sevenSamurai.setTitle("Seven Samurai");
        sevenSamurai.setReleaseYear(1954);

        Film rashomon = new Film();
        rashomon.setTitle("Rashomôn");
        rashomon.setReleaseYear(1950);

        Film ran = new Film();
        ran.setTitle("Ran");
        ran.setReleaseYear(1985);

        Film fargo = new Film();
        fargo.setTitle("Fargo");
        fargo.setReleaseYear(1996);

        filmRepository.save(taxiDriver);
        filmRepository.save(sevenSamurai);
        filmRepository.save(rashomon);
        filmRepository.save(ran);
        filmRepository.save(fargo);

        Set<Film> films1 = new HashSet<>();
        films1.add(taxiDriver);

        Set<Film> films2 = new HashSet<>();
        films2.add(sevenSamurai);
        films2.add(rashomon);
        films2.add(ran);

        Set<Film> films3 = new HashSet<>();
        films3.add(fargo);

        Set<Film> films4 = new HashSet<>();
        films4.add(fargo);

        Scorsese.setFilms(films1);
        Kurosawa.setFilms(films2);
        ECoen.setFilms(films3);
        JCoen.setFilms(films4);

        directorRepository.save(Scorsese);
        directorRepository.save(Kurosawa);
        directorRepository.save(Altman);
        directorRepository.save(ECoen);
        directorRepository.save(JCoen);

        Disc sevenSamuraiBlu = new Disc();
        sevenSamuraiBlu.setDistributor("BFI");
        sevenSamuraiBlu.setDVD(false);

        Disc sevenSamuraiDVD = new Disc();
        sevenSamuraiDVD.setDistributor("Criterion");
        sevenSamuraiDVD.setDVD(true);

        Disc sevenSamuraiDVD2 = new Disc();
        sevenSamuraiDVD2.setDescription("Nederlandse uitgave");
        sevenSamuraiDVD2.setDVD(true);

        Set<Disc> sevenSamuraiDiscs = new HashSet<>();
        sevenSamuraiDiscs.add(sevenSamuraiBlu);
        sevenSamuraiDiscs.add(sevenSamuraiDVD);
        sevenSamuraiDiscs.add(sevenSamuraiDVD2);

        sevenSamuraiBlu.setFilm(sevenSamurai);
        sevenSamuraiDVD.setFilm(sevenSamurai);
        sevenSamuraiDVD2.setFilm(sevenSamurai);

        discRepository.save(sevenSamuraiBlu);
        discRepository.save(sevenSamuraiDVD);
        discRepository.save(sevenSamuraiDVD2);

        sevenSamurai.setDiscs(sevenSamuraiDiscs);
        filmRepository.save(sevenSamurai);

        return "redirect:/directors/all";

    }
}
