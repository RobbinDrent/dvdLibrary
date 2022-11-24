package nl.miwgroningen.ch10.robbin.dvdLibrary.repository;

import nl.miwgroningen.ch10.robbin.dvdLibrary.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
public interface FilmRepository extends JpaRepository<Film, Long> {
}