package com.rentshare.db.repository;

import com.rentshare.db.model.Advert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdvertRepository extends JpaRepository<Advert, Long> {

    List<Advert> findByTitleContaining(String title);

    Advert findAdvertById (String id);

//    <Advert> void findAdvertById (Long id);


    //    void save(Advert advert, String id);


}
