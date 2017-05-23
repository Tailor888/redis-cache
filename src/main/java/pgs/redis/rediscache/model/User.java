package pgs.redis.rediscache.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by pkrawiec on 5/23/2017.
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class User implements Serializable {

    private Integer id;
    private String name;
}
