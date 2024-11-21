package oo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person {

    private List<Klass> klass;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        String klasses = klass.stream().map(Klass::getId).map(String::valueOf).collect(Collectors.joining(", "));
        return super.introduce() + " I am a teacher. I teach Class " + klasses + ".";
    }

    public boolean belongsTo(Klass klass) {
        return this.klass != null && this.klass.contains(klass);
    }

    public void assignTo(Klass klass) {
        if (this.klass == null) {
            this.klass = new ArrayList<>();
        }
        this.klass.add(klass);
    }
}
