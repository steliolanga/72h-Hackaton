package mz.co.sbankbackend.enumerator;

import java.util.Arrays;
import java.util.List;

public enum FuelType {

	DIESEL ("Diesel"),
    GASOLINE("Gasolina"),
    GAS("Gas");

	FuelType(String description) {
        this.description = description;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public String getName(){
        return name();
    }

    private static final List<FuelType> LIST;

    static {
        List<FuelType> list = Arrays.asList(DIESEL, GASOLINE, GAS);
        LIST = list;
    }

    public static List<FuelType> getAll(){
        return LIST;
    }
}
