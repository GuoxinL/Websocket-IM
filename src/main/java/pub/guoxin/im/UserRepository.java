package pub.guoxin.im;


import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import pub.guoxin.im.model.User;

/**
 * Created by guoxin on 17-5-28.
 */
@Repository
public interface UserRepository extends Neo4jRepository<User, Long> {
}
