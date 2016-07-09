/**
 * @项目名称: BestMVP
 * @文件名称: LoginUI
 * @Date: 2016/7/9
 * @Copyright: 2016 pageTan All rights reserved.
 * 版权所有：pageTan
 * 注意：使用请注明版权
 */
package tan.page.bestmvp.login.contract;

import tan.page.bestmvp.common.mvp.BusinessContract;
import tan.page.bestmvp.common.mvp.base.BaseUI;
import tan.page.restsdk.dataobject.LoginResult;

/**
 * Created by pageTan on 2016/7/9.
 */
public interface LoginUI extends BusinessContract.UI<LoginResult> {

    void setPresenter(LoginPresenter presenter);

}
