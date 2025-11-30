package edu.ntudp.Martseniuk.L2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Group extends OrganizationalUnit {
    private List<Student> students;

    public Group(String name, Human head) {
        super(name, head);
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(students);
    }

    public List<Student> getStudents() { return students; }
    public void setStudents(List<Student> students) { this.students = new ArrayList<>(students); }

    public void clearStudents() { students.clear(); }
    public void removeStudent(Student student) { students.remove(student); }

    @Override
    public String getUnitType() {
        return "Група";
    }
}
