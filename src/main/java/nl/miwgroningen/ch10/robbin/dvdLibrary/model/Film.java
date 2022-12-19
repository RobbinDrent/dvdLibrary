package nl.miwgroningen.ch10.robbin.dvdLibrary.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import nl.miwgroningen.ch10.robbin.dvdLibrary.repository.DirectorRepository;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
@Entity @Getter @Setter
public class Film {
    @Id
    @GeneratedValue
    private Long filmId;

    @NotNull
    private String title;

    private int releaseYear;

    @ManyToMany (mappedBy = "films")
    private Set<Director> directors;

    @OneToMany (mappedBy = "film")
    private Set<Disc> discs;

    public void addDirector(Director director) {

        directors.add(director);
        director.getFilms().add(this);
    }

    public String allDirectorsToString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Director director : directors) {
            stringBuilder.append(String.format("%s<br />", director.getDisplayName()));
        }

        return stringBuilder.toString();
    }
}
