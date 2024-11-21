package oo.step8;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import oo.Klass;
import oo.Student;
import oo.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KlassTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void should_notify_participants_when_leader_is_assigned() {
        Klass klass = new Klass(1);
        Teacher teacher = new Teacher(1, "Teacher", 30);
        Student student1 = new Student(1, "Student1", 20);
        Student student2 = new Student(2, "Student2", 20);

        teacher.assignTo(klass);
        student1.join(klass);
        student2.join(klass);

        klass.assignLeader(student1);

        assertThat(systemOut()).contains("I am Teacher, teacher of Class 1. I know Student1 become Leader.");
        assertThat(systemOut()).contains("I am Student1, student of Class 1. I know Student1 become Leader.");
        assertThat(systemOut()).contains("I am Student2, student of Class 1. I know Student1 become Leader.");
    }

    private String systemOut() {
        return outContent.toString();
    }
}