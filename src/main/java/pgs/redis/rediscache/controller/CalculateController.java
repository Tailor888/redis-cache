package pgs.redis.rediscache.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pkrawiec on 5/22/2017.
 */
@RestController
@RequestMapping("calc")
public class CalculateController {

    @RequestMapping("getResult")
    @Cacheable("getResult")
    public String getResult(@RequestParam(value = "random", required = false) Integer random) throws InterruptedException {
        String result = "result " + random;
        System.out.println(result);
        return result;
    }


    //these 2 methods require KeyGenerator Bean, else keys will be the same for both of them
    @RequestMapping("test1")
    @Cacheable("propertyTest")
    public String test1(@RequestParam(value = "random", required = false) Integer random) throws InterruptedException {
        System.out.println("test1 for: " + random);
        return "test1";
    }

    @RequestMapping("test2")
    @Cacheable("propertyTest")
    public String test2(@RequestParam(value = "random", required = false) Integer random) throws InterruptedException {
        System.out.println("test2 for: " + random);
        return "test2";
    }
}
