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

    @RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
    public DAOUser findDaoUserById(@PathVariable("id") Long id) throws Exception {
        return userDao.findDAOUserById(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @Transactional
    public void deleteDaoUserById(@PathVariable("id") Long id) throws Exception {
        userDao.deleteDAOUserById(id);
    }

}
