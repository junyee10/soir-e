package com.example.omamalin.sghackathon;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInActivity extends AppCompatActivity {
    EditText e1,e2;
    FirebaseAuth auth;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        dialog= new ProgressDialog(this);


        auth=FirebaseAuth.getInstance();



        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        /*if(user!=null)
        {
            Toast.makeText(getApplicationContext(),"User Already Signed in",Toast.LENGTH_LONG).show();
        }
        */
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
    }

    public void sign_in(View v)
    {
        String email= e1.getText().toString();
        String password=e2.getText().toString();
        dialog.setMessage("Signing in..");
        dialog.show();

        auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            dialog.dismiss();
                            Toast.makeText(getApplicationContext(),"User found and now signed in",Toast.LENGTH_LONG).show();
                            Intent i=new Intent (SignInActivity.this,main_profile.class);
                            startActivity(i);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"User not found",Toast.LENGTH_LONG);
                        }
                    }
                });


    }
    public void open_register(View v) {
        Intent i = new Intent(SignInActivity.this, MainActivity.class);
        startActivity(i);
    }

}
