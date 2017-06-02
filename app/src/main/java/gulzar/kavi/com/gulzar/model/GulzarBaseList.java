package gulzar.kavi.com.gulzar.model;

import java.util.ArrayList;

/**
 * Created by Sushant.Patekar on 5/25/2017.
 */

public class GulzarBaseList {
    public ArrayList<PoemModel> PoemList;
    public ArrayList<YouTubeModel> youtubeModelList;

    public ArrayList<PoemModel> getPoemList() {
        return PoemList;
    }

    public void setPoemList(ArrayList<PoemModel> poemList) {
        PoemList = poemList;
    }

    public ArrayList<YouTubeModel> getYoutubeModelList() {
        return youtubeModelList;
    }

    public void setYoutubeModelList(ArrayList<YouTubeModel> youtubeModelList) {
        this.youtubeModelList = youtubeModelList;
    }
}
