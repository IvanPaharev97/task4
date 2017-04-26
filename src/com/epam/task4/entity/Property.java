package com.epam.task4.entity;

public class Property<T> {
    private T property;
    
    public Property(T property) {
        super();
        this.property = property;
    }

    public T getPropertyValue() {
        return property;
    }

    @Override
    public String toString() {
        return "Property [property=" + property + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((property == null) ? 0 : property.hashCode());
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
        Property<?> other = (Property<?>) obj;
        if (property == null) {
            if (other.property != null)
                return false;
        } else if (!property.equals(other.property))
            return false;
        return true;
    }
}
