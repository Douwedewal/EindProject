package finalProject.musicProject.repository;

import finalProject.musicProject.domain.ERole;
import finalProject.musicProject.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);

}
