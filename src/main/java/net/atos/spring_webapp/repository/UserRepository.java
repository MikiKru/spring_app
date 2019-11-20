package net.atos.spring_webapp.repository;

import net.atos.spring_webapp.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(
            value = "select permission_id, count(*) from user_permission group by permission_id",
            nativeQuery = true)
    List<Object[]> aggregatePermissions();

}
