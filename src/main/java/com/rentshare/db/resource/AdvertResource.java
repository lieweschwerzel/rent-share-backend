package com.rentshare.db.resource;

import com.rentshare.db.model.Advert;
import com.rentshare.db.model.Users;
import com.rentshare.db.repository.AdvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/advert")
public class AdvertResource {
    @Autowired
    AdvertRepository advertRepository;

    @GetMapping(value = "/all")
    public List<Advert> getAll() {
        return advertRepository.findAll();
    }

    @PostMapping(value = "/save")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Advert> persist(@RequestBody final Advert advert) {
        advertRepository.save(advert);
        return advertRepository.findAll();
    }

    @GetMapping(value = "/delete")
    public List<Advert> deleteAll() {
        advertRepository.deleteAll();
        return advertRepository.findAll();
    }

    @GetMapping(value = "/search/{title}")
    public List<Advert> search(@PathVariable("title") String title) {
        return advertRepository.findByTitleContaining(title);
    }

}
