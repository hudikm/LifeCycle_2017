package fri.uniza.sk.lifecycle___;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("LifeCycle", "Create");
        checkBox = (CheckBox) findViewById(R.id.checkBox);

        SharedPreferences prefReader =
                getPreferences(MODE_PRIVATE);
        Boolean checked =
                prefReader.getBoolean("checkBox", false);
        checkBox.setChecked(checked);
        ((Button) findViewById(R.id.button2)).setOnClickListener(this);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle", "Restart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle", "Start");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle", "Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle", "Pause");

        SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
        editor.putBoolean("checkBox", checkBox.isChecked());
        editor.commit();


    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle", "Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle", "Destroy");
    }

    public void btnClick(View v) {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Ahoj Svet!");
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("key", "Ahoj!");
        startActivityForResult(intent, 222);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String text = data.getExtras().getString("key");
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView textView = (TextView) findViewById(R.id.textView);
        outState.putCharSequence("textview", textView.getText());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(savedInstanceState.getCharSequence("textview"));

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button2) {
            EditText searchTxt = (EditText) findViewById(R.id.editText);
            Uri uri = Uri.parse("http://www.google.com/#q=" +
                    searchTxt.getText().toString());

            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);

        }
    }
}
