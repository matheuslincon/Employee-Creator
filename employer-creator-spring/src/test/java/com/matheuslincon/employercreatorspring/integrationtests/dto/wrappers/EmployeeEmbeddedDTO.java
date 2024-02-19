package com.matheuslincon.employercreatorspring.integrationtests.dto.wrappers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.matheuslincon.employercreatorspring.integrationtests.dto.EmployeeDTO;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class EmployeeEmbeddedDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("employeeDTOList")
    private List<EmployeeDTO> employees;

    public EmployeeEmbeddedDTO() {}

    public List<EmployeeDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDTO> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeEmbeddedDTO that)) return false;
        return Objects.equals(getEmployees(), that.getEmployees());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployees());
    }
}
