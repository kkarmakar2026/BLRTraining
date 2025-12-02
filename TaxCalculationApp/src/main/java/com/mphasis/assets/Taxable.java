package com.mphasis.assets;

import java.io.Serializable;

public interface Taxable extends Serializable {
    double calculateTax();
}
