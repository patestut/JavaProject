/**
 * Stuti Patel
 * 991663001
 * Treesa Saju
 * 991670853
 * Final Project
 *11th April 2023
 */
package content;

public class Employee {


private int ID;
private String Name;
private String City;
private String Position;

    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String Position) {
        this.Position = Position;
    }

    public Employee(int ID, String Name, String City, String Position) {
        this.ID = ID;
        this.Name = Name;
        this.City = City;
        this.Position = Position;
    }
}
