import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public abstract class BaseTest extends UnitTest {

    @Before
    public void loadData() {
        Fixtures.deleteAll();
        Fixtures.load("test-data.yml");
    }
    
}
