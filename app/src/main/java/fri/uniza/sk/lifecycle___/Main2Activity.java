package fri.uniza.sk.lifecycle___;

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
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();

        findViewById(R.id.button3).setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("resultData", "Result sata from Main2Activity");
            setResult(RESULT_OK, intent);
            finish();
        });

    }


}
