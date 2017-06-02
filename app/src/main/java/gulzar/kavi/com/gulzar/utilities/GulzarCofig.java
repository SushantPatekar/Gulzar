package gulzar.kavi.com.gulzar.utilities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Sushant.Patekar on 5/25/2017.
 */

public class GulzarCofig {
    public List<Poem> getPoems() {
        return poems;
    }

    public List<YouTubeData> getYouTubeData() {
        return youTubeData;
    }

    @SerializedName("Poem")
    private List<Poem> poems;
    @SerializedName("YouTubeData")
    private List<YouTubeData> youTubeData;



    public class Poem implements Serializable{
        @SerializedName("id")
        private String mTitle;
        @SerializedName("Title")
        private String mSubtitle;
        @SerializedName("content_poem")
        private String mContent_poem;

        public String getmTitle() {
            return mTitle;
        }

        public String getmSubtitle() {
            return mSubtitle;
        }

        public String getmContent_poem() {
            return mContent_poem;
        }

/*        @SerializedName("PoemSet")
        private List<PoemSet> poemset;

        public List<PoemSet> getPoemset() {
            return poemset;
        }*/
    }
    public class PoemSet implements Serializable{
        @SerializedName("ChaiyaChaiya")
        private List<ChaiyaChaiya> mChaiyaChaiya;

        public List<ChaiyaChaiya> getmKuchNazm() {
            return mChaiyaChaiya;
        }
    }
    public class ChaiyaChaiya implements Serializable{
        @SerializedName("id")
        private String mTitle;
        @SerializedName("Title")
        private String mSubtitle;
        @SerializedName("content_poem")
        private String mContent_poem;

        public String getmTitle() {
            return mTitle;
        }

        public String getmSubtitle() {
            return mSubtitle;
        }

        public String getmContent_poem() {
            return mContent_poem;
        }
    }

    public static class YouTubeData implements Serializable{


        @SerializedName("Title")
        private String mTitle;
        @SerializedName("YouTubeKey")
        private String mYoutubeKey;

        public String getmTitle() {
            return mTitle;
        }

        public String getmYoutubeKey() {
            return mYoutubeKey;
        }
    }
}
