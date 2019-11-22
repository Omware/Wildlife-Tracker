import org.sql2o.Connection;

import java.util.List;

public class Animal {
    private int id;
    private String name;


    public Animal(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name) VALUES (:name,)";
            con.createQuery(sql)
                    .addParameter("name", this.name)

                    .executeUpdate();
        }
    }
    public static List<Animal> all() {
        String sql = "SELECT * FROM animals";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Animal.class);
        }
    }
}
