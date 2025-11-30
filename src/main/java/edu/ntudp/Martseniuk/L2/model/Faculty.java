package edu.ntudp.Martseniuk.L2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Faculty extends OrganizationalUnit {
    private List<Department> departments;

    public Faculty(String name, Human head) {
        super(name, head);
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(departments, faculty.departments);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(departments);
    }

    public List<Department> getDepartments() { return departments; }
    public void setDepartments(List<Department> departments) {
        this.departments = new ArrayList<>(departments);
    }

    @Override
    public String getUnitType() {
        return "Факультет";
    }
}

