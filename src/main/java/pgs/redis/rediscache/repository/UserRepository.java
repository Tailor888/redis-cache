package pgs.redis.rediscache.repository;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import pgs.redis.rediscache.model.User;

/**
 * Created by pkrawiec on 5/23/2017.
 */
@Repository
public class UserRepository {

    /**
     * Method always run, result put into the cache
     */
    @CachePut(value = "users", key = "#user.id")
    public User save(User user) throws InterruptedException {

        System.out.println("Saving user: " + user.toString());
        return user;
    }

    /**
     * Method only run once
     */
    @Cacheable(value = "users", key = "#id")
    public User find(Integer id) {
        return null;
    }

    /**
     * deleting from cache
     */
    @CacheEvict(value = "users", key = "#id")
    public void delete(Integer id) {

    }
}
