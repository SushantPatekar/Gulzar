package gulzar.kavi.com.gulzar;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;

import gulzar.kavi.com.gulzar.utilities.Constants;
import gulzar.kavi.com.gulzar.utilities.GulzarCofig;
import gulzar.kavi.com.gulzar.utilities.NegotiatorConfig;

/**
 * Created by Sushant.Patekar on 5/25/2017.
 */

public class SplashActivity extends AppCompatActivity{
    Context context;
    GulzarCofig gulzarCofigBaseList;
    public static String TAG= SplashActivity.class.getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        init();

        new downloadFile().execute();
    }
    public void init(){
        context = SplashActivity.this;
    }
    public class downloadFile extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... params) {

            if (context != null) {
                InputStreamReader reader = null;
                try {
                    reader = new InputStreamReader(context.getAssets().open(Constants.CONFIG_NAME), "UTF-8");
                    Gson gson = new Gson();
                    gulzarCofigBaseList = gson.fromJson(reader, GulzarCofig.class);

                    GulzarApp.memoryData.setPoemList(gulzarCofigBaseList.getPoems());
                    GulzarApp.memoryData.setYoutubeModelList(gulzarCofigBaseList.getYouTubeData());
                    Log.d(TAG, "doInBackground() called with: params = [" +   GulzarApp.memoryData.getPoemList() + "]");
                    // Log.i(TAG, "Length of Modules: " + list.getModule());
                } catch (IOException e) {
                    //log the exception
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            //log the exception
                        }
                    }
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Intent intent= new Intent(SplashActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }


   /* */
}
