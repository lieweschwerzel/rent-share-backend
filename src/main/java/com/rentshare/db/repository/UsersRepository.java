package com.rentshare.db.repository;

import com.rentshare.db.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
//    List<Users> findByFirstName(String firstName);
//    List<Users> findByName(String name);

    List<Users> findByName(String name);
}
