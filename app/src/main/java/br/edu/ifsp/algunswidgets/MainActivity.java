package br.edu.ifsp.algunswidgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private EditText nomeEt;
    private EditText sobrenomeEt;
    private EditText emailEt;
    private EditText nomeConjugeEt;
    private EditText sobrenomeConjugeEt;
    private Spinner estadoCivilSp;
    private LinearLayout conjugeLl;
    private RadioGroup sexoRg;
    private RadioButton masculinoRb;

    private String nomeCompleto;

    private ArrayList<String> estadoCivilList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        estadoCivilList = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.estado_civil)));
        ArrayAdapter<String> estadoCivilAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, estadoCivilList);
        estadoCivilSp.setAdapter(estadoCivilAdapter);

        estadoCivilSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int posicao, long id) {
                if (estadoCivilList.get(posicao).equals("Casado(a)")) {
                    conjugeLl.setVisibility(View.VISIBLE);
                } else {
                    conjugeLl.setVisibility(View.GONE);
                    nomeConjugeEt.setText("");
                    sobrenomeConjugeEt.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sobrenomeEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                nomeCompleto = nomeEt.getText().toString() + " " + charSequence;
                Toast.makeText(getBaseContext(), nomeCompleto, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void onClick(View view) {
        if (view.getId() == R.id.salvarBt) {
            Toast.makeText(this, "Botão salvar foi clicado", Toast.LENGTH_SHORT).show();
        } else {
            if (view.getId() == R.id.limparBt) {
                Toast.makeText(this, "Botão limpar foi clicado", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void bindViews() {
        nomeEt = findViewById(R.id.nomeEt);
        sobrenomeEt = findViewById(R.id.sobrenomeEt);
        emailEt = findViewById(R.id.emailEt);
        nomeConjugeEt = findViewById(R.id.nomeConjugeEt);
        sobrenomeConjugeEt = findViewById(R.id.sobrenomeConjugeEt);
        estadoCivilSp = findViewById(R.id.estadoCivilSp);
        conjugeLl = findViewById(R.id.conjugeLl);
        sexoRg = findViewById(R.id.sexoRg);
        masculinoRb = findViewById(R.id.masculinoRb);
    }
}