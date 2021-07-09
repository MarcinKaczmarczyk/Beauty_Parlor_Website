package pl.coderslab.workshop.model;


public enum ServiceCategory {
    HAIRDRESSING("Fryzjer"),
    COSMETIC("Kosmetyka");

    private String displayName;

    ServiceCategory(String name){
        this.displayName=name;
    }
    public String getDisplayName(){
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
