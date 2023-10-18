package devflix.models;

public class Language {
    private int languageID;
    private String name;

    public Language() {}
    public Language(int languageID, String name) {
        this.languageID = languageID;
        this.name = name;
    }

    public int getLanguageID() {
        return languageID;
    }

    public void setLanguageID(int languageID) {
        this.languageID = languageID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
