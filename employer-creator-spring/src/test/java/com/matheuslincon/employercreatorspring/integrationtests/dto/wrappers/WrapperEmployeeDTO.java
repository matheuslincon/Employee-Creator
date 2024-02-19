package com.matheuslincon.employercreatorspring.integrationtests.dto.wrappers;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class WrapperEmployeeDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("_embedded")
    private EmployeeEmbeddedDTO embedded;

    public WrapperEmployeeDTO() {}

    public EmployeeEmbeddedDTO getEmbedded() {
        return embedded;
    }

    public void setEmbedded(EmployeeEmbeddedDTO embedded) {
        this.embedded = embedded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WrapperEmployeeDTO that)) return false;
        return Objects.equals(getEmbedded(), that.getEmbedded());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmbedded());
    }
}
