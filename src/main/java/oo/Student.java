package oo;

public class Student extends Person {

    private Klass klass;
    public Student(int id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        Person leader = klass.getLeader();
        if (leader == null) {
            return super.introduce() + " I am a student. I am at class " + klass.getId() + ".";
        }
        return super.introduce() + " I am a student. I am the leader of class " + klass.getId() + ".";
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
