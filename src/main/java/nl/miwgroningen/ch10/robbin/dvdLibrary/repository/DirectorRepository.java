package nl.miwgroningen.ch10.robbin.dvdLibrary.repository;

import nl.miwgroningen.ch10.robbin.dvdLibrary.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
    List<Director> findByOrderByLastNameAsc();
    List<Director> findByOrderByLastNameDesc();


}
