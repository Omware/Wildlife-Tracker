import org.sql2o.Connection;

import java.util.List;

public class EndageredAnimals extends Animal {

    private String health;
    private String age;

    public EndageredAnimals(String name, String health, String age) {
        this.name = name;
        this.health = health;
        this.age = age;
        type = "endangered";

    }

    public static List<EndageredAnimals> allEndAnimals() {
        String sql = "SELECT * FROM animals where type='endangered'";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(EndageredAnimals.class);
        }
    }
    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name, type, health, age) VALUES (:name, :type, :health, :age)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("type", this.type)
                    .addParameter("health", this.health)
                    .addParameter("age", this.age)
                    .executeUpdate()
                    .getKey();
        }
    }

    public int getId() {
        return id;
    }
    public String getHealth() {
        return health;
    }
    public String getAge() {
        return age;
    }


    public static EndageredAnimals find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            EndageredAnimals endegeredAnimal= con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(EndageredAnimals.class);
            return endegeredAnimal;
        }
    }

}
