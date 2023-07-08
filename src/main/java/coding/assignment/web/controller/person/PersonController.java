package coding.assignment.web.controller.person;

import coding.assignment.domain.person.Person;
import coding.assignment.domain.person.PersonRepo;
import coding.assignment.web.controller.person.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController()
@RequestMapping(path = "/person", consumes = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {
    @Autowired
    PersonRepo personRepo;

    /**
     *
     * @param person
     * @return
     * Entry point to save Person data into database
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> storePersonData(@Valid @RequestBody Person person) {
        Person personCreated = personRepo.save(person);
        return new ResponseEntity<>(personCreated, HttpStatus.OK);
    }

    /**
     *
     * @param customQuery
     * @return
     * retrieve data from rest endpoint
     *
     */
    @GetMapping
    public ResponseEntity<?> searchPerson(@RequestParam Map<String, String> customQuery) {
        if (customQuery == null || customQuery.isEmpty()) {
            List<Person> allPerson = personRepo.findAll();
            return new ResponseEntity<>(allPerson, HttpStatus.OK);
        } else {
            String gender = customQuery.entrySet().stream().filter(map -> "gender".equalsIgnoreCase(map.getKey())).map(map -> map.getValue()).collect(Collectors.joining());
            Optional<List<Person>> allPerson = personRepo.findByGender(gender);
            if (allPerson.isPresent()) {
                return new ResponseEntity<>(allPerson.get(), HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
