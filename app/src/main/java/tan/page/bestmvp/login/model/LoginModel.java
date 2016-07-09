/**
 * @项目名称: BestMVP
 * @文件名称: LoginModel
 * @Date: 2016/7/9
 * @Copyright: 2016 pageTan All rights reserved.
 * 版权所有：pageTan
 * 注意：使用请注明版权
 */
package tan.page.bestmvp.login.model;

import tan.page.bestmvp.common.mvp.ModelCallback;
import tan.page.restsdk.dataobject.LoginResult;

/**
 * Created by pageTan on 2016/7/9.
 */
public interface LoginModel {

    void login(String userName, String passWord, ModelCallback<LoginResult> modelCallback);


}
