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

import br.edu.ifsp.algunswidgets.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    // Referência para a classe de vinculação de visualizações
    private ActivityMainBinding activityMainBinding;

    private String nomeCompleto;
    private ArrayList<String> estadoCivilList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        //        setContentView(R.layout.activity_main);

        estadoCivilList = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.estado_civil)));
        ArrayAdapter<String> estadoCivilAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, estadoCivilList);
        activityMainBinding.estadoCivilSp.setAdapter(estadoCivilAdapter);

        activityMainBinding.estadoCivilSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int posicao, long id) {
                if (estadoCivilList.get(posicao).equals("Casado(a)")) {
                    activityMainBinding.conjugeLl.setVisibility(View.VISIBLE);
                } else {
                    activityMainBinding.conjugeLl.setVisibility(View.GONE);
                    activityMainBinding.nomeConjugeEt.setText("");
                    activityMainBinding.sobrenomeConjugeEt.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        activityMainBinding.sobrenomeEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                nomeCompleto = activityMainBinding.nomeEt.getText().toString() + " " + charSequence;
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
}