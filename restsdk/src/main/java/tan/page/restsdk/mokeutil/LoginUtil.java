/**
 * @项目名称: BestMVP
 * @文件名称: LoginUtil
 * @Date: 2016/7/9
 * @Copyright: 2016 pageTan All rights reserved.
 * 版权所有：pageTan
 * 注意：使用请注明版权
 */
package tan.page.restsdk.mokeutil;

import junit.framework.Test;

import tan.page.restsdk.dataobject.LoginResult;
import tan.page.restsdk.dataobject.TestException;

/**
 * Created by pageTan on 2016/7/9.
 */
public class LoginUtil {


    public static LoginResult loginSuccess(String userName, String passWord) {
        LoginResult loginResult = new LoginResult();
        loginResult.setSuccess(true);
        return loginResult;
    }


    public static LoginResult loginFaild(String userName, String passWord) throws TestException {
        LoginResult loginResult = new LoginResult();
        loginResult.setSuccess(false);
        throw new TestException();
    }

}
