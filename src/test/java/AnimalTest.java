import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {
    @Test
    public void instantiatesAnimal_true() {
        Animal  animal = new Animal(1, "Tiger", "Healthy", 5);
        assertEquals(true, animal instanceof Animal);
    }

}