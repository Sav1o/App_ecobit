package br.com.fatec.ecobit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class EmailContactActivity extends AppCompatActivity {

    private EditText edtSubject;
    private EditText edtMessage;
    private Button btnSendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_email);

        edtSubject = findViewById(R.id.Assunto);
        edtMessage = findViewById(R.id.Mensagem);
        btnSendEmail = findViewById(R.id.btnEnviar);

        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toEmail = "Ecobit.suporte@gmail.com"; // Email fixo
                String subject = edtSubject.getText().toString().trim();
                String message = edtMessage.getText().toString().trim();

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:" + toEmail));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                emailIntent.putExtra(Intent.EXTRA_TEXT, message);

                try {
                    startActivity(Intent.createChooser(emailIntent, "Escolha o app de e-mail"));
                } catch (android.content.ActivityNotFoundException e) {
                    Toast.makeText(EmailContactActivity.this, "Nenhum app de e-mail encontrado.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
