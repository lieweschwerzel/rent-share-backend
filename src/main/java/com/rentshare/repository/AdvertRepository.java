package com.rentshare.repository;

import com.rentshare.model.Advert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertRepository extends JpaRepository<Advert, Long> {

    List<Advert> findByTitleContaining(String title);
    Advert findAdvertById(Long id);
    Advert findAdvertByTitle(String title);


//    Advert findAdvertById (String id);

//    <Advert> void findAdvertById (Long id);


    //    void save(Advert advert, String id);


}
