package hello.repos;

import hello.domain.Usr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsrRepo extends JpaRepository<Usr, Long> {
    Usr findByUsername(String username);
}
