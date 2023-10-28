package lk.ijse.gdse63.aad.user_authorized_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserDetails,String> {
    Optional<UserDetails> findByUserName (String username);


}
