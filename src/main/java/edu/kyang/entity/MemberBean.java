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
    //@Column annotation will specify the instance variable to the corresponding column on table
    //*Note that if the instance variable and table column name is same, you will not need @Column
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_name")
    private String userName;

    /*
     * Every Entity must have a unique identifier which is annotated @Id
     * *Notice that there is NO @Column here as the column and instance variable
     *  name are the same for 'id' variable
     */

    //This is the primary key
    @Id
    //If the Primary key is auto generated, you will need these 2 annotations
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")

    private int id;

    //Hibernate automatically converts teh date of birth to LocalDate
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    /**
     * No argument constructor, Instantiates a new User.
     */
    public MemberBean() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName   the first name
     * @param lastName    the last name
     * @param userName    the user name
     * @param dateOfBirth the date of birth
     */
    public MemberBean(String firstName, String lastName, String userName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets date of birth.
     *
     * @return the date of birth
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets date of birth.
     *
     * @param dateOfBirth the date of birth
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + "\'" +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

}