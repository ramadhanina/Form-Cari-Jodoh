package id.sch.smktelkom_mlg.learn.formcarijodoh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama, etUsia;
    TextView tvHasil;
    RadioButton rbWanita, rbPria;

    Button bTampilkan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etUsia = (EditText) findViewById(R.id.editTextUsia);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        rbWanita = (RadioButton) findViewById(R.id.radioButtonWanita);
        rbPria = (RadioButton) findViewById(R.id.radioButtonPria);

        bTampilkan.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              doProcess();
                                          }
                                      }
        );
    }

    private void doProcess() {
        if (isValid()) {
            String Nama = etNama.getText().toString();
            String Usia = etUsia.getText().toString();
            String gender = null;
            tvHasil.setText("Saya " + Nama + " berusia " + Usia + "tahun." + "Saya adalah seorang" + gender + "tulen");
        }
}
    private boolean isValid() {
        boolean valid = true;
        String Nama = etNama.getText().toString();
        String Usia = etUsia.getText().toString();
        String gender = null;

        if (Nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else if (Nama.length() < 3) {
            etNama.setError("Nama minimal 3 karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }
        if (Usia.isEmpty()) {
            etUsia.setError("Usia Anda belum diisi");
            valid = false;
        } else if (Usia.length() != 2) {
            etUsia.setError("Format Usia Anda bukan 2 angka");
            valid = false;
        } else {
            etUsia.setError(null);
        }

        if (rbWanita.isChecked()) {
            gender = rbWanita.getText().toString();
        } else if (rbPria.isChecked()) {
            gender = rbPria.getText().toString();
        }
        if (gender == null) {
            tvHasil.setText("Anda belum menentukan gender");
        } else {
            tvHasil.setText(" Saya adalah seorang " + gender);
        }
        return valid;
    }
}

