import org.sql2o.Connection;

import java.util.List;

public class EndageredAnimals extends Animal {
    private int id;
    private String name;
    private String health;
    private int age;

    public EndageredAnimals(String name,String health, int age) {
        super(name);
        this.health = health;
        this.age = age;

    }
    public String getHealth() {
        return health;
    }
    public int getAge() {
        return age;
    }
    public int getId() {
        return id;
    }
}
