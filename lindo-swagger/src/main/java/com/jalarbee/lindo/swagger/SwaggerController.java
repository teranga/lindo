package com.jalarbee.lindo.swagger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by diallo on 4/11/15.
 */
@Controller
public class SwaggerController {

    @RequestMapping("/")
    public String home() {
        return "index.html";
    }
}
