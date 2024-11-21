package oo.step7;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import oo.Klass;
import oo.School;
import oo.Student;
import oo.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SchoolTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void should_print_message_when_startSchool_given_teaches_and_students() {
        Klass klass1 = new Klass(1);

        Student tom = new Student(1, "Tom", 21);
        tom.join(klass1);

        Teacher jerry = new Teacher(2, "Jerry", 21);
        jerry.assignTo(klass1);

        Klass klass2 = new Klass(2);

        Student alwyn = new Student(3, "Alwyn", 21);
        alwyn.join(klass2);

        Teacher minghao = new Teacher(4, "Minghao", 21);
        minghao.assignTo(klass2);

        new School(List.of(klass1, klass2)).startSchool();

        assertThat(systemOut()).contains("My name is Tom. I am 21 years old. I am a student. I am at class 1.");
        assertThat(systemOut()).contains("My name is Jerry. I am 21 years old. I am a teacher. I teach class 1.");
        assertThat(systemOut()).contains("My name is Alwyn. I am 21 years old. I am a student. I am at class 2.");
        assertThat(systemOut()).contains("My name is Minghao. I am 21 years old. I am a teacher. I teach class 2.");
    }

    private String systemOut() {
        return outContent.toString();
    }

}
