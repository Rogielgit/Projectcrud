package com.journaldev.spring.dao;

import javax.xml.bind.annotation.XmlElement;


//@XmlRootElement(name = "person") // if your change to program to return too xml
public class ConvertJson {

    private int id;
    private String name;
    private String country;


    public ConvertJson(){

    }
    public ConvertJson(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    @XmlElement
    public int getId() {
        return id;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    @XmlElement
    public String getCountry() {
        return country;
    }

}


