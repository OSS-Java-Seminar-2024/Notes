package smb.teatar.test.controller;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "Welcome to Theater app!";
    }

}