/**
 * @项目名称: BestMVP
 * @文件名称: LoginResult
 * @Date: 2016/7/9
 * @Copyright: 2016 pageTan All rights reserved.
 * 版权所有：pageTan
 * 注意：使用请注明版权
 */
package tan.page.restsdk.dataobject;

/**
 * 登录返回的结果
 * Created by pageTan on 2016/7/9.
 */
public class LoginResult {


    private boolean isSuccess;


    public void setSuccess(boolean isSuccess){
        this.isSuccess = isSuccess;
    }

    public boolean isSuccess(){
        return isSuccess;
    }
}
