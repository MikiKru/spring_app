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

    @Query(
            value = "select p.role_name, count(*) from user u join user_permission up on (u.user_id = up.user_id) join permission p on (p.permission_id = up.permission_id) group by p.role_name ORDER BY 2",
            nativeQuery = true
    )
    List<Object[]> aggregatePermissionsByRoleName();

}
