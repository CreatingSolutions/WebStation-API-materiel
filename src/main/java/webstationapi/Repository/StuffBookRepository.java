package webstationapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webstationapi.Entity.StuffBook;

import java.util.List;

public interface StuffBookRepository extends JpaRepository<StuffBook, Long> {

    List<StuffBook> findByUserId(int userId);

}
