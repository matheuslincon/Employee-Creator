package com.matheuslincon.employercreatorspring.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private String email;

    @Column
    private String mobile;

    @Column
    private String address;

    @Column(name = "contract_type")
    private String contractType;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "finish_date")
    private String finishDate;

    @Column(name = "hours_type")
    private String hoursType;

    @Column(name = "hours_per_week")
    private Integer hoursPerWeek;

    public Employee() {}

    public Employee(String firstName,
                    String lastName,
                    String email,
                    String mobile,
                    String address,
                    String contractType,
                    String startDate,
                    String hoursType,
                    Integer hoursPerWeek,
                    String middleName,
                    String finishDate
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.contractType = contractType;
        this.startDate = startDate;
        this.hoursType = hoursType;
        this.hoursPerWeek = hoursPerWeek;
        this.middleName = middleName;
        this.finishDate = finishDate;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getHoursType() {
        return hoursType;
    }

    public void setHoursType(String hoursType) {
        this.hoursType = hoursType;
    }

    public Integer getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(Integer hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(getId(), employee.getId()) && Objects.equals(getFirstName(), employee.getFirstName()) && Objects.equals(getMiddleName(), employee.getMiddleName()) && Objects.equals(getLastName(), employee.getLastName()) && Objects.equals(getEmail(), employee.getEmail()) && Objects.equals(getMobile(), employee.getMobile()) && Objects.equals(getAddress(), employee.getAddress()) && Objects.equals(getContractType(), employee.getContractType()) && Objects.equals(getStartDate(), employee.getStartDate()) && Objects.equals(getFinishDate(), employee.getFinishDate()) && Objects.equals(getHoursType(), employee.getHoursType()) && Objects.equals(getHoursPerWeek(), employee.getHoursPerWeek());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getMiddleName(), getLastName(), getEmail(), getMobile(), getAddress(), getContractType(), getStartDate(), getFinishDate(), getHoursType(), getHoursPerWeek());
    }
}
