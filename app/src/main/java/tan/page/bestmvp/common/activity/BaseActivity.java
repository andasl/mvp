/**
 * @项目名称: BestMVP
 * @文件名称: BaseActivity
 * @Date: 2016/7/7
 * @Copyright: 2016 pageTan All rights reserved.
 * 版权所有：pageTan
 * 注意：使用请注明版权
 */
package tan.page.bestmvp.common.activity;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by pageTan on 2016/7/7.
 */
public class BaseActivity extends AppCompatActivity {


    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        bind();

    }

    protected final void bind(){
        ButterKnife.bind(this);
    }


}
