package nl.miwgroningen.ch10.robbin.dvdLibrary.controller;

import nl.miwgroningen.ch10.robbin.dvdLibrary.model.Boxset;
import nl.miwgroningen.ch10.robbin.dvdLibrary.model.Director;
import nl.miwgroningen.ch10.robbin.dvdLibrary.model.Disc;
import nl.miwgroningen.ch10.robbin.dvdLibrary.model.Film;
import nl.miwgroningen.ch10.robbin.dvdLibrary.repository.BoxsetRepository;
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
    private final BoxsetRepository boxsetRepository;

    public SeedController(DirectorRepository directorRepository, FilmRepository filmRepository,
                          DiscRepository discRepository, BoxsetRepository boxsetRepository) {
        this.directorRepository = directorRepository;
        this.filmRepository = filmRepository;
        this.discRepository = discRepository;
        this.boxsetRepository = boxsetRepository;
    }

    @GetMapping("/seed")
    protected String seedDatabase(){
        // Add directors
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

        Director Lang = new Director();
        Lang.setFirstName("Fritz");
        Lang.setLastName("Lang");
        Lang.setCountry("Oostenrijk");
        Lang.setDateOfBirth(1890);

        Director Imamura = new Director();
        Imamura.setFirstName("Shohei");
        Imamura.setLastName("Imamura");
        Imamura.setCountry("Japan");
        Imamura.setDateOfBirth(1926);

        Director Jia = new Director();
        Jia.setFirstName("Zhangke");
        Jia.setLastName("Jia");
        Jia.setCountry("China");
        Jia.setDateOfBirth(1970);

        Director Tashlin = new Director();
        Tashlin.setFirstName("Frank");
        Tashlin.setLastName("Tashlin");
        Tashlin.setCountry("Verenigde Staten");
        Tashlin.setDateOfBirth(1913);

        Director Naruse = new Director();
        Naruse.setFirstName("Mikio");
        Naruse.setLastName("Naruse");
        Naruse.setCountry("Japan");
        Naruse.setDateOfBirth(1905);

        directorRepository.save(Scorsese);
        directorRepository.save(Kurosawa);
        directorRepository.save(Altman);
        directorRepository.save(ECoen);
        directorRepository.save(JCoen);
        directorRepository.save(Lang);
        directorRepository.save(Imamura);
        directorRepository.save(Jia);
        directorRepository.save(Tashlin);
        directorRepository.save(Naruse);

        // Add films

        Film taxiDriver = new Film();
        taxiDriver.setTitle("Taxi Driver");
        taxiDriver.setReleaseYear(1976);
        Set<Director> taxiDriverDirectors = new HashSet<>();
        taxiDriverDirectors.add(Scorsese);
        taxiDriver.setDirectors(taxiDriverDirectors);

        Film sevenSamurai = new Film();
        sevenSamurai.setTitle("Seven Samurai");
        sevenSamurai.setReleaseYear(1954);
        Set<Director> sevenSamuraiDirectors = new HashSet<>();
        sevenSamuraiDirectors.add(Kurosawa);
        sevenSamurai.setDirectors(sevenSamuraiDirectors);

        Film rashomon = new Film();
        rashomon.setTitle("Rashomôn");
        rashomon.setReleaseYear(1950);

        Film ran = new Film();
        ran.setTitle("Ran");
        ran.setReleaseYear(1985);

        Film fargo = new Film();
        fargo.setTitle("Fargo");
        fargo.setReleaseYear(1996);

        Film mFilm = new Film();
        mFilm.setTitle("M");
        mFilm.setReleaseYear(1931);

        Film profound = new Film();
        profound.setTitle("Profound Desires of the Gods");
        profound.setReleaseYear(1968);

        Film world = new Film();
        world.setTitle("The World");
        world.setReleaseYear(2004);

        Film rockHunter = new Film();
        rockHunter.setTitle("Will Success Spoil Rock Hunter?");
        rockHunter.setReleaseYear(1957);

        Film repast = new Film();
        repast.setTitle("Repast");
        repast.setReleaseYear(1951);

        Film soundOfTheMountain = new Film();
        soundOfTheMountain.setTitle("Sound of the Mountain");
        soundOfTheMountain.setReleaseYear(1954);

        Film flowing = new Film();
        flowing.setTitle("Flowing");
        flowing.setReleaseYear(1956);

        filmRepository.save(taxiDriver);
        filmRepository.save(sevenSamurai);
        filmRepository.save(rashomon);
        filmRepository.save(ran);
        filmRepository.save(fargo);
        filmRepository.save(profound);
        filmRepository.save(world);
        filmRepository.save(rockHunter);
        filmRepository.save(mFilm);
        filmRepository.save(repast);
        filmRepository.save(soundOfTheMountain);
        filmRepository.save(flowing);

        // Create sets per director

        Set<Film> scorseseFilms = new HashSet<>();
        scorseseFilms.add(taxiDriver);

        Set<Film> kurosawaFilms = new HashSet<>();
        kurosawaFilms.add(sevenSamurai);
        kurosawaFilms.add(rashomon);
        kurosawaFilms.add(ran);

        Set<Film> eCoenFilms = new HashSet<>();
        eCoenFilms.add(fargo);

        Set<Film> jCoenFilms = new HashSet<>();
        jCoenFilms.add(fargo);

        Set<Film> langFilms = new HashSet<>();
        langFilms.add(mFilm);

        Set<Film> jiaFilms = new HashSet<>();
        jiaFilms.add(world);

        Set<Film> tashlinFilms = new HashSet<>();
        tashlinFilms.add(rockHunter);

        Set<Film> imamuraFilms = new HashSet<>();
        imamuraFilms.add(profound);

        Set<Film> naruseFilms = new HashSet<>();
        naruseFilms.add(repast);
        naruseFilms.add(soundOfTheMountain);
        naruseFilms.add(flowing);

        Scorsese.setFilms(scorseseFilms);
        Kurosawa.setFilms(kurosawaFilms);
        ECoen.setFilms(eCoenFilms);
        JCoen.setFilms(jCoenFilms);
        Lang.setFilms(langFilms);
        Jia.setFilms(jiaFilms);
        Tashlin.setFilms(tashlinFilms);
        Imamura.setFilms(imamuraFilms);
        Naruse.setFilms(naruseFilms);

        directorRepository.save(Scorsese);
        directorRepository.save(Kurosawa);
        directorRepository.save(Altman);
        directorRepository.save(ECoen);
        directorRepository.save(JCoen);
        directorRepository.save(Lang);
        directorRepository.save(Imamura);
        directorRepository.save(Jia);
        directorRepository.save(Tashlin);
        directorRepository.save(Naruse);

        // Add copies

        Disc sevenSamuraiBlu = new Disc();
        sevenSamuraiBlu.setDistributor("BFI");
        sevenSamuraiBlu.setDVD(false);

        Disc sevenSamuraiDVD = new Disc();
        sevenSamuraiDVD.setDistributor("Criterion");
        sevenSamuraiDVD.setDVD(true);

        Disc sevenSamuraiDVD2 = new Disc();
        sevenSamuraiDVD2.setDescription("Nederlandse uitgave");
        sevenSamuraiDVD2.setDVD(true);

        Disc filmM = new Disc();
        filmM.setDistributor("Masters of Cinema");
        filmM.setDVD(false);

        Disc rock = new Disc();
        rock.setDistributor("Masters of Cinema");
        rock.setDVD(false);

        Disc theWorld = new Disc();
        theWorld.setDistributor("Masters of Cinema");
        theWorld.setDVD(false);

        Disc desires = new Disc();
        desires.setDistributor("Masters of Cinema");
        desires.setDVD(false);

        Disc repastDvd = new Disc();
        repastDvd.setDistributor("Masters of Cinema");
        repastDvd.setDVD(true);

        Disc soundOfTheMountainDvd = new Disc();
        soundOfTheMountainDvd.setDistributor("Masters of Cinema");
        soundOfTheMountainDvd.setDVD(true);

        Disc flowingDvd = new Disc();
        flowingDvd.setDistributor("Masters of Cinema");
        flowingDvd.setDVD(true);

        // Create sets of copies per film

        Set<Disc> sevenSamuraiDiscs = new HashSet<>();
        sevenSamuraiDiscs.add(sevenSamuraiBlu);
        sevenSamuraiDiscs.add(sevenSamuraiDVD);
        sevenSamuraiDiscs.add(sevenSamuraiDVD2);

        sevenSamuraiBlu.setFilm(sevenSamurai);
        sevenSamuraiDVD.setFilm(sevenSamurai);
        sevenSamuraiDVD2.setFilm(sevenSamurai);

        Set<Disc> mDiscs = new HashSet<>();
        mDiscs.add(filmM);
        filmM.setFilm(mFilm);

        Set<Disc> profoundDiscs = new HashSet<>();
        profoundDiscs.add(desires);
        desires.setFilm(profound);

        Set<Disc> rockDiscs = new HashSet<>();
        rockDiscs.add(rock);
        rock.setFilm(rockHunter);

        Set<Disc> worldDiscs = new HashSet<>();
        worldDiscs.add(theWorld);
        theWorld.setFilm(world);

        Set<Disc> repastDiscs = new HashSet<>();
        repastDiscs.add(repastDvd);
        repastDvd.setFilm(repast);

        Set<Disc> soundOfTheMountainDiscs = new HashSet<>();
        soundOfTheMountainDiscs.add(soundOfTheMountainDvd);
        soundOfTheMountainDvd.setFilm(soundOfTheMountain);

        Set<Disc> flowingDiscs = new HashSet<>();
        flowingDiscs.add(flowingDvd);
        flowingDvd.setFilm(flowing);

        discRepository.save(sevenSamuraiBlu);
        discRepository.save(sevenSamuraiDVD);
        discRepository.save(sevenSamuraiDVD2);
        discRepository.save(filmM);
        discRepository.save(rock);
        discRepository.save(theWorld);
        discRepository.save(desires);
        discRepository.save(repastDvd);
        discRepository.save(soundOfTheMountainDvd);
        discRepository.save(flowingDvd);

        sevenSamurai.setDiscs(sevenSamuraiDiscs);
        mFilm.setDiscs(mDiscs);
        profound.setDiscs(profoundDiscs);
        world.setDiscs(worldDiscs);
        rockHunter.setDiscs(rockDiscs);
        repast.setDiscs(repastDiscs);
        soundOfTheMountain.setDiscs(soundOfTheMountainDiscs);
        flowing.setDiscs(flowingDiscs);

        filmRepository.save(taxiDriver);
        filmRepository.save(sevenSamurai);
        filmRepository.save(rashomon);
        filmRepository.save(ran);
        filmRepository.save(fargo);
        filmRepository.save(profound);
        filmRepository.save(world);
        filmRepository.save(rockHunter);
        filmRepository.save(mFilm);
        filmRepository.save(repast);
        filmRepository.save(soundOfTheMountain);
        filmRepository.save(flowing);

        // Create boxset

        Set<Disc> naruseDiscs = new HashSet<>();
        naruseDiscs.add(repastDvd);
        naruseDiscs.add(soundOfTheMountainDvd);
        naruseDiscs.add(flowingDvd);

        Boxset naruse1 = new Boxset();
        naruse1.setTitle("Naruse volume one");
        naruse1.setDiscs(naruseDiscs);

        repastDvd.setBoxset(naruse1);
        soundOfTheMountainDvd.setBoxset(naruse1);
        flowingDvd.setBoxset(naruse1);

        boxsetRepository.save(naruse1);

        return "redirect:/directors/all";

    }
}
