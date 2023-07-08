package coding.assignment.web.controller.person;

import coding.assignment.AssignmentApplication;
import coding.assignment.domain.person.Person;
import coding.assignment.web.controller.person.dto.PersonDto;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = AssignmentApplication.class)
@AutoConfigureMockMvc
@ExtendWith({SpringExtension.class})
public class PersonControllerTest {

    @Autowired
    private MockMvc mvc;

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


    }


}
