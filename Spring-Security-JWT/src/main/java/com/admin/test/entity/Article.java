package com.admin.test.entity;

import javax.persistence.*;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String text;


    @Enumerated(EnumType.ORDINAL)
    private Color color;

    public Article() {
    }

    public Integer getId() {
        return id;
    }

    public Color getColor() {
        return color;
    }

    public String getText() {
        return text;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setText(String text) {
        this.text = text;
    }

}
