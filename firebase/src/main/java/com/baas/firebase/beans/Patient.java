package com.baas.firebase.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    private String name;
    private String age;
    private String city;

}
