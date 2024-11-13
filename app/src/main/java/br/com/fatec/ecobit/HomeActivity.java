package br.com.fatec.ecobit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    private Button btnContatos, btnPerfil, btnAddProd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        btnContatos = findViewById(R.id.btnContatos);

        btnPerfil = findViewById(R.id.btnPerfil);

        btnAddProd = findViewById(R.id.btnAddProd);

        btnAddProd.setOnClickListener(view -> {
            startActivity(new Intent(this, ProdRegisterActivity.class));
        });

        btnContatos.setOnClickListener(view -> {
            startActivity(new Intent(this, ContatosActivity.class));
        });

        btnPerfil.setOnClickListener(view ->{
            startActivity(new Intent(this, MyAccountActivity.class));
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Ciclo de vida", "onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Ciclo de vida", "onResume");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Ciclo de vida", "onStop");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo de vida", "onRestart");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo de vida", "onDestroy");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de vida", "onPause");

    }
}