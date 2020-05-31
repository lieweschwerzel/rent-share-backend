package com.rentshare.service;

import com.rentshare.model.DAOUser;
import com.rentshare.repository.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;

import com.google.common.truth.Truth;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JwtUserDetailsServiceTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserDao userDao;

    //Find specific user
    @Test
    public void whenFindByName_thenReturnUser() {
        // given
        DAOUser user = new DAOUser();
        user.setUsername("alex");
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


    }


    //Delete All users, confirm by reading all users. List should be empty
    @Test
    public void whenDeleteAll_thenCheckForUsers() {
        // given
        DAOUser user = new DAOUser();
        user.setUsername("alex");
        user.setUsername("alexa");
        user.setUsername("zac");
        entityManager.persist(user);
        entityManager.flush();

        // when
        userDao.deleteAll();
        List<DAOUser> daoUsers = userDao.findAll();

        // then
        // then
        Truth.assertThat(daoUsers)
                .isEmpty();
    }

}