package oo;

import java.util.List;
import java.util.stream.Collectors;

public class School {

    private List<Klass> klasses;

    public School(List<Klass> klasses) {
        this.klasses = klasses;
    }

    public void startSchool() {
        klasses.forEach(klass -> System.out.println(klass.getParticipants()
                .stream()
                .map(Person::introduce)
                .collect(Collectors.joining(System.lineSeparator()))));
    }

}
