package oo;

public class Student extends Person {

    private Klass klass;
    public Student(int id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        return super.introduce() + " I am a student. I am in class " + klass.getId() + ".";
    }

    public boolean isIn(Klass klass) {
        return this.klass != null && this.klass.equals(klass);
    }

    public void join(Klass klass) {
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }
}
