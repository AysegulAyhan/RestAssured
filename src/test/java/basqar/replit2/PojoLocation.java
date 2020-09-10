package basqar.replit2;

public class PojoLocation {
 private String name;
 private String shortName;
 private String type;
 private String capacity;
 private School school;

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
    //name: (Name is up to you)
//shortName : ( shortName is up to you)
//type : ("CLASS")
//capacity : ( capacity is up to you)
//school:
//                { id: (" 5c5aa8551ad17423a4f6ef1d") } ***
}
