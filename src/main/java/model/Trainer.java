package model;

import java.time.LocalDate;

public class Trainer extends Person {
    private boolean isAutorised;

    public Trainer(String firstName, String lastName, LocalDate dateOfBirth, boolean isAutorised) {
        super(firstName, lastName, dateOfBirth);
        this.isAutorised = isAutorised;
    }

    public Trainer() {

    }

    public boolean isAutorised() {
        return isAutorised;
    }

    public void setAutorised(boolean autorised) {
        isAutorised = autorised;
    }

    @Override
    public String toString() {
        return "Trainer{" + super.toString()+
                "isAutorised=" + isAutorised +
                '}';
    }
}
