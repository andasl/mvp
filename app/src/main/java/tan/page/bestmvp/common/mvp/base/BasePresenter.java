/**
 * @项目名称: BestMVP
 * @文件名称: BasePresenter
 * @Date: 2016/7/9
 * @Copyright: 2016 pageTan All rights reserved.
 * 版权所有：pageTan
 * 注意：使用请注明版权
 */
package tan.page.bestmvp.common.mvp.base;

import android.content.Context;

/**
 * Created by pageTan on 2016/7/9.
 */
public interface BasePresenter {
    void start();

    void setContext(Context context);
}
