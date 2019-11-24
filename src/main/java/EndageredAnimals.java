public class EndageredAnimals extends Animal {

    private String health;
    private String age;

    public EndageredAnimals(String name,String health, String age) {
        super(name);
        this.health = health;
        this.age = age;

    }
    public String getHealth() {
        return health;
    }
    public String getAge() {
        return age;
    }

}
