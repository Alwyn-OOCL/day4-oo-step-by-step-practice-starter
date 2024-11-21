package oo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Klass {

    private Integer id;

    private Student leader;

    private Set<Person> klassParticipants;


    public Klass(Integer id) {
        this.id = id;
    }

    public Klass() {
    }


    public void assignLeader(Student student) {
        if (student.getKlass() == null || !student.getKlass().equals(this)) {
            System.out.print("It is not one of us.\n");
            return;
        }
        this.leader = student;
        notifyKlassObservers();
    }

    public boolean isLeader(Student student) {
        return leader != null && leader.equals(student);
    }

    public void attach(Person person) {
        if (person != null) {
            addKlassParticipant(person);
        }
    }

    public void notifyKlassObservers() {
        for (KlassParticipant participant : klassParticipants) {
            participant.updateLeader(this, leader);
        }
    }

    public void addKlassParticipant(Person klassParticipant) {
        if (klassParticipants == null) {
            klassParticipants = new HashSet<>();
        }
        klassParticipants.add(klassParticipant);
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

    public Set<Person> getParticipants() {
        return klassParticipants;
    }
}
