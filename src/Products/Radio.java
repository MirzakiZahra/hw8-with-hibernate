package Products;

import Enums.SourceEnergyType;

public class Radio  extends Electronic {
    private String radioWave;
    private SourceEnergyType sourceEnergyType;

    public SourceEnergyType getSourceEnergyType() {
        return sourceEnergyType;
    }

    public void setSourceEnergyType(SourceEnergyType sourceEnergyType) {
        this.sourceEnergyType = sourceEnergyType;
    }

    public String getRadioWave() {
        return radioWave;
    }

    public void setRadioWave(String radioWave) {
        this.radioWave = radioWave;
    }

    public Radio(int id, String name, int cost, int count, String feature, String brand, String radioWave, SourceEnergyType sourceEnergyType) {
        super(id, name, cost, count, feature, brand);
        this.radioWave = radioWave;
        this.sourceEnergyType = sourceEnergyType;
    }

    public Radio(String brand, String radioWave, SourceEnergyType sourceEnergyType) {
        super(brand);
        this.radioWave = radioWave;
        this.sourceEnergyType = sourceEnergyType;
    }

    public Radio(String radioWave, SourceEnergyType sourceEnergyType) {
        this.radioWave = radioWave;
        this.sourceEnergyType = sourceEnergyType;
    }
}
