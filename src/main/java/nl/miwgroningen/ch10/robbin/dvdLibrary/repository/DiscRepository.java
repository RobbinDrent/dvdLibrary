package nl.miwgroningen.ch10.robbin.dvdLibrary.repository;

import nl.miwgroningen.ch10.robbin.dvdLibrary.model.Disc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
@Repository
public interface DiscRepository extends JpaRepository<Disc, Long> {

}
