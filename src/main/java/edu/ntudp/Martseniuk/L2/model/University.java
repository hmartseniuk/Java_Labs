package edu.ntudp.Martseniuk.L2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class University extends OrganizationalUnit {
    private List<Faculty> faculties;

    public University(String name, Human head) {
        super(name, head);
        this.faculties = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        University that = (University) o;
        return Objects.equals(faculties, that.faculties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), faculties);
    }

    public List<Faculty> getFaculties() { return faculties; }
    public void setFaculties(List<Faculty> faculties) {
        this.faculties = new ArrayList<>(faculties);
    }

    @Override
    public String getUnitType() {
        return "Університет";
    }
}

