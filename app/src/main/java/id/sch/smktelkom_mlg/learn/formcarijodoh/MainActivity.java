package id.sch.smktelkom_mlg.learn.formcarijodoh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama, etUsia;
    TextView tvHasil;
    RadioButton rbWanita, rbPria;
    RadioGroup rgGender;
    CheckBox cbRomantis, cbAlim, cbHumoris, cbSetia, cbSerius, cbBerkarir;
    Spinner spPengalaman;
    Button bTampilkan;

    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etUsia = (EditText) findViewById(R.id.editTextUsia);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        rbWanita = (RadioButton) findViewById(R.id.radioButtonWanita);
        rbPria = (RadioButton) findViewById(R.id.radioButtonPria);
        rgGender = (RadioGroup) findViewById(R.id.radioGroupGender);
        cbRomantis = (CheckBox) findViewById(R.id.checkBoxRomantis);
        cbAlim = (CheckBox) findViewById(R.id.checkBoxAlim);
        cbHumoris = (CheckBox) findViewById(R.id.checkBoxHumoris);
        cbSetia = (CheckBox) findViewById(R.id.checkBoxSetia);
        cbSerius = (CheckBox) findViewById(R.id.checkBoxSerius);
        cbBerkarir = (CheckBox) findViewById(R.id.checkBoxBerkarir);
        spPengalaman = (Spinner) findViewById(R.id.spinnerpengalaman);
        )

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
            String tipe = "Tipe Pasangan Saya adalah ";
            tvHasil.setText("Saya " + Nama + " berusia " + Usia + "tahun." + "Saya adalah seorang" + gender + "tulen, " + tipe + ".Pengalaman pahit yang pernah saya alami adalah" + spPengalaman.getSelectedItem().toString());
        }
}
    private boolean isValid() {
        boolean valid = true;
        String Nama = etNama.getText().toString();
        String Usia = etUsia.getText().toString();
        String gender = null;
        String tipe = "Tipe Pasangan Saya adalah ";
        int startlen = tipe.length();

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

        if (rgGender.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgGender.getCheckedRadioButtonId());
            gender = rb.getText().toString();
        }
        if (gender == null) {
            tvHasil.setText("Anda belum menentukan gender");
        } else {
            tvHasil.setText(" Saya adalah seorang " + gender);
        }
        if (cbRomantis.isChecked()) tipe += cbRomantis.getText();
        if (cbAlim.isChecked()) tipe += cbAlim.getText();
        if (cbHumoris.isChecked()) tipe += cbHumoris.getText();
        if (cbSetia.isChecked()) tipe += cbSetia.getText();
        if (cbSerius.isChecked()) tipe += cbSerius.getText();
        if (cbBerkarir.isChecked()) tipe += cbBerkarir.getText();

        if (tipe.length() == startlen) tipe += "Tidak ada pada Pilihan";
        tvHasil.setText(tipe);
        return valid;
    }
}

