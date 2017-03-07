package fri.uniza.sk.lifecycle___;

import android.content.SharedPreferences;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("LifeCycle","Create");
        checkBox = (CheckBox)findViewById(R.id.checkBox);

        SharedPreferences prefReader =
                getPreferences(MODE_PRIVATE);
        Boolean checked =
                prefReader.getBoolean("checkBox",false);
        checkBox.setChecked(checked);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle","Restart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle","Start");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle","Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle","Pause");

        SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
        editor.putBoolean("checkBox", checkBox.isChecked());
        editor.commit();


    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle","Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle","Destroy");
    }

    public void btnClick(View v){
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText("Ahoj Svet!");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView textView = (TextView)findViewById(R.id.textView);
        outState.putCharSequence("textview",textView.getText());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(savedInstanceState.getCharSequence("textview"));

    }
}
