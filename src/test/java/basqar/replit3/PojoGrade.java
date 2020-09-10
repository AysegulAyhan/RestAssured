package basqar.replit3;

public class PojoGrade {
    private String name;
    private String shortName;
    private String order;
    private Boolean active;
    private String id;
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
//private NextGradeLevel nextGradeLevel;

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

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

//    public NextGradeLevel getNextGradeLevel() {
//        return nextGradeLevel;
//    }
//
//    public void setNextGradeLevel(NextGradeLevel nextGradeLevel) {
//        this.nextGradeLevel = nextGradeLevel;
//    }
}
