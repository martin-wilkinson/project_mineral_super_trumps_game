package au.com.wilkinson.martin;

import java.util.Arrays;

/**
 * Created by jc260174 on 7/10/16.
 */
public class PlayCard extends GameCard {
    private String title;
    private String chemistry;
    private String classification;
    private String crysSys;
    private String[] occrnce;
    private double hardness;
    private double specGrav;
    private String clvge;
    private String crysAbundance;
    private String econValue;
    private String image;


    public PlayCard(String title, String chemistry, String classification, String crysSys, String[] occrnce, double hardnss, double specGrav, String clvge, String crstabndce, String econVal, String imge ){
        this.title = title;
        this.chemistry = chemistry;
        this.classification = classification;
        this.crysSys = crysSys;
        this.occrnce = occrnce;
        this.hardness = hardnss;
        this.specGrav = specGrav;
        this.clvge = clvge;
        this.crysAbundance = crstabndce;
        this.econValue = econVal;
        this.image = imge;
    }

    public String getTitle() {
        return title;
    }

    public String getChemistry() {
        return chemistry;
    }

    public String getClassification() {
        return classification;
    }

    public String getCrysSys() {
        return crysSys;
    }

    public String[] getOccrnce() {
        return occrnce;
    }

    public double getHardness() {
        return hardness;
    }

    public double getSpecGrav() {
        return specGrav;
    }

    public int getClvge(PlayCard card) {
        int clvgeVal = 0;
        switch (card.clvge){
            case "none":
                clvgeVal = 1;
                break;
            case "poor/none":
                clvgeVal = 2;
                break;
            case "1 poor":
                clvgeVal = 3;
                break;
            case "2 poor":
                clvgeVal = 4;
                break;
            case "1 good":
                clvgeVal = 5;
                break;
            case "1 good, 1 poor":
                clvgeVal = 6;
                break;
            case "2 good":
                clvgeVal = 7;
                break;
            case "3 good":
                clvgeVal = 8;
                break;
            case "1 perfect":
                clvgeVal = 9;
                break;
            case "1 perfect, 1 good":
                clvgeVal = 10;
                break;
            case "1 perfect, 2 good":
                clvgeVal = 11;
                break;
            case "2 perfect, 1 good":
                clvgeVal = 12;
                break;
            case "3 perfect":
                clvgeVal = 13;
                break;
            case "4 perfect":
                clvgeVal = 14;
                break;
            case "6 perfect":
                clvgeVal = 15;
                break;
        }
        return clvgeVal;
    }

    public int getCrysAbundance(PlayCard card) {
        int crusAbundance = 0;
        switch (card.crysAbundance){
            case "ultratrace":
                crusAbundance = 1;
                break;
            case "trace":
                crusAbundance = 2;
                break;
            case "low":
                crusAbundance = 3;
                break;
            case "moderate":
                crusAbundance = 4;
                break;
            case "high":
                crusAbundance = 5;
                break;
            case "very High":
                crusAbundance = 6;
                break;
        }
        return crusAbundance;
    }


    public int getEconValue(PlayCard card) {
        int econValueInt = 0;
        switch (card.econValue){
            case "trivial":
                econValueInt = 1;
                break;
            case "low":
                econValueInt = 2;
                break;
            case "moderate":
                econValueInt = 3;
                break;
            case "high":
                econValueInt = 4;
                break;
            case "very high":
                econValueInt = 5;
                break;
            case "I'm rich!":
                econValueInt = 6;
                break;
        }
        return econValueInt;
    }

    public String getImage() {
        return image;
    }

    public void setEconValue(String econValue) {
        this.econValue = econValue;
    }

    @Override
    public String toString() {
        return "PlayCard{" +
                "title='" + title + '\'' +
                ", chemistry='" + chemistry + '\'' +
                ", classification='" + classification + '\'' +
                ", crysSys='" + crysSys + '\'' +
                ", occrnce=" + Arrays.toString(occrnce) +
                ", hardness='" + hardness + '\'' +
                ", specGrav='" + specGrav + '\'' +
                ", clvge='" + clvge + '\'' +
                ", crysAbundance='" + crysAbundance + '\'' +
                ", econValue='" + econValue + '\'' +
                '}';
    }
}
