/**
 * @项目名称: BestMVP
 * @文件名称: BusinessContract
 * @Date: 2016/7/9
 * @Copyright: 2016 pageTan All rights reserved.
 * 版权所有：pageTan
 * 注意：使用请注明版权
 */
package tan.page.bestmvp.common.mvp;

import java.util.Map;

import tan.page.bestmvp.common.mvp.base.BasePresenter;
import tan.page.bestmvp.common.mvp.base.BaseUI;

/**
 * Created by pageTan on 2016/7/9.
 */
public interface BusinessContract {

    interface Presenter extends BasePresenter {
        /**
         * 设置相关数据,放在bundle中
         */
        void setData(Map<String, Object> map);
    }


    interface UI<T> extends BaseUI {


        void showWaiting();

        void hideWaitingOnError();

        void hideWaitingOnSuccess();

        void onSuccess(T result);

        void onError(Exception exception);
    }





}
