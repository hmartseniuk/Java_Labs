package edu.ntudp.Martseniuk.L2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department extends OrganizationalUnit {
    private List<Group> groups;

    public Department(String name, Human head) {
        super(name, head);
        this.groups = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(groups, that.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(groups);
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public List<Group> getGroups() { return groups; }
    public void setGroups(List<Group> groups) { this.groups = new ArrayList<>(groups); }

    @Override
    public String getUnitType() {
        return "Кафедра";
    }
}
