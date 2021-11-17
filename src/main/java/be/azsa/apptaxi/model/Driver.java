package be.azsa.apptaxi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDriver;
    @Column(name = "firstname", nullable = false)
    private String firstname;
    @Column(name = "lastname", nullable = false)
    private String lastname;
    @Column(name = "driver_number", nullable = false, unique = true)
    private int driverNum;
    @Column(name = "password", nullable = false)
    private int password;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "phone", nullable = false, unique = true)
    private String phone;
}
