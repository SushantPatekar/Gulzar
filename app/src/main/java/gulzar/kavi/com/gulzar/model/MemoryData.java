package gulzar.kavi.com.gulzar.model;

import java.util.ArrayList;
import java.util.List;

import gulzar.kavi.com.gulzar.utilities.GulzarCofig;

/**
 * Created by Sushant.Patekar on 5/25/2017.
 */

public class MemoryData {
    public List<GulzarCofig.Poem> PoemList;
    public List<GulzarCofig.YouTubeData> youtubeModelList;

    public List<GulzarCofig.Poem> getPoemList() {
        return PoemList;
    }

    public void setPoemList(List<GulzarCofig.Poem> poemList) {
        PoemList = poemList;
    }

    public List<GulzarCofig.YouTubeData> getYoutubeModelList() {
        return youtubeModelList;
    }

    public void setYoutubeModelList(List<GulzarCofig.YouTubeData> youtubeModelList) {
        this.youtubeModelList = youtubeModelList;
    }

    public MemoryData() {
        PoemList = new ArrayList<GulzarCofig.Poem>();
        youtubeModelList= new ArrayList<GulzarCofig.YouTubeData>();
    }
}
