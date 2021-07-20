package pl.coderslab.workshop.model;


public enum ServiceCategory {
    HAIRDRESSING("Fryzjer"),
    COSMETIC("Kosmetyka");

    //TODO Zrobić jako final
    private final String displayName;

    ServiceCategory(String name){
        this.displayName=name;
    }
    public String getDisplayName(){
        return displayName;
    }

    //TODO Tego nie robić - tam gdzie potrzeba "ładnej" nazwy to używać "getDisplayName"
    @Override
    public String toString() {
        return displayName;
    }
}
