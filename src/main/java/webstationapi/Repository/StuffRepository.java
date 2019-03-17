package webstationapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webstationapi.Entity.Stuff;

public interface StuffRepository extends JpaRepository<Stuff, Long> {
}
