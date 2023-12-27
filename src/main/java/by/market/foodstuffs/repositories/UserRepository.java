package by.market.foodstuffs.repositories;

import by.market.foodstuffs.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserNameOrEmail(String userName, String email);
    Boolean existsByUserName(String userName);
    Boolean existsByEmail(String email);
}
