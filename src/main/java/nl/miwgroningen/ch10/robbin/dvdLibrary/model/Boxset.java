package nl.miwgroningen.ch10.robbin.dvdLibrary.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
@Entity @Getter @Setter
public class Boxset {

    @Id
    @GeneratedValue
    private Long boxsetId;

    @NotNull
    private String title;

    @OneToMany (mappedBy = "boxset")
    Set<Disc> discs;


}
