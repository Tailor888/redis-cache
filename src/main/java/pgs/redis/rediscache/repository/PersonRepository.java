package pgs.redis.rediscache.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import pgs.redis.rediscache.model.Person;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by pkrawiec on 5/22/2017.
 */
@Repository
public class PersonRepository {

    private static final String KEY = "Person";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;

    @PostConstruct
    private void init() {
        //setting used data structure
        hashOperations = redisTemplate.opsForHash();
    }

    public void save(Person person) {
        hashOperations.put(KEY, person.getId(), person);
    }

    public void update(Person person) {
        hashOperations.put(KEY, person.getId(), person);
    }

    public Person find(Integer id) {
        System.out.println("Find");
        return (Person) hashOperations.get(KEY, id);
    }

    public List<Person> findAll() {
        System.out.println("FindAll");
        return hashOperations.values(KEY);
    }

    public void delete(Integer id) {
        hashOperations.delete(KEY, id);
    }

    public void clear() {
        redisTemplate.getConnectionFactory().getConnection().flushAll();
    }
}
