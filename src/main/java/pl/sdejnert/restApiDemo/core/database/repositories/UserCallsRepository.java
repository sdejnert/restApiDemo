package pl.sdejnert.restApiDemo.core.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdejnert.restApiDemo.core.database.entity.User;

import java.util.Optional;

public interface UserCallsRepository extends JpaRepository<User, Integer> {

    Optional<User> findByLogin(final String login);
}
