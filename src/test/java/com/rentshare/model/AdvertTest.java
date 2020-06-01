package com.rentshare.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class AdvertTest {

    private final Advert testAdvert = new Advert();

    @Test
    public void getPrice() {
        testAdvert.setPrice(10);
        assertEquals(10, (long)testAdvert.getPrice());
    }
}