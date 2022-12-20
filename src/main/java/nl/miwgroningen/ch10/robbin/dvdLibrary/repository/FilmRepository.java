package nl.miwgroningen.ch10.robbin.dvdLibrary.repository;

import nl.miwgroningen.ch10.robbin.dvdLibrary.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> findByOrderByTitleAsc();
    List<Film> findByOrderByTitleDesc();
    List<Film> findByOrderByReleaseYearAsc();
    List<Film> findByOrderByReleaseYearDesc();
//    List<Film> findByOrderByDirectorsAsc();
//    List<Film> findByOrderByDirectorsDesc();

}
