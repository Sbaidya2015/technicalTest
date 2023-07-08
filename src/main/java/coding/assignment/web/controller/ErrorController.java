package coding.assignment.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;

import java.util.Map;
import java.util.function.BiFunction;

import static coding.assignment.web.controller.ErrorController.ERROR;

@RestController
@RequestMapping({ERROR})
public class ErrorController extends AbstractErrorController {
    public static final String ERROR = "/error";
    @Autowired  ErrorAttributes errorAttributes;

    public ErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @RequestMapping
    public ResponseEntity<?> error(HttpServletRequest httpServletRequest) {
        WebRequest webRequest = new ServletWebRequest(httpServletRequest);
        BiFunction<WebRequest,ErrorAttributes, ResponseEntity<Map<String,Object>>> biFunction = (webRequests, errorAttributes)->{
            Map<String,Object> errorMap =    errorAttributes.getErrorAttributes(webRequests,Boolean.TRUE);
            HttpStatus status =   this.getStatus(httpServletRequest);
            return new ResponseEntity<Map<String,Object>>(errorMap,status);
        };
        return biFunction.apply(webRequest,errorAttributes);

    }

    @Override
    public String getErrorPath() {
        return ERROR;
    }
}
