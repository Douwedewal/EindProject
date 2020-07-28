package finalProject.musicProject.repository;

import finalProject.musicProject.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Boolean existsById(long id);
}
