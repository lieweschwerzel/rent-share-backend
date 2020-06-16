package com.rentshare.controller;

import com.rentshare.model.Advert;
import com.rentshare.model.DAOUser;
import com.rentshare.repository.AdvertRepository;
import com.rentshare.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @Autowired
    UserDao userDao;

    @GetMapping(value = "/all")
    public List<DAOUser> getAll() {
        return userDao.findAll();
    }

    @RequestMapping(value = "/save",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<?> persistResource(@RequestBody final DAOUser daoUser) {
        userDao.save(daoUser);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(daoUser, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
    public DAOUser findDaoUserById(@PathVariable("id") Long id) {
        return userDao.findDAOUserById(id);
    }

    @RequestMapping(value = "/searchByUser/{username}", method = RequestMethod.GET)
    public Long findDaoUserById(@PathVariable("username") String username) {
        Long id = userDao.findByUsername(username).getId();
        return id;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @Transactional
    public void deleteDaoUserById(@PathVariable("id") Long id) {
        userDao.deleteDAOUserById(id);
    }

    @GetMapping(value = "/admin/delete")
    public ResponseEntity<?> deleteAll() {
        userDao.deleteAll();
        return ResponseEntity.ok("all users deleted");
    }

}

