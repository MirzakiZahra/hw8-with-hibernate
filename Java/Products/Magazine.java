package Products;

import Enums.MagazineType;
import Products.Readable;

public class Magazine extends Readable {
   private String type;
   private String periodPublish;
   private MagazineType magazineType;

    public MagazineType getMagazineType() {
        return magazineType;
    }

    public void setMagazineType(MagazineType magazineType) {
        this.magazineType = magazineType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPeriodPublish() {
        return periodPublish;
    }

    public void setPeriodPublish(String periodPublish) {
        this.periodPublish = periodPublish;
    }

    public Magazine(int id, String name, int cost, int count, String feature, String typeCover, String language, String publisher, String type, String periodPublish, MagazineType magazineType) {
        super(id, name, cost, count, feature, typeCover, language, publisher);
        this.type = type;
        this.periodPublish = periodPublish;
        this.magazineType = magazineType;
    }

    public Magazine(String typeCover, String language, String publisher, String type, String periodPublish, MagazineType magazineType) {
        super(typeCover, language, publisher);
        this.type = type;
        this.periodPublish = periodPublish;
        this.magazineType = magazineType;
    }

    public Magazine(String type, String periodPublish, MagazineType magazineType) {
        this.type = type;
        this.periodPublish = periodPublish;
        this.magazineType = magazineType;
    }
}
