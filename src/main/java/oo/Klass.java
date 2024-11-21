package oo;

import java.util.Objects;

public class Klass {

    private Integer id;

    public Klass(Integer id) {
        this.id = id;
    }

    public Klass() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Klass klass = (Klass) o;
        return Objects.equals(id, klass.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
