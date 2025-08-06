package com.example.Beanfiles;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.example")
public class PropertyBean {

    private Integer integerValue;
    private Double decimalValue;
    private Boolean booleanValue;

    // Getters and setters
    public Integer getIntegerValue() {
        return integerValue;
    }

    public void setIntegerValue(Integer integerValue) {
        this.integerValue = integerValue;
    }

    public Double getDecimalValue() {
        return decimalValue;
    }

    public void setDecimalValue(Double decimalValue) {
        this.decimalValue = decimalValue;
    }

    public Boolean getBooleanValue() {
        return booleanValue;
    }

    public void setBooleanValue(Boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    @Override
    public String toString() {
        return "PropertiesBean [integerValue=" + integerValue + ", decimalValue=" + decimalValue
                + ", booleanValue=" + booleanValue + "]";
    }
}

