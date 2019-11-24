import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();
    @Test
    public void instantiatesAnimal_true() {
        Animal  testAnimal = new Animal( "Tiger");
        assertEquals(true, testAnimal instanceof Animal);
    }

    @Test
    public void getsAnimalName() {
        Animal  testAnimal = new Animal("Tiger");
        assertEquals("Tiger",  testAnimal.getName());
    }
    @Test
    public void getsAnimalType() {
        assertEquals("Endagered",  Animal.getType());
    }
    @Test
    public void save_assignsIdToObject() {
        Animal testAnimal = new Animal("Tiger");
        testAnimal.save();
        Animal savedAnimal = Animal.all().get(0);
        assertEquals(testAnimal.getId(), savedAnimal.getId());
    }
    @Test
    public void save_insertsObjectIntoDatabase_Animal() {
        Animal  testAnimal = new Animal("Tiger");
        testAnimal.save();
        Animal  testAnimal1 = new Animal("Lion");
        testAnimal1.save();
        assertTrue(Animal.all().get(0).equals(testAnimal));
        assertTrue(Animal.all().get(1).equals(testAnimal1));

    }


}