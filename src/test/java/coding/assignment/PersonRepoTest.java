package coding.assignment;

import coding.assignment.domain.person.Person;
import coding.assignment.domain.person.PersonRepo;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@Log4j2
public class PersonRepoTest {
    @Autowired
    PersonRepo personRepo;

    @Test
    public void personRepoTest()
    {
        Person person = new Person();
        person.setAge(27);
        person.setFullname("X Y");
        person.setGender("MALE");
        person.setEmail("xy@yahoo.com");

        personRepo.save(person);

        person = new Person();
        person.setAge(28);
        person.setFullname("X YZ ");
        person.setGender("FEMALE");
        person.setEmail("xyz@yahoo.com");

        personRepo.save(person);

        List<Person> allperson =  personRepo.findAll();
        allperson.forEach(person1 -> {
            log.info(person1.getId()+"  "+person1.getFullname());

        });

    }



}
