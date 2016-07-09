/**
 * @项目名称: BestMVP
 * @文件名称: NetworkUtil
 * @Date: 2016/7/7
 * @Copyright: 2016 pageTan All rights reserved.
 * 版权所有：pageTan
 * 注意：使用请注明版权
 */
package tan.page.bestmvp.common.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import tan.page.bestmvp.MainApplication;

/**
 * 网络相关util
 * Created by pageTan on 2016/7/7.
 */
public class NetworkUtil {


    private static final String NETWORK_STATE_MOBILE = "MOBILE"; // 手机流量数据网络

    private static final String NETWORK_STATE_WIFI = "WIFI"; // WIFI 网络

    private static final String NETWORK_STATE_NOT_CONNECTED = "NOT CONNECTED"; // WIFI 网络

    /**
     * 获取是否已经连接网络
     *
     * @return 是否连接网络
     */
    public static boolean isConnected() {
        ConnectivityManager connectiviyManager = (ConnectivityManager) MainApplication.getInstance().
                getSystemService(Context.CONNECTIVITY_SERVICE);
        return (connectiviyManager.getActiveNetworkInfo() != null &&
                connectiviyManager.getActiveNetworkInfo().isAvailable());
    }


    /**
     * 获取是否已经使用 WIFI 连接网络
     *
     * @return 是否连接 WIFI
     */
    public static boolean isConnectedOnWifi() {
        ConnectivityManager connectiviyManager = (ConnectivityManager) MainApplication.getInstance().
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectiviyManager.getActiveNetworkInfo();
        return (activeNetworkInfo != null && activeNetworkInfo.isAvailable() &&
                activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI);
    }


    /**
     * 获取当前网络状态 区分：NOT CONNECTED / MOBILE / WIFI
     *
     * @return 当前连接的网络状态
     */
    public static String getConnectState() {
        if (isConnected()) {
            if (isConnectedOnWifi()) {
                return NETWORK_STATE_WIFI;
            } else {
                return NETWORK_STATE_MOBILE;
            }
        }
        return NETWORK_STATE_NOT_CONNECTED;
    }

}
