package au.com.wilkinson.martin;

/**
 * Created by jc260174 on 7/10/16.
 */
public class TrumpCard extends GameCard {
    private String title;
    private String subtitle;
    private String image;

    public String getImage() {
        return image;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    TrumpCard(String title, String subtitle, String imge) {
         this.title = title;
         this.image = imge;
         this.subtitle = subtitle;
    }

    @Override
    public String toString() {
        return "TrumpCard{" +
                "title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                '}';
    }
}
