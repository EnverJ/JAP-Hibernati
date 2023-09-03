package io.ezbrains;

import com.sun.jdi.PrimitiveValue;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Table(name = "EMPLOYEE_DATA") // (table name is optional, by default it is class name)
public class Employee {

<<<<<<< HEAD
    @Id   // primary key
    @GeneratedValue(strategy = GenerationType.AUTO)    // GenerationType.SEQUENCE)
    private int id;
    //1) there are performance implications if  a string is used as a key
    //2) also wrapper types, char, byte , short, long  can be used as key
    //3) dont use long format for the id since the precision value needs to be descrete.
    //4) there are 4 different strategies which can be used for generation of the ID.
    @Column(name = "employee_name", unique = false)  // unique mean if the value is duplicated
    private String name;
    private int age;
    @Column(unique = true, length = 10, nullable = false, updatable = false)
    private String ssn;
    @Temporal(TemporalType.TIME)
    private Date dob;
    @Enumerated(EnumType.STRING)
    private EmployeeType type;
    @Transient// is not going to be saved
    private String debugString;
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Column(insertable = false)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

=======
   @Id   // primary key
    private  int id;
    private  String name;
>>>>>>> ecaa26f843c82fc7fcbc836336cb4ae0b5855860

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeType getType() {
        return type;
    }


    public void setType(EmployeeType type) {
        this.type = type;
    }
}
