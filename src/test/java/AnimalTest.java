import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();
    @Test
    public void instantiatesAnimal_true() {
        Animal  testAnimal = new Animal( "Tiger", "Endagered");
        assertEquals(true, testAnimal instanceof Animal);
    }

    @Test
    public void getsAnimalName() {
        Animal  testAnimal = new Animal("Tiger", "Endagered");
        assertEquals("Tiger",  testAnimal.getName());
    }
    @Test
    public void getsAnimalType() {
        Animal  testAnimal = new Animal("Tiger", "Endagered");
        assertEquals("Endagered",  testAnimal.getType());
    }
    @Test
    public void save_assignsIdToObject() {
        Animal testAnimal = new Animal("Tiger", "Endagered");
        testAnimal.save();
        Animal savedAnimal = Animal.all().get(0);
        assertEquals(testAnimal.getId(), savedAnimal.getId());
    }
    @Test
    public void save_insertsObjectIntoDatabase_Animal() {
        Animal  testAnimal1 = new Animal("Tiger", "Endagered");
        testAnimal1.save();
        Animal  testAnimal2 = new Animal("Lion", "Not Endagered");
        testAnimal2.save();
        assertEquals(true, Animal.all().get(0).equals(testAnimal1));
        assertEquals(true, Animal.all().get(1).equals(testAnimal2));

    }


}