package coding.assignment.web.controller.home;

import javax.validation.ConstraintViolation;

import coding.assignment.domain.person.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Qualifier("PersonValidator")
public class PersonValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        Person person = (Person) o;
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(person.getFullname());
        if(m.find()) {
            errors.rejectValue("fullname", "Invalid Name");
        }

        if(person.getAge() !=null && person.getAge()<0)
        {
            errors.rejectValue("age", "Invalid Age");
        }


    }
}
