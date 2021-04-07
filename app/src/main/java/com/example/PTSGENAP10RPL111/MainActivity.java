package com.example.PTSGENAP10RPL111;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    CallbackManager mCallbackManager;
    LoginButton loginButton;
    private FirebaseAuth mAuth;
    // kita list semua object view yang sudah kita buat di layout
    // hanya dikenakan oprasi
    EditText txtemail;
    EditText txtpassword;
    Button btnlogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialise facebook SDK
        FacebookSdk.sdkInitialize(MainActivity.this);
        mAuth = FirebaseAuth.getInstance();
        // kita sambungkan ke layout
        txtemail = (EditText)findViewById(R.id.email);
        txtpassword = (EditText)findViewById(R.id.password);
        btnlogin = (Button)findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // aksi disini
                String email = txtemail.getText().toString();
                String password = txtpassword.getText().toString();
                if (email.equalsIgnoreCase("firosyanammar@gmail.com")
                        && password.equalsIgnoreCase("elek123098")){
                    //sukses login, Toast
                    Toast.makeText(MainActivity.this, "Sukses Login", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Gagal Login !", Toast.LENGTH_SHORT).show();
                }

            }
        });
        // Initialize Facebook Login button
        mCallbackManager = CallbackManager.Factory.create();
        loginButton = findViewById(R.id.login_button);
        loginButton.setReadPermissions("email", "public_profile");
        loginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {;
                handleFacebookAccessToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {
            }
        });
    }
        private void handleFacebookAccessToken(AccessToken token) {
            AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
            mAuth.signInWithCredential(credential)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();
                                updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(MainActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                                updateUI(null);
                            }
                        }
                    });
        }

    private void updateUI(FirebaseUser user) {
        if (user != null){
        Intent intent = new Intent(MainActivity.this, SuccesLogin.class);
        startActivity(intent);
        }else{
            Toast.makeText(this, "Please Sign In To Continue", Toast.LENGTH_SHORT).show();
        }
    }
}

