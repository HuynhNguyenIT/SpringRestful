package com.huynh.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@JsonIgnoreProperties({"field1","field2"})

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SomeBean {
    private String field1;

    private String field2;

    @JsonIgnore
    private String field3;
}
