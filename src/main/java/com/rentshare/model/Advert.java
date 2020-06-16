package com.rentshare.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Advert {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Long price;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "FK_userId")
    private Long userId;

    @Column(name = "FK_advertOwner")
    private String advertOwner;

    @Column(name = "createdOn")
    private LocalDateTime createdOn;

    @Column(name = "duration")
    private int duration;

    public Advert() {
    }

    public String getAdvertOwner() {
        return advertOwner;
    }

    public void setAdvertOwner(String advertOwner) {
        this.advertOwner = advertOwner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getLatitude() { return latitude; }

    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }

    public void setLongitude(double longitude) { this.longitude = longitude; }

    public Long getUserId() { return userId; }

    public void setUserId(Long userId) { this.userId = userId; }

    public LocalDateTime getCreatedOn() { return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) { this.createdOn = createdOn;
    }

    public int getDuration() { return duration;
    }

    public void setDuration(int duration) { this.duration = duration;
    }

    @Override
    public String toString() {
        return "Advert{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
