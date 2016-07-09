/**
 * @项目名称: BestMVP
 * @文件名称: LoginPresenterImpl
 * @Date: 2016/7/9
 * @Copyright: 2016 pageTan All rights reserved.
 * 版权所有：pageTan
 * 注意：使用请注明版权
 */
package tan.page.bestmvp.login.contract.impl;

import android.content.Context;
import android.text.TextUtils;

import java.util.Map;

import tan.page.bestmvp.common.mvp.BusinessContract;
import tan.page.bestmvp.common.mvp.ModelCallback;
import tan.page.bestmvp.common.util.KeyConstans;
import tan.page.bestmvp.common.util.NetworkUtil;
import tan.page.bestmvp.login.contract.LoginUI;
import tan.page.bestmvp.login.model.LoginModel;
import tan.page.bestmvp.login.contract.LoginPresenter;
import tan.page.bestmvp.login.model.impl.LoginModelImpl;
import tan.page.restsdk.dataobject.LoginResult;
import tan.page.restsdk.dataobject.TestException;

/**
 * Created by pageTan on 2016/7/9.
 */
public class LoginPresenterImpl implements LoginPresenter, ModelCallback<LoginResult> {


    private Context context;

    private String userName;
    private String passWord;

    private BusinessContract.UI<LoginResult> ui;
    private LoginModel loginModel;

    public LoginPresenterImpl(LoginUI  ui) {
        ui.setPresenter(this);
        this.ui = ui;
        this.loginModel = new LoginModelImpl();
    }




    @Override
    public void login() {
        if (!NetworkUtil.isConnected()) {
            ui.onError(new TestException("network not connect"));
            return;
        }

        if (TextUtils.isEmpty(userName)) {
            ui.onError(new TestException("passWord is null"));
            return;
        }
        if (TextUtils.isEmpty(passWord)) {
            ui.onError(new TestException("passWord is null"));
            return;
        }
        ui.showWaiting();
        loginModel.login(userName, passWord, this);

    }


    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public void setData(Map<String, Object> map) {
        userName = (String) map.get(KeyConstans.KEY_LOGIN_USER_NAME);
        passWord = (String) map.get(KeyConstans.KEY_LOGIN_PASS_WORD);
    }

    @Override
    public void start() { // 在activity的onResume中调用
        // do nothing
    }


    @Override
    public void onSuccess(LoginResult result) {
        ui.hideWaitingOnSuccess();
        ui.onSuccess(result);
    }

    @Override
    public void onError(Exception exception) {
        ui.hideWaitingOnError();
        ui.onError(exception);
    }
}
