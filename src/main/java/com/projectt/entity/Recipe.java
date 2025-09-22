package com.projectt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="recipes")
public class Recipe {
    @Id
    int rid;
    @Lob
    @Column(name="name",columnDefinition = "TEXT")
    String name;
    
    @Lob
    @Column(name="image",columnDefinition = "TEXT")
    String image;

    @Column(name="time")
    String time; // You can adjust the type if needed
    
    @Lob
    @Column(name="cuisine",columnDefinition = "TEXT")
    String cuisine;
    
    @Lob
    @Column(name="meal_type",columnDefinition = "TEXT")
    String mealType;

    @Lob
    @Column(name = "ingredients", columnDefinition = "TEXT")
    private String ingredients;

    @Lob
    @Column(name = "process", columnDefinition = "TEXT")
    private String process;

    // Getters and Setters
    public int getrid() {
        return rid;
    }

    public void setId(int id) {
        this.rid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    @Override
    public String toString() {
        return "Recipe [id=" + rid + ", name=" + name + ", image=" + image + ", time=" + time + ", cuisine=" + cuisine + ", mealType=" + mealType + ", ingredients=" + ingredients + ", process=" + process + "]";
    }
}