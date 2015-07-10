package com.walletcircle.jsonlocalizationdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.walletcircle.jsonlocalization.JsonLocalization;

public class MainActivity extends Activity {

    private String jsonString = "{\"en\":{\"NAME\":\"English Name\"},\"nl\":{\"NAME\":\"Dutch Name\"}}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String key = "NAME";
        JsonLocalization.getInstance().loadFromData(this.jsonString);
        String localizedName = JsonLocalization.getInstance().stringForKey(key);
        Log.d("JsonLocaliztion", localizedName);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Localized Name : " + localizedName);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
