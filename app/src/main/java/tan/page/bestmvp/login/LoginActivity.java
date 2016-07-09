package tan.page.bestmvp.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.dd.CircularProgressButton;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import tan.page.bestmvp.R;
import tan.page.bestmvp.common.activity.BaseActivity;
import tan.page.bestmvp.common.mvp.BusinessContract;
import tan.page.bestmvp.common.util.KeyConstans;
import tan.page.bestmvp.content.ListActivity;
import tan.page.bestmvp.login.contract.LoginPresenter;
import tan.page.bestmvp.login.contract.LoginUI;
import tan.page.bestmvp.login.contract.impl.LoginPresenterImpl;
import tan.page.restsdk.dataobject.LoginResult;

public class LoginActivity extends BaseActivity implements LoginUI {

    @BindView(R.id.loginPassWordEditText)
    EditText loginPassWordEditText;
    @BindView(R.id.loginNameEditText)
    EditText loginNameEditText;

    @BindView(R.id.loginButton)
    CircularProgressButton loginButton;

    @BindView(R.id.loginErrorTextView)
    TextView loginErrorTextView;


    private LoginPresenter loginPresenter;



    private Handler handler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        loginPresenter = new LoginPresenterImpl(this);


        loginButton.setIndeterminateProgressMode(true);
        loginButton.setProgress(CircularProgressButton.IDLE_STATE_PROGRESS);


        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                Intent intent = new Intent(LoginActivity.this, ListActivity.class);
                startActivity(intent);
                return false;
            }
        });
    }
    @OnClick(R.id.loginButton)
    public void login(){
        String userName = loginNameEditText.getText().toString();
        String passWord = loginPassWordEditText.getText().toString();
        Map<String ,Object> valuesMap = new HashMap<>();
        valuesMap.put(KeyConstans.KEY_LOGIN_USER_NAME, userName);
        valuesMap.put(KeyConstans.KEY_LOGIN_PASS_WORD, passWord);
        loginPresenter.setData(valuesMap);
        loginPresenter.login();
    }



    @Override
    public void showWaiting() {
        loginButton.setProgress(CircularProgressButton.INDETERMINATE_STATE_PROGRESS);
    }

    @Override
    public void hideWaitingOnError() { // 目前状态有问题
        loginButton.setProgress(CircularProgressButton.ERROR_STATE_PROGRESS);
    }

    @Override
    public void hideWaitingOnSuccess() {
        try{
            loginButton.setProgress(CircularProgressButton.SUCCESS_STATE_PROGRESS);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onSuccess(LoginResult result) {
        handler.sendEmptyMessageDelayed(0, 1000);
    }


    @Override
    public void onError(Exception exception) {
        loginErrorTextView.setText(exception.getMessage());
    }


    @Override
    public void setPresenter(LoginPresenter presenter) {

    }
}
