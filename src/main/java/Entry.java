import java.util.List;
import org.sql2o.*;

public class Entry {
  private String name;
  private int phone_number;
  private String address;
  private int id;

public Entry(String name, int phoneNumber, String address)
{
  this.name = name;
  this.phone_number = phoneNumber;
  this.address = address;
}

public String getName() {
   return name;
}
public int getPhoneNumber() {
  return phone_number;
}
public String getAddress() {
  return address;
}
// public static Entry find(int id) {
//
// }
public static List<Entry> all() {
  String sql = "SELECT * FROM entries";
  try(Connection con = DB.sql2o.open()) {
    return con.createQuery(sql).executeAndFetch(Entry.class);
  }
}

@Override
public boolean equals(Object otherEntry) {
  if(!(otherEntry instanceof Entry)) {
    return false;
  } else {
    Entry newEntry = (Entry) otherEntry;
    return this.getName().equals(newEntry.getName());
  }
}

public void save() {
  try(Connection con = DB.sql2o.open()) {
    String sql = "INSERT INTO entries(name, phone_number, address) VALUES (:name, :phoneNumber, :address)";
    this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .addParameter("phoneNumber", this.phone_number)
      .addParameter("address", this.address)
      .executeUpdate()
      .getKey();
  }
}

}
