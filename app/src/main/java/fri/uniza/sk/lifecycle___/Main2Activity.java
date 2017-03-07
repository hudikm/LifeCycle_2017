package fri.uniza.sk.lifecycle___;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String string = getIntent().getExtras().getString("key");
        Toast.makeText(this, string,Toast.LENGTH_SHORT).show();
        setResult(Activity.RESULT_OK,new Intent().putExtra("key","Data"));
        finish();
    }

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        finish();
//    }
}
