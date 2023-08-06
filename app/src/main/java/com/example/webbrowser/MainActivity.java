package com.example.webbrowser;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText urlEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        urlEditText = findViewById(R.id.urlEditText);
    }

    public void openWebFragment(View view) {
        String websiteUrl = urlEditText.getText().toString().trim();

        if (!websiteUrl.isEmpty()) {
            // Creo un nuevo fragmento y paso la dirección del sitio web como argumento
            webFragment webFragment = new webFragment();
            Bundle args = new Bundle();
            args.putString("websiteUrl", websiteUrl);
            webFragment.setArguments(args);

            // Reemplazar el fragmento actual con el fragmento WebFragment
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, webFragment)
                    .commit();
        } else {
            Toast.makeText(this, "Ingresa una dirección de sitio web válida", Toast.LENGTH_SHORT).show();
        }
    }
}
