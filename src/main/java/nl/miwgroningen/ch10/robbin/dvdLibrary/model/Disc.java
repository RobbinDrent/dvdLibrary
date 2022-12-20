package nl.miwgroningen.ch10.robbin.dvdLibrary.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
@Entity @Getter @Setter
public class Disc {

    @Id
    @GeneratedValue
    private Long discId;

    @NotNull
    private boolean isDVD;

    private String description;
    private String distributor;

    @ManyToOne
    private Film film;

    @ManyToOne
    private Boxset boxset;

    public String returnFormat() {
        if (isDVD) {
            return "DVD";
        }

        return "Blu-Ray";
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (distributor != null) {
            stringBuilder.append(String.format("Uitgever: %s<br />", distributor));
        }

        if (description != null) {
            stringBuilder.append(String.format("%s", description));
        }

        return stringBuilder.toString();
    }

}
