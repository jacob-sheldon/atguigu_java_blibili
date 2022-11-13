import java.io.Serializable;

public class Pet implements Serializable {
    private String name;
    private int age;

    public Pet() {
    }

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
