package ee.decathlon_calculator.controllers;

import jdk.jfr.Description;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DecathlonController extends BaseController {

    @GetMapping(
            path = "calculate-points",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Description("Api for consuming the decathlon parameters")
    public String getIndex() {
        return "Hello world";
    }
}
