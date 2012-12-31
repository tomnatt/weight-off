import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class GameTest extends BaseTest {
    
    @Test
    public void testGetOpponents() {
        Game g = (Game)Game.find("byName", "Main").fetch().get(0);
        User jane = (User)User.find("byName", "Jane").fetch().get(0);
        assertEquals(1, g.getOpponents(jane).size());
        assertEquals("Bob", g.getOpponents(jane).get(0).name);
    }

}
