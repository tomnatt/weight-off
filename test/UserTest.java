import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class UserTest extends BaseTest {

    @Test
    public void testLoadWeights() {
        User bob = (User)User.find("byName", "Bob").fetch().get(0);
        assertEquals(4, bob.weights.size());
    }
    
    @Test
    public void testGetFirstWeightBob() {
        User bob = (User)User.find("byName", "Bob").fetch().get(0);
        Weight w = bob.getFirstWeight();
        assertNotNull(w);
        assertEquals(110, w.kg);
    }
    
    @Test
    public void testGetFirstWeightJane() {
        User jane = (User)User.find("byName", "Jane").fetch().get(0);
        Weight w = jane.getFirstWeight();
        assertNotNull(w);
        assertEquals(80, w.kg);
    }
    
    @Test
    public void testGetLastWeightBob() {
        User bob = (User)User.find("byName", "Bob").fetch().get(0);
        Weight w = bob.getLastWeight();
        assertNotNull(w);
        assertEquals(100, w.kg);
    }
    
    @Test
    public void testGetLastWeightJane() {
        User jane = (User)User.find("byName", "Jane").fetch().get(0);
        Weight w = jane.getLastWeight();
        assertNotNull(w);
        assertEquals(78, w.kg);
    }
    
    @Test
    public void testInGame() {
        User jane = (User)User.find("byName", "Jane").fetch().get(0);
        assertTrue(jane.inGame());
    }
    
    @Test
    public void testPlayingAgainst() {
        User jane = (User)User.find("byName", "Jane").fetch().get(0);
        ArrayList<User> players = new ArrayList(jane.games.get(0).players);
        players.remove(jane);
        assertEquals(1, players.size());
        assertEquals("Bob", players.get(0).name);
    }
    
}
