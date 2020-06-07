package com.rentshare.controller;

import com.rentshare.model.Advert;
import com.rentshare.repository.AdvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(value = "/advert")
public class AdvertResource {

    @Autowired
    AdvertRepository advertRepository;

    @GetMapping(value = "/all")
    public List<Advert> getAll() {
        return advertRepository.findAll();
    }

    @RequestMapping(value="/save",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<?> persistResource(@RequestBody final Advert advert) {
        advertRepository.save(advert);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(advert, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateResource(@RequestBody Advert updatedAdvert,
                                            @PathVariable("id") Long id) {
        Advert existingAdvert = advertRepository.findAdvertById(id);

        if (existingAdvert != null) {
            Advert advert = new Advert();
            advert.setId(id);
            advert.setTitle(updatedAdvert.getTitle());
            advert.setDescription(updatedAdvert.getDescription());

            advertRepository.save(advert);
            return ResponseEntity.ok("resource updated");
        }

        return ResponseEntity.ok("resource NOT updated, ID doesnt exist");

    }

    @GetMapping(value = "/admin/delete")
    public ResponseEntity<?> deleteAll() {
        advertRepository.deleteAll();
        return ResponseEntity.ok("all ads deleted");
    }

    @GetMapping(value = "/search/title/{title}")
    public List<Advert> search(@PathVariable("title") String title) {
        return advertRepository.findByTitleContaining(title);
    }

    @GetMapping(value = "/search/id/{id}")
    public Advert findById(@PathVariable("id") Long id) {
        return advertRepository.findAdvertById(id);
    }

    @GetMapping(value = "/search/userId/{userId}")
    public List<Advert> findByUserId(@PathVariable("userId") Long userId) {
        return advertRepository.findByUserId(userId);
    }

    @RequestMapping(value = "/delete/userId/{userId}", method = RequestMethod.DELETE)
    @Transactional
    public void deleteAdvertByUserId(@PathVariable("userId") Long userId) {
        advertRepository.deleteAdvertByUserId(userId);
    }

}
