package pgs.redis.rediscache.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pkrawiec on 5/23/2017.
 */
@Getter
@Setter
@ToString
public class User implements Serializable {

    private Integer id;
    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    private Map<String, String> propertyMap = new HashMap<>();

    public String getProperty(String key) {
        return propertyMap.get(key);
    }

    public String setProperty(String key, String value) {
        return propertyMap.put(key, value);
    }
}
