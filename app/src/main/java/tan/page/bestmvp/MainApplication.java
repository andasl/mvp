/**
 * @项目名称: BestMVP
 * @文件名称: MainApplication
 * @Date: 2016/7/9
 * @Copyright: 2016 pageTan All rights reserved.
 * 版权所有：pageTan
 * 注意：使用请注明版权
 */
package tan.page.bestmvp;

import android.app.Application;

/**
 * Created by pageTan on 2016/7/9.
 */
public class MainApplication extends Application {

    private static MainApplication instance;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static MainApplication getInstance(){
        return instance;
    }






}
