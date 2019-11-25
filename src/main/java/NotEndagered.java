import org.sql2o.Connection;

import java.util.List;


public class NotEndagered  extends Animal{
    public NotEndagered(String name) {
        this.name = name;
        type = "Not Endangered";
}

    public static Animal find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            Animal animal = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Animal.class);
            return animal;
        }
    }

    public static List<NotEndagered> all() {
        String sql = "SELECT * FROM animals WHERE type = 'Not Endangered'";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(NotEndagered.class);
        }
    }

}
