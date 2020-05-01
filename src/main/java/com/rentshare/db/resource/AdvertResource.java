package com.rentshare.db.resource;

import com.rentshare.db.model.Advert;
import com.rentshare.db.repository.AdvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
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

//    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<?> updateAdvert(@PathVariable("id") long id, @RequestBody Advert advert) {
//        System.out.println("Updating User with id {}"+ id);
//
//        int index = advert.in.indexOf(user);
//
//    }
//
    @PutMapping("/update/{id}")
    public ResponseEntity<?> saveResource(@RequestBody Advert newAdvert,
                                          @PathVariable("id") Long id) {
        Advert advert = advertRepository.findOne(id);

        if (advert !=null){
            System.out.println(advert.toString());
            advert = new Advert();
            advert.setId(id);
            advert.setTitle(newAdvert.getTitle());

            advertRepository.save(advert);
        }


        return ResponseEntity.ok("resource saved");
    }

//    @RequestMapping(method = RequestMethod.PUT, value = "topicId/{topicId}")
//    public ResponseEntity<?> updateTopic(@RequestBody Advert advert, @PathVariable long id) {
//        Advert newAdvert = advertRepository.findOne(id);
//        if (newAdvert != null) {
//            newAdvert.setTitle(advert.getTitle());
//            newAdvert.setDescription(advert.getDescription());
//            if (advertRepository.save(newAdvert).getId().equals(id)) {
//                return Util.createResponseEntity("Data updated successfully", HttpStatus.OK);
//            }
//        }
//        return Util.createResponseEntity("Error updating data", HttpStatus.NOT_FOUND);
//    }

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
