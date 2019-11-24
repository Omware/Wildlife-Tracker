import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndageredAnimalsTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();
    @Test
    public void instantiatesAnimal_true() {
        EndageredAnimals  testAnimal = new EndageredAnimals ( "Tiger", "Healthy", "Young");
        assertEquals(true, testAnimal instanceof EndageredAnimals);
    }
    @Test
    public void getsAnimalType() {
        EndageredAnimals  testAnimal = new EndageredAnimals ( "Tiger", "Healthy", "Young");
        assertEquals("Young", testAnimal.getAge());
    }
    @Test
    public void getsAnimalHealth() {
        EndageredAnimals  testAnimal = new EndageredAnimals ( "Tiger", "Healthy", "Young");
        assertEquals("Healthy", testAnimal.getHealth());
    }


}