package oo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Klass {

    private Integer id;

    private Student leader;

    private List<Person> participants;

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

    public Integer getId() {
        return id;
    }

    public Person getLeader() {
        return leader;
    }

    public void assignLeader(Student student) {
        if (student.getKlass() == null || !student.getKlass().equals(this)) {
            System.out.print("It is not one of us.\n");
            return;
        }
        this.leader = student;
        participants.forEach(person -> {
            if (person instanceof Teacher) {
                System.out.print("I am " + person.getName() + ", teacher of Class " + id + ". I know " + student.getName() + " become Leader.\n");
            }
            if (person instanceof Student) {
                System.out.print("I am " + person.getName() + ", student of Class " + id + ". I know " + student.getName() + " become Leader.\n");
            }
        });
    }

    public boolean isLeader(Student student) {
        return leader != null && leader.equals(student);
    }

    public void attach(Person person) {
        if (participants == null) {
            participants = new ArrayList<>();
        }
        participants.add(person);
    }
}
