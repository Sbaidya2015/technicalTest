package coding.assignment.domain.person;

import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author User
 */
public interface PersonRepo extends JpaRepository<Person, Long> {

    Optional<List<Person>> findByGender(String  gender );

}
