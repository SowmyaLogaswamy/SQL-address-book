import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class EntryTest {
  @Before
  public void setUp() {
    DB.sql2o. new Sql2o("jdbs:postgresql://localhost:5432/address_book_test", null, null);
  }

  // @After
  // public void tearDown() {
  //   try(Connection con = DB.sql2o.open()) {
  //     String sql = "DELETE FROM entries *;";
  //     con.createQuery(sql).executeUpdate();
  //   }
  // }

  @Test
  public void Entry_instantiatesWithValuesCorrectly_true() {
    Entry myEntry = new Entry("Kumar", 435, "Redmond");
    assertEquals(true, myEntry instanceof Entry);
  }

}
