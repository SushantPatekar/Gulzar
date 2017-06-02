package gulzar.kavi.com.gulzar.utilities;

import android.content.Context;

/**
 * Created by Sushant.Patekar on 5/25/2017.
 */

public class Helper {

    private static  Helper helperInstance= new Helper();;
    public static Helper getInstance() {
        return helperInstance;
    }

    public Helper setEnvironment(Context context){

        helperInstance = new Helper();
        return  helperInstance;
    }
    private Helper(){

    }
}
