import java.util.ArrayList;
import java.util.List;

public class Entry {
  String personName;
  int personPhoneNumber;
  String personAddress;

public Entry(String name, int phoneNumber, String address)
{
  personName = name;
  personPhoneNumber = phoneNumber;
  personAddress = address;
}

public String getName() {
   return personName;
}
public int getPhoneNumber() {
  return personPhoneNumber;
}
public String getAddress() {
  return personAddress;
}

}
