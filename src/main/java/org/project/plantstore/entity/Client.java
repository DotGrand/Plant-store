package org.project.plantstore.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Please provide a valid first name")
    @Pattern(regexp = "[\\-a-zA-Z\\s.']+", message = "Please provide a valid first name")
    @Size(min = 2, max = 20, message = "Must not be shorter than 2 and longer than 20 characters")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "Please provide a valid last name")
    @Pattern(regexp = "[\\-a-zA-Z\\s.']+", message = "Please provide a valid last name")
    @Size(min = 2, max = 20, message = "Must not be shorter than 2 and longer than 20 characters")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "Please provide a valid phone number")
    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}",
            message = "Please provide a valid phone number format. Must be like 000-000-0000")
    @Column(name = "phone")
    private String phone;

    @NotNull(message = "Please provide a valid email")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Please provide a valid email format")
    @Column(name = "email")
    private String email;

    @Column(name = "city")
    private String city;

    @Column(name = "gender")
    private String gender;

    @NotNull(message = "Please provide a valid registration date")
    @Pattern(regexp = "([0-9]{4})-([0-9]{2})-([0-9]{2})", message = "Wrong data format. Must be yyyy-mm-dd")
    @Column(name = "registration_date")
    private String registrationDate;

    @OneToMany(mappedBy = "client", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<OrderInfo> orderInfo;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "plant_client",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "plant_id")
    )
    private List<Plant> plants = new ArrayList<>();

    public Client() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public List<OrderInfo> getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(List<OrderInfo> orderInfo) {
        this.orderInfo = orderInfo;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }

    public void addPlant(Plant plant) {
        this.plants.add(plant);
    }

    public void removePlant(Plant plant) {
        this.plants.remove(plant);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", gender='" + gender + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                ", orderInfo=" + orderInfo +
                ", plants=" + plants +
                '}';
    }
}
