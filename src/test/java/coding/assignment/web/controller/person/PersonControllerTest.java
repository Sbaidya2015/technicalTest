package coding.assignment.web.controller.person;

import coding.assignment.AssignmentApplication;
import coding.assignment.domain.person.Person;
import coding.assignment.domain.person.PersonRepo;
import coding.assignment.web.controller.person.dto.PersonDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = AssignmentApplication.class)
@AutoConfigureMockMvc
@ExtendWith({SpringExtension.class})
@Log4j2
public class PersonControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    PersonRepo personRepo;

    @Test
    public void personControllerPostTest() throws Exception {

        Person person = new Person();
        person.setAge(27);
        person.setFullname("X Y");
        person.setGender("MALE");
        person.setEmail("xy@yahoo.com");
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonPerson = objectMapper.writeValueAsString(person);
        this.mvc.perform(MockMvcRequestBuilders.post("/person").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(jsonPerson)).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());

    }

    @Test
    public void personControllerGetTest() throws Exception {
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
       // this.mvc.perform(MockMvcRequestBuilders.get("/person").accept(MediaType.APPLICATION_JSON).requestAttr("gender","Male")).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());

    }


}
