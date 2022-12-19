package nl.miwgroningen.ch10.robbin.dvdLibrary.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

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

    public String getDisplayName() {
        String displayName = firstName;

        if (!infixName.equals("")){
            displayName += " " + infixName;
        }

        return displayName += " " + lastName;
    }

}
