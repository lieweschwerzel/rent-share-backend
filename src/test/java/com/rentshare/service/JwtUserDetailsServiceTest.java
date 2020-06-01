package com.rentshare.service;

import com.rentshare.model.DAOUser;
import com.rentshare.repository.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;

import com.google.common.truth.Truth;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JwtUserDetailsServiceTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserDao userDao;


    //Find specific user by username
    @Test
    public void whenFindByName_thenReturnUser() {
        // given
        DAOUser user = new DAOUser();
        user.setUsername("alex@gmail.com");
        entityManager.persist(user);
        entityManager.flush();
        // when
        DAOUser found = userDao.findByUsername(user.getUsername());
        // then
        // then
        Truth.assertThat(found.getUsername())
                .isEqualTo(user.getUsername());
    }

    //Receive all users, confirm by comparing list size
    @Test
    public void whenFindAll_thenReturnAll() {
        // given
        DAOUser user1 = new DAOUser();
        user1.setUsername("alex");
        DAOUser user2 = new DAOUser();
        user2.setUsername("alexa");
        DAOUser user3 = new DAOUser();
        user3.setUsername("zac");


        entityManager.persist(user1);
        entityManager.persist(user2);
        entityManager.persist(user3);
        entityManager.flush();

        // when
        List<DAOUser> returnedDaoUserList = (List<DAOUser>) userDao.findAll();

        // then
        // then
        Truth.assertThat(returnedDaoUserList.size())
                .isEqualTo(3);

    }


    //Delete All users, confirm by reading all users. List should be empty
    @Test
    public void save() {
        // given
        DAOUser user = new DAOUser();
        user.setUsername("alex");
        user.setUsername("alexa");
        user.setUsername("zac");
        user.setUsername("zorro");
        entityManager.persist(user);
        entityManager.flush();

        // when
        userDao.deleteAll();
        List<DAOUser> daoUsers = (List<DAOUser>) userDao.findAll();

        // then
        // then
        Truth.assertThat(daoUsers)
                .isEmpty();
    }

    //Save user, confirm by test user with user returned from api.
    @Test
    public void whenSaveUser_thenReturnUser() {
        // given
        DAOUser user = new DAOUser();
        user.setUsername("alex@gmail.com");
        user.setPassword("password");

        entityManager.persist(user);
        entityManager.flush();

        // when
        DAOUser savedUser = userDao.save(user);

        // then
        // then
        Truth.assertThat(user.getUsername()+user.getPassword())
                .isEqualTo(savedUser.getUsername()+savedUser.getPassword());
    }

}