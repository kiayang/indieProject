package edu.kyang.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.YEARS;

/**
 * <p>
 * Hibernate Annotations are added to this class to map the class to the appropriate
 * table and map the instance variables to the corresponding column name on the table
 *
 * @author
 */
//Annotations @Entity and @Table will tie the User entity/class to the user table
@Entity(name = "MemberBean")
@Table(name = "member")

public class MemberBean {

    private String memberId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;
    private String gender;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    private String address;
    private String state;
    @Column(name = "zip_code")
    private String zipCode;
    private String phone;
    private String email;

    public MemberBean() {
    }

    public MemberBean(String memberId, String firstName, String lastName, String middleName, String gender, LocalDate dateOfBirth, String address, String state, String zipCode, String phone, String email) {
        this.memberId = memberId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.state = state;
        this.zipCode = zipCode;
        this.phone = phone;
        this.email = email;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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
}