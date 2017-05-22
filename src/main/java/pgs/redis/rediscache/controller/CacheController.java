package pgs.redis.rediscache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pgs.redis.rediscache.model.Person;
import pgs.redis.rediscache.repository.PersonRepository;

/**
 * Created by pkrawiec on 5/22/2017.
 */
@RestController
public class CacheController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("save")
    public String save(@RequestParam("id") Integer id, @RequestParam("name") String name) {
        Assert.notNull(id, "Empty id");
        Assert.notNull(name, "Empty name");

        Person person = new Person(id, name);
        personRepository.save(person);

        return person.toString();
    }

    @GetMapping("findAll")
    public String findAll() {
        return personRepository.findAll().toString();
    }

    @GetMapping("clear")
    public void clear() {
        personRepository.clear();
    }
}
