package pub.guoxin.im.model;

import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Created by guoxin on 17-5-28.
 */
@NodeEntity
public class User {

    private Long id;
    private String username;
    private String password;

}
