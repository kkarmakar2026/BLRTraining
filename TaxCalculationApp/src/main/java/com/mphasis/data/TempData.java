package com.mphasis.data;

import com.mphasis.assets.Property;
import com.mphasis.assets.Vehicle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TempData implements Serializable {
    private static final long serialVersionUID = 1L;

    public List<Property> properties;
    public List<Vehicle> vehicles;

    public TempData(List<Property> properties, List<Vehicle> vehicles) {
        this.properties = new ArrayList<>(properties);
        this.vehicles = new ArrayList<>(vehicles);
    }
}
