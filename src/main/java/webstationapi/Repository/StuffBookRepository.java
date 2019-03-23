package webstationapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webstationapi.Entity.StuffBook;

public interface StuffBookRepository extends JpaRepository<StuffBook, Long> {
}
