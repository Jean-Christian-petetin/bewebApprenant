package fr.fondespiere.beweb.mobile.apprenants.DAL.enumerations;

/**
 * Created by jc on 05/07/17.
 */

public enum Status {
    Chomage("chomage"), En_poste("en_poste"), Formation("en_formation");

    private String name = "";

    Status(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
