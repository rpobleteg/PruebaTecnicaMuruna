
package com.example.prueba.tecnica.dto;

import jakarta.persistence.Embeddable;

@Embeddable
public class Phone {
    private String number;
    private String citycode;
    private String countrycode;

}