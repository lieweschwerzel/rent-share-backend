package com.rentshare.db.resource;

import com.rentshare.db.model.Users;
import com.rentshare.db.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

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
    public void persist(@RequestBody Users user) {
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


//    @GetMapping
//    public Page<Users> findCustomersByFirstName(
//            @RequestParam("name") String name,
//            Pageable pageable) {
//
//        if (name == null) {
//            return usersRepository.findAll(pageable);
//        } else {
//            return usersRepository.findByName(name, pageable);
//        }
//    }

    @GetMapping(value = "/check/{name}")
    public List<Users> check(@PathVariable("name") String name) {
        System.out.println(name);

//        List<Users> users = ;

        return usersRepository.findByName(name);

    }
}
