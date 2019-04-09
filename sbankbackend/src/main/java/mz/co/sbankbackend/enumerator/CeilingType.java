package mz.co.sbankbackend.enumerator;

import java.util.Arrays;
import java.util.List;

public enum CeilingType {

	ZINCSHEET ("Zinco"),
    FALSECEILING("Teto Falso"),
    PLATECEILING("Placa");

	CeilingType(String description) {
        this.description = description;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public String getName(){
        return name();
    }

    private static final List<CeilingType> LIST;

    static {
        List<CeilingType> list = Arrays.asList(ZINCSHEET, FALSECEILING, PLATECEILING);
        LIST = list;
    }

    public static List<CeilingType> getAll(){
        return LIST;
    }
}
