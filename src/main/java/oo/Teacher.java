package oo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person {

    private List<Klass> klasses;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        String klassesIds = klasses.stream()
                .map(Klass::getId)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        return super.introduce() + " I am a teacher. I teach Class " + klassesIds + ".";
    }

    public boolean belongsTo(Klass klass) {
        return this.klasses != null && this.klasses.contains(klass);
    }

    public void assignTo(Klass klass) {
        if (this.klasses == null) {
            this.klasses = new ArrayList<>();
        }
        this.klasses.add(klass);
    }

    public boolean isTeaching(Student tom) {
        return klasses.stream().anyMatch(klass -> klass.getId().equals(tom.getKlass().getId()));
    }
}
