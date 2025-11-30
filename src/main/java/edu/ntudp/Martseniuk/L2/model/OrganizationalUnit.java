package edu.ntudp.Martseniuk.L2.model;

import java.util.Objects;

public abstract class OrganizationalUnit {
    protected String name;
    protected Human head;

    public OrganizationalUnit(String name, Human head) {
        this.name = name;
        this.head = head;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationalUnit that = (OrganizationalUnit) o;
        return Objects.equals(name, that.name) && Objects.equals(head, that.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, head);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Human getHead() { return head; }
    public void setHead(Human head) { this.head = head; }

    public abstract String getUnitType();

    @Override
    public String toString() {
        return getUnitType() + ": " + name + ", Керівник: " + head.getFullName();
    }
}
