package tan.page.bestmvp.content;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import butterknife.BindView;
import tan.page.bestmvp.R;

public class ListActivity extends AppCompatActivity {


    @BindView(R.id.listView)
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }
}
