package mz.co.sbankbackend.enumerator;

import java.util.Arrays;
import java.util.List;

public enum HouseType {

	DEPENDENCY ("Dependencia"),
    APARTMENT("Apartamento"),
    TYPEONE("Tipo Um"),
    TYPETWO("Tipo Dois"),
    TYPETHREE("Tipo Tres"),
    TYPEFOUR("Tipo Quatro");

	HouseType(String description) {
        this.description = description;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public String getName(){
        return name();
    }

    private static final List<HouseType> LIST;

    static {
        List<HouseType> list = Arrays.asList(DEPENDENCY, APARTMENT, TYPEONE, TYPETWO, TYPETHREE, TYPEFOUR);
        LIST = list;
    }

    public static List<HouseType> getAll(){
        return LIST;
    }
}
