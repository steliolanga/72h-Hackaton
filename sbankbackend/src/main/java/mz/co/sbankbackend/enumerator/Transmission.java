package mz.co.sbankbackend.enumerator;

import java.util.Arrays;
import java.util.List;

public enum Transmission {

	MANUAL ("Manual"),
    SEMIAUTOMATIC("Semi-Automatico"),
    AUTOMATIC("Automatico");

	Transmission(String description) {
        this.description = description;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public String getName(){
        return name();
    }

    private static final List<Transmission> LIST;

    static {
        List<Transmission> list = Arrays.asList(MANUAL, SEMIAUTOMATIC, AUTOMATIC);
        LIST = list;
    }

    public static List<Transmission> getAll(){
        return LIST;
    }
}
