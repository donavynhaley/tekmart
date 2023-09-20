package com.tekmart.restservice.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class PaymentResponse {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof PaymentResponse that)) return false;

        return new EqualsBuilder().append(message, that.message).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(message).toHashCode();
    }

    @Override
    public String toString() {
        return "PaymentResponse{" +
                "message='" + message + '\'' +
                '}';
    }
}
