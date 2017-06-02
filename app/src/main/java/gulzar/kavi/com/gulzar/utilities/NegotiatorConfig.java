package gulzar.kavi.com.gulzar.utilities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Use plugin DTOnator (https://plugins.jetbrains.com/plugin/7834?pr=idea) to implement a model from JSON
 *
 * Call with Right click -> DTO from JSON
 *
 * following parameters:
 *  - Create single file
 *  - make fields private
 *  - Type: GSON
 *  - Prefix each field with: m
 *  - Use Camel Case
 *
 * Special:
 *  Add "implements Serializable" to every class
 *
 *
 * Created by wvo on 23.10.15.
 */
public class NegotiatorConfig {


    @SerializedName("Modules")
    private List<Modules> mModules;
    @SerializedName("Providers")
    private List<Providers> mProviders;

    public List<Modules> getModules() {
        return mModules;
    }

    public List<Providers> getProviders() {
        return mProviders;
    }

    public static class Channels implements Serializable {
        @SerializedName("Title")
        private String mTitle;
        @SerializedName("Subtitle")
        private String mSubtitle;
        @SerializedName("Resource")
        private String mResource;
        @SerializedName("RedirectPossible")
        private boolean mRedirectpossible;
        @SerializedName("ProviderType")
        private String mProvidertype;
        @SerializedName("AdapterType")
        private String mAdaptertype;
        @SerializedName("ImageName")
        private String mImagename;

        public String getTitle() {
            return mTitle;
        }

        public String getSubtitle() {
            return mSubtitle;
        }

        public String getResource() {
            return mResource;
        }

        public boolean getRedirectpossible() {
            return mRedirectpossible;
        }

        public String getProvidertype() {
            return mProvidertype;
        }

        public String getAdaptertype() {
            return mAdaptertype;
        }

        public String getImagename() {
            return mImagename;
        }
    }

    public static class Categories implements Serializable {
        @SerializedName("Name")
        private String mName;
        @SerializedName("DirectAccess")
        private boolean mDirectaccess;
        @SerializedName("ImageNameAndroid")
        private String mImagenameandroid;
        @SerializedName("Channels")
        private List<Channels> mChannels;

        public String getName() {
            return mName;
        }

        public boolean getDirectaccess() {
            return mDirectaccess;
        }

        public String getImagenameandroid() {
            return mImagenameandroid;
        }

        public List<Channels> getChannels() {
            return mChannels;
        }
    }

    public static class Modules implements Serializable {
        @SerializedName("ID")
        private String mId;
        @SerializedName("Title")
        private String mTitle;
        @SerializedName("ImageNameAndroid")
        private String mImagenameandroid;
        @SerializedName("Categories")
        private List<Categories> mCategories;

        public String getId() {
            return mId;
        }

        public String getTitle() {
            return mTitle;
        }

        public String getImagenameandroid() {
            return mImagenameandroid;
        }

        public List<Categories> getCategories() {
            return mCategories;
        }
    }

    public static class Providers implements Serializable {
        @SerializedName("Type")
        private String mType;
        @SerializedName("Key")
        private String mKey;
        @SerializedName("Secret")
        private String mSecret;

        public String getType() {
            return mType;
        }

        public String getKey() {
            return mKey;
        }

        public String getSecret() {
            return mSecret;
        }
    }
}
