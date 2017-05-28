package pub.guoxin.im.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import pub.guoxin.im.UserRepository;

/**
 * Created by guoxin on 17-5-28.
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    
    
}
