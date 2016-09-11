package id.sch.smktelkom_mlg.learn.formcarijodoh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama, etUsia;
    TextView tvHasil;

    Button bTampilkan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etUsia = (EditText) findViewById(R.id.editTextUsia);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        bTampilkan.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              String Nama = etNama.getText().toString();
                                              String Usia = etUsia.getText().toString();
                                              tvHasil.setText("Saya " + Nama + " berusia " + Usia + "tahun");

                                          }
                                      }
        );
    }
}

