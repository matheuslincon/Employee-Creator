package com.matheuslincon.employercreatorspring.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.hateoas.RepresentationModel;

import java.util.Objects;

public class EmployeeUpdateDTO extends RepresentationModel<EmployeeUpdateDTO> {
    @NotBlank
    private String firstName;


    private String middleName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String mobile;

    @NotBlank
    private String address;

    @NotBlank
    private String contractType;

    @NotBlank
    private String startDate;

    @NotBlank
    private String finishDate;

    @NotBlank
    private String hoursType;

    @NotNull
    private Integer hoursPerWeek;

    public EmployeeUpdateDTO() {}

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
        if (!(o instanceof EmployeeUpdateDTO that)) return false;
        return Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getMiddleName(), that.getMiddleName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getMobile(), that.getMobile()) && Objects.equals(getAddress(), that.getAddress()) && Objects.equals(getContractType(), that.getContractType()) && Objects.equals(getStartDate(), that.getStartDate()) && Objects.equals(getFinishDate(), that.getFinishDate()) && Objects.equals(getHoursType(), that.getHoursType()) && Objects.equals(getHoursPerWeek(), that.getHoursPerWeek());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getMiddleName(), getLastName(), getMobile(), getAddress(), getContractType(), getStartDate(), getFinishDate(), getHoursType(), getHoursPerWeek());
    }
}
