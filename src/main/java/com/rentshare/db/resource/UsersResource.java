package com.rentshare.db.resource;

import com.rentshare.db.model.Users;
import com.rentshare.db.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/users")
public class UsersResource {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping(value = "/all")
    public List<Users> getAll() {
        return usersRepository.findAll();
    }

    @GetMapping(value = "/all/{id}")
    public Users getUser(@PathVariable("id") int id) {
        return usersRepository.findOne(id);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/load")
    public void persist (@RequestBody Users user) {
        usersRepository.save(user);
    }

//    @PostMapping(value = "/load")
//    @ResponseStatus(value = HttpStatus.OK)
//    public List<Users> persist(@RequestBody final Users users) {
//        usersRepository.save(users);
//        if users
////        return null;
//        return usersRepository.findAll();
//    }

    @GetMapping(value = "/delete")
    public List<Users> deleteAll() {
        usersRepository.deleteAll();
        return usersRepository.findAll();
    }

    @GetMapping(value = "/delete/{id}")
    public List<Users> deleteId(@PathVariable("id") int id) {
        usersRepository.delete(id);
        return usersRepository.findAll();
    }
}
