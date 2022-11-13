import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int age;
    private String addree;

    public Person(String name, int age, String addree, Pet pet) {
        this.name = name;
        this.age = age;
        this.addree = addree;
        this.pet = pet;
    }

    private Pet pet;

    public Person() {
    }

    public Person(String name, int age, Pet pet) {
        this.name = name;
        this.age = age;
        this.pet = pet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", pet=" + pet +
                '}';
    }
}
