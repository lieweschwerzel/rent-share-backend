package com.rentshare.db.repository;

import com.rentshare.db.model.Advert;
import com.rentshare.db.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertRepository extends JpaRepository<Advert, Integer> {

    List<Advert> findByTitleContaining(String title);

}
