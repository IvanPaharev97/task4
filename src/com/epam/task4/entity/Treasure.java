package com.epam.task4.entity;


import java.util.HashMap;
import java.util.Map;

public class Treasure {
    private int id;
    private String category;
    private double price;
    private Map<String, Property<?>> properties = new HashMap<>();
    
    public Treasure() {
        super();
    }
    
    public Treasure(int id, String category, double price, Map<String, Property<?>> properties) {
        super();
        this.id = id;
        this.category = category;
        this.price = price;
        this.properties = properties;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Map<String, Property<?>> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Property<?>> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Treasure [id=" + id + ", category=" + category + ", price=" + price + ", properties=" + properties
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        result = prime * result + id;
        long temp;
        temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((properties == null) ? 0 : properties.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Treasure other = (Treasure) obj;
        if (category == null) {
            if (other.category != null)
                return false;
        } else if (!category.equals(other.category))
            return false;
        if (id != other.id)
            return false;
        if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
            return false;
        if (properties == null) {
            if (other.properties != null)
                return false;
        } else if (!properties.equals(other.properties))
            return false;
        return true;
    }
}
