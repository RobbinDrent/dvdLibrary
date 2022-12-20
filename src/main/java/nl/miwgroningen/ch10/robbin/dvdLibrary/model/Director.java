package nl.miwgroningen.ch10.robbin.dvdLibrary.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import nl.miwgroningen.ch10.robbin.dvdLibrary.controller.FilmController;
import nl.miwgroningen.ch10.robbin.dvdLibrary.repository.DirectorRepository;

import javax.naming.spi.DirectoryManager;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
@Entity @Setter @Getter
public class Director {

    @GeneratedValue
    @Id
    private Long directorId;

    @NotNull
    private String firstName;

    private String infixName;

    @NotNull
    private String lastName;

    private int dateOfBirth;
    private String country;

    @ManyToMany
    private Set<Film> films;

    public String getDisplayName() {
        String displayName = firstName;

        if (infixName != null){
            displayName += " " + infixName;
        }

        return displayName += " " + lastName;
    }

    public int getNumberOfFilms() {
        return films.size();
    }

    public Director mostFilmsPerDirector(DirectorRepository repository) {
        Director tempDirector = new Director();
        for (Director director : repository.findAll()) {
            if (director.getFilms().size() >= tempDirector.getFilms().size()) {
                tempDirector = director;
            }
        }
        return tempDirector;
    }

}
