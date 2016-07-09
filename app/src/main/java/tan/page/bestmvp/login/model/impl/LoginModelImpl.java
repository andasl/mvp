/**
 * @项目名称: BestMVP
 * @文件名称: LoginModelImpl
 * @Date: 2016/7/9
 * @Copyright: 2016 pageTan All rights reserved.
 * 版权所有：pageTan
 * 注意：使用请注明版权
 */
package tan.page.bestmvp.login.model.impl;

import java.util.concurrent.Callable;

import bolts.Continuation;
import bolts.Task;
import tan.page.bestmvp.common.mvp.ModelCallback;
import tan.page.bestmvp.login.model.LoginModel;
import tan.page.restsdk.dataobject.LoginResult;
import tan.page.restsdk.mokeutil.LoginUtil;

/**
 * 登录的model
 * Created by pageTan on 2016/7/9.
 */
public class LoginModelImpl implements LoginModel {
    @Override
    public void login(final String userName, final String passWord, final ModelCallback<LoginResult> modelCallback) {
        Task.callInBackground(new Callable<LoginResult>() {
            @Override
            public LoginResult call() throws Exception {
                Thread.sleep(3000);
//                LoginUtil.loginFaild(userName, passWord);
//                return null;
                LoginResult loginResult = LoginUtil.loginSuccess(userName,passWord);
//                 //do someting to save or another
                return loginResult;
            }
        }).continueWith(new Continuation<LoginResult, Void>() {
            @Override
            public Void then(Task<LoginResult> task) throws Exception {

                if (task.isFaulted()) {
                    modelCallback.onError(task.getError());
                }else {
                    modelCallback.onSuccess(task.getResult());
                }

                return null;
            }
        },Task.UI_THREAD_EXECUTOR);
    }
}
