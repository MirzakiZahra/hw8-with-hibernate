package Products;

public class Readable extends Product {
    private  String typeCover;
    private String language;
    private String publisher;





    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setTypeCover(String typeCover) {
        this.typeCover = typeCover;
    }

    public String getTypeCover() {

        return typeCover;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Readable(int id, String name, int cost, int count, String feature, String typeCover, String language, String publisher) {
        super(id, name, cost, count, feature);
        this.typeCover = typeCover;
        this.language = language;
        this.publisher = publisher;
    }

    public Readable(String typeCover, String language, String publisher) {
        this.typeCover = typeCover;
        this.language = language;
        this.publisher = publisher;
    }

    public Readable(){

    }
}
