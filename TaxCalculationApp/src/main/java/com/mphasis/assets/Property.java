package com.mphasis.assets;

public class Property extends Asset {
    private final String id;
    private final double builtUpArea;
    private final double baseValue;
    private final boolean inMainCity;
    private final int age;
    private final double ageFactor;

    public Property(String id, double builtUpArea, double baseValue, char cityChar, int age, double ageFactor) {
        this.id = id;
        this.builtUpArea = builtUpArea;
        this.baseValue = baseValue;
        this.inMainCity = (cityChar == 'Y' || cityChar == 'y');
        this.age = age;
        this.ageFactor = ageFactor;
    }

    public String getId() { return id; }
    public double getBuiltUpArea() { return builtUpArea; }
    public double getBaseValue() { return baseValue; }
    public boolean isInMainCity() { return inMainCity; }
    public int getAge() { return age; }

    @Override
    public double calculateTax() {
        double tax;
        if (inMainCity) {
            tax = (builtUpArea * ageFactor * baseValue) + (0.5 * builtUpArea);
        } else {
            tax = builtUpArea * ageFactor * baseValue;
        }
        return tax;
    }
}
