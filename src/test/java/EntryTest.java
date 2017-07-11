import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class EntryTest {
  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/address_book_test", null, null);
  }

  // @After
  // public void tearDown() {
  //   try(Connection con = DB.sql2o.open()) {
  //     String sql = "DELETE FROM entries *;";
  //     con.createQuery(sql).executeUpdate();
  //   }
  // }

  @Test
  public void Entry_instantiatesValuesCorrectly_true() {
    Entry myEntry = new Entry("Ally", 435, "Redmond");
    assertEquals(true, myEntry instanceof Entry);
  }

  @Test
  public void getName_instantiatesWithName_Betty() {
    Entry myEntry = new Entry("Betty", 638, "Kirkland");
    assertEquals("Betty", myEntry.getName());
  }

  @Test
  public void getPhoneNumber_instantiateWithPhoneNumber_546() {
    Entry myEntry = new Entry("Anya", 546, "Bellevue");
    assertEquals(546, myEntry.getPhoneNumber());
  }

  @Test
  public void getAddress_instantiatesWithAddress_Seattle() {
    Entry myEntry = new Entry("Clara", 323, "Seattle");
    assertEquals("Seattle", myEntry.getAddress());
  }

  @Test
  public void all_returnsAllInstancesOfEntry_true() {
    Entry myEntry1 = new Entry("Sowmya", 434, "Redmond");
    myEntry1.save();
    Entry myEntry2 = new Entry("Emily", 434, "Redmond");
    myEntry2.save();
    assertEquals(true, Entry.all().get(0).equals(myEntry1));
    assertEquals(true, Entry.all().get(1).equals(myEntry2));
  }

  @Test
  public void save_returnsTrueIfNamesAreSame() {
    Entry myEntry = new Entry("Sowmya", 434, "Redmond");
    myEntry.save();
    assertTrue(Entry.all().get(0).equals(myEntry));
  }

  @Test
  public void equals_returnsTrueIfNamesAreSame() {
    Entry myEntry1 = new Entry("Sowmya3", 434, "Redmond");
    Entry myEntry2 = new Entry("Sowmya3", 434, "Redmond");
    assertTrue(myEntry1.equals(myEntry2));
  }
  @Test
  public void save_assignsIdToObject() {
    Entry myEntry = new Entry("Sowmya", 434, "Redmond");
    myEntry.save();
    Entry savedEntry = Entry.all().get(0);
    assertEquals(myEntry.getId(), savedEntry.getId());
  }
  @Test

}
