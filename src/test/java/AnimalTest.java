import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {
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
        Animal  animal = new Animal(1, "Tiger");
        assertEquals("Tiger",  animal.getName());
    }

}