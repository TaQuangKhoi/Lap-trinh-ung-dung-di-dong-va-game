package com.taquangkhoi.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class SignOutActivity extends AppCompatActivity {
    TextView tvwName, tvwAge;
    Button btnSignOut, btnClose;
    GoogleSignInOptions gso;
    GoogleSignInClient googleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_out);

        tvwName = findViewById(R.id.tvwName);
        tvwAge = findViewById(R.id.tvwAge);

        btnClose = findViewById(R.id.btnClose);
        btnSignOut = findViewById(R.id.btnSignOut);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if (account != null) {
            tvwName.setText(account.getDisplayName());
            tvwAge.setText(account.getEmail());
        }

        btnSignOut.setOnClickListener(v -> {
            googleSignInClient.signOut();
            finish();
            startActivity(new Intent(this, MainActivity.class));
        });

        btnClose.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        });
    }
}