package mz.co.sbankbackend.enumerator;

import java.util.Arrays;
import java.util.List;

public enum Driver {

	TWOBYFOUR("2X4"),
	FOURBYFOUR ("4X4"),
    TWOBYSIX("2X6"),
    FOURBYSIX("4X6");

	Driver(String description) {
        this.description = description;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public String getName(){
        return name();
    }

    private static final List<Driver> LIST;

    static {
        List<Driver> list = Arrays.asList(TWOBYFOUR, FOURBYFOUR, TWOBYSIX, FOURBYSIX);
        LIST = list;
    }

    public static List<Driver> getAll(){
        return LIST;
    }
}
