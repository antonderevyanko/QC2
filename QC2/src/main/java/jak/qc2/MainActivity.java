package jak.qc2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.AbsListView;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        final MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);
        listView.setFastScrollEnabled(false);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                myAdapter.setAnimate(scrollState == SCROLL_STATE_FLING || SCROLL_STATE_TOUCH_SCROLL == scrollState);
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            }

        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
