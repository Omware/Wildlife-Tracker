import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();
    @Test
    public void instantiatesAnimal_true() {
        Animal  animal = new Animal(1, "Tiger");
        assertEquals(true, animal instanceof Animal);
    }
    @Test
    public void getsAnimalId() {
        Animal  animal = new Animal(1, "Tiger");
        assertEquals(1,  animal.getId());
    }
    @Test
    public void getsAnimalName() {
        Animal  testAnimal = new Animal(1, "Tiger");
        assertEquals("Tiger",  testAnimal.getName());
    }
    @Test
    public void save_insertsObjectIntoDatabase_Animal() {
        Animal  testAnimal = new Animal(1, "Tiger");
        testAnimal.save();
        assertTrue(Animal.all().get(0).equals(testAnimal));
    }
    @Test
    public void all_returnsAllInstancesOfPerson_true() {
        Animal  testAnimal1 = new Animal(1, "Tiger");
        testAnimal1.save();
        Animal  testAnimal2 = new Animal(1, "Tiger");
        testAnimal2.save();
        assertEquals(true, Animal.all().get(0).equals(testAnimal1));
        assertEquals(true, Animal.all().get(1).equals(testAnimal2));
    }

}