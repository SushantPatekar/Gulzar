package gulzar.kavi.com.gulzar;

import android.app.Application;

import gulzar.kavi.com.gulzar.model.MemoryData;

/**
 * Created by Sushant.Patekar on 5/25/2017.
 */

public class GulzarApp extends Application {
    public static MemoryData memoryData;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInstances();
    }

    public void initializeInstances() {
        memoryData = new MemoryData();

    }
}
