package devflix.models;

public class Person {
    private int personID;
    private String name;
    private String imageURL;

    public Person() {}
    public Person(int personID, String name, String imageURL) {
        this.personID = personID;
        this.name = name;
        this.imageURL = imageURL;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
