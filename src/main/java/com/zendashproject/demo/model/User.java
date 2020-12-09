package com.zendashproject.demo.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

import java.util.*;

@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;


    //@Email (message = "{register.email.message}")
    //@NotEmpty (message = "{register.email.message}")
    @Column(name = "email", unique = true)
    private String email;

    //@Size(min = 6, max = 30, message = "{register.password.message}")
    @NotNull
    @Column(name = "password", unique = true)
    private String password;

    @Transient
    private String repeatPassword;

    @Column(name = "address")
    private String address;

    @Column(name = "postalcode")
    private String postalcode;

    @Column(name = "city")
    private String city;

    @Column(name = "phone")
    private String phone;

    @Column(name = "dateofbirth")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
    private Date dateofbirth = new Date();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;

    private boolean enabled;

    public User() {
    }

    public User(String firstname, String lastname, String email, String password, Set<Role> roles, boolean enabled) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.enabled = enabled;
    }

    public User(String firstname, String lastname, String email, String password, String repeatPassword, String phone, Set<Role> roles) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.phone = phone;
        this.roles = roles;
    }

    public User(String firstname, String lastname, String email, String address, String postalcode, String city, String phone, Date dateofbirth) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.postalcode = postalcode;
        this.city = city;
        this.phone = phone;
        this.dateofbirth = dateofbirth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!getId().equals(user.getId())) return false;
        if (!getFirstname().equals(user.getFirstname())) return false;
        if (getLastname() != null ? !getLastname().equals(user.getLastname()) : user.getLastname() != null)
            return false;
        if (!getEmail().equals(user.getEmail())) return false;
        if (!getPassword().equals(user.getPassword())) return false;
        if (getRepeatPassword() != null ? !getRepeatPassword().equals(user.getRepeatPassword()) : user.getRepeatPassword() != null)
            return false;
        if (getAddress() != null ? !getAddress().equals(user.getAddress()) : user.getAddress() != null)
            return false;
        if (getPostalcode() != null ? !getPostalcode().equals(user.getPostalcode()) : user.getPostalcode() != null)
            return false;
        if (getCity() != null ? !getCity().equals(user.getCity()) : user.getCity() != null) return false;
        if (getPhone() != null ? !getPhone().equals(user.getPhone()) : user.getPhone() != null) return false;
        return getDateofbirth() != null ? getDateofbirth().equals(user.getDateofbirth()) : user.getDateofbirth() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getFirstname().hashCode();
        result = 31 * result + (getLastname() != null ? getLastname().hashCode() : 0);
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + (getRepeatPassword() != null ? getRepeatPassword().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getPostalcode() != null ? getPostalcode().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        result = 31 * result + (getDateofbirth() != null ? getDateofbirth().hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", repeatPassword='" + repeatPassword + '\'' +
                ", address='" + address + '\'' +
                ", postalcode='" + postalcode + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", dateofbirth=" + dateofbirth +
                ", roles=" + roles +
                ", enabled=" + enabled +
                '}';
    }
}
