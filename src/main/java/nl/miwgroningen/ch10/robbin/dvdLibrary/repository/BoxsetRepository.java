package nl.miwgroningen.ch10.robbin.dvdLibrary.repository;

import nl.miwgroningen.ch10.robbin.dvdLibrary.model.Boxset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
@Repository
public interface BoxsetRepository extends JpaRepository<Boxset, Long> {

}
