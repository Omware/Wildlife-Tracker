import org.junit.Test;

import static org.junit.Assert.*;

public class SightingsTest {
    @Test
    public void sightingInstantiatesProperly() {
        Sightings sightings = new Sightings(1, "Nairobi", "Keith Omware");
        assertEquals(true,sightings instanceof Sightings);
    }
    @Test
    public void getsAnimalIdProperly() {
        Sightings sightings = new Sightings(1, "Nairobi", "Keith Omware");
        assertEquals(1,sightings.getAnimalId() );
    }
    @Test
    public void getsAnimalLocationProperly() {
        Sightings sightings = new Sightings(1, "Nairobi", "Keith Omware");
        assertEquals("Nairobi",sightings.getLocation());
    }
    @Test
    public void getsRangerNameProperly() {
        Sightings sightings = new Sightings(1, "Nairobi", "Keith Omware");
        assertEquals("Keith Omware",sightings.getRangerName());
    }

}