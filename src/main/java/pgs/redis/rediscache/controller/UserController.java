package pgs.redis.rediscache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pgs.redis.rediscache.model.User;
import pgs.redis.rediscache.repository.UserRepository;

/**
 * Created by pkrawiec on 5/23/2017.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("save")
    public String save(@RequestParam("id") Integer id, @RequestParam("name") String name) throws InterruptedException {
        User user = new User(id, name);
        userRepository.save(user);

        return user.toString();
    }

    @GetMapping("find")
    public String find(@RequestParam("id") Integer id) {
        return userRepository.find(id).toString();
    }

    @GetMapping("delete")
    public void delete(@RequestParam("id") Integer id) {
        userRepository.delete(id);
    }
}
