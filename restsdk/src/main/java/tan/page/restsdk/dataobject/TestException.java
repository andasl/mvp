/**
 * @项目名称: BestMVP
 * @文件名称: TestException
 * @Date: 2016/7/9
 * @Copyright: 2016 pageTan All rights reserved.
 * 版权所有：pageTan
 * 注意：使用请注明版权
 */
package tan.page.restsdk.dataobject;

/**
 * 用于测试的exception
 * Created by pageTan on 2016/7/9.
 */
public class TestException extends Exception {

    public TestException(){
        super("is test exception");
    }

    public TestException(String message) {
        super(message);
    }
}
