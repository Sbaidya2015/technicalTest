package coding.assignment.domain.person;

/**
 *
 * @author User
 */
import coding.assignment.domain.CommonAuditBase;
import lombok.Data;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "TBL_PERSON")
@AttributeOverride(name = "id", column = @Column(name = Person.S_PERSON_ID))
public class Person  implements Serializable {

    public static final String S_PERSON_ID = "S_PERSON_ID";
    public static final String T_FULL_NAME = "T_FULL_NAME";
    public static final String N_AGE = "N_AGE";
    public static final String T_EMAIL = "T_EMAIL";
    public static final String T_GENDER = "T_GENDER";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = S_PERSON_ID, nullable = false)
    private Long id;

    @Column(name = T_FULL_NAME, nullable = false)
    private String fullname;

    @Column(name = N_AGE, nullable = false)
    private Integer age;

    @Column(name = T_EMAIL, nullable = false)
    private String email;

    @Column(name = T_GENDER, nullable = false)
    private String gender;

}
