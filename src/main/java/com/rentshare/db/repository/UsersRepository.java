package com.rentshare.db.repository;

import com.rentshare.db.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Integer> {
//    List<Users> findByFirstName(String firstName);
//    List<Users> findByName(String name);

    List<Users> findByNameContaining(String name);

}
