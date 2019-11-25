import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndageredAnimalsTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();
    @Test
    public void instantiatesAnimal_true() {
        EndageredAnimals  testEndageredAnimal = new EndageredAnimals ( "Tiger", "okay", "young");
        assertEquals(true, testEndageredAnimal instanceof EndageredAnimals);
    }
    @Test
    public void getsAnimalName() {
        EndageredAnimals  testEndageredAnimal = new EndageredAnimals ( "Tiger", "okay", "young");
        assertEquals("Tiger", testEndageredAnimal.getName());
    }
    @Test
    public void getsAnimalType() {
        EndageredAnimals  testEndageredAnimal = new EndageredAnimals ( "Tiger", "okay", "young");
        assertEquals("Young", testEndageredAnimal.getAge());
    }
    @Test
    public void getsAnimalHealth() {
        EndageredAnimals  testEndageredAnimal = new EndageredAnimals ( "Tiger",  "okay", "young");
        assertEquals("Healthy", testEndageredAnimal.getHealth());
    }
    @Test
    public void savesIdToObject() {
        EndageredAnimals  testEndageredAnimal = new EndageredAnimals ( "Tiger",  "okay", "young");
        testEndageredAnimal.save();
        EndageredAnimals savedEndageredAnimal = EndageredAnimals.allEndAnimals().get(0);
        assertEquals(testEndageredAnimal.getId(), savedEndageredAnimal.getId());

    }



}