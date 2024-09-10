package com.example.Creation.Of.Patients;


import jakarta.persistence.*;

@Entity
@Table(name = "PatientsTable")
public class Patient {

    @Id
    @GeneratedValue
    private int patId;

    @Column(name = "First_Name")
    private String first_name;

    @Column(name = "Last_Name")
    private String last_name;

    @Column(name = "Email")
    private String email;


    @Column(name = "Status_Health")
    @Enumerated(EnumType.STRING)
    private HealthStatus healthStatus;



    public Patient() {
    }

    //Parameterized Constructor
    public Patient(String first_name, String last_name, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    //Getter Setter Methods
    public int getPatId() {
        return patId;
    }

    public void setPatId(int patId) {
        this.patId = patId;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public HealthStatus getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(HealthStatus healthStatus) {
        this.healthStatus = healthStatus;
    }
}
