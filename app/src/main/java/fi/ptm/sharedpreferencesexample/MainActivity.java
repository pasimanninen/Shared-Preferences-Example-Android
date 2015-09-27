package fi.ptm.sharedpreferencesexample;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by PTM on 27/09/15.
 */
public class MainActivity extends Activity {
    private final String PREFS_NAME = "MY_PREFERENCES";
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // restore preferences
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        count = settings.getInt("count", 0);
        count++;
        // show launching count in text view
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("This app is launched " +count + " times.");
    }

    @Override
    protected void onStop(){
        super.onStop();

        // save launching count number to shared preferences
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("count", count);
        // commit the edits
        editor.commit();
    }
}
