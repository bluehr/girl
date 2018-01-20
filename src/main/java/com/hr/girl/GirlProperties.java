package com.hr.girl;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {
    private String cup;
    private Integer age;
    public String getCup(){
        return cup;
    }

    public Integer getAge() {
        return age;
    }

    public void setCup(String cup) {
        this.cup = cup;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
