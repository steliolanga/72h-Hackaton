package mz.co.sbankbackend.enumerator;

import java.util.Arrays;
import java.util.List;

public enum MaximumLoadCapacity {

	TWO ("Dois"),
    THREE("Tres"),
    FOUR("Quatro"),
    FIVE("Cinco"),
    SIXTEEN("Desaseis"),
    THIRTYTWO("Trinta e Dois"),
    FIFTY("Cinquenta");

	MaximumLoadCapacity(String description) {
        this.description = description;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public String getName(){
        return name();
    }

    private static final List<MaximumLoadCapacity> LIST;

    static {
        List<MaximumLoadCapacity> list = Arrays.asList(TWO, THREE, FOUR, FIVE, SIXTEEN,THIRTYTWO, FIFTY);
        LIST = list;
    }

    public static List<MaximumLoadCapacity> getAll(){
        return LIST;
    }
}
