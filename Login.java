package com.example.dellpc.smartvillage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.ContentResolver;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class Login extends AppCompatActivity  {
    Button b1;
    Button b2;
    TextView forgot;
    private static EditText username;
    private static EditText password;
    private static TextView attempt;
    private static Button login_button;
    int attempt_counter=5;
    String e1,p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        b1 = (Button) findViewById(R.id.btnSubmit);
        b2 = (Button) findViewById(R.id.btn_sign);
        LoginButton();


        b2.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      //Toast.makeText(getBaseContext(), "success", Toast.LENGTH_LONG).show();//to print message
                                      Intent i = new Intent(Login.this, Sign_Up.class);//to move from one activity to another
                                      startActivity(i);
                                  }
                              }
        );
    }
    public void LoginButton(){
        username = (EditText)findViewById(R.id.txtEmail);
        password = (EditText)findViewById(R.id.txtPwd);
        e1  = username.getText().toString();
        p  = password.getText().toString();
        b1.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (username.getText().toString().equals("@") &&
                                password.getText().toString().equals("rupali"))
                        {
                            Intent i = new Intent(Login.this, Home.class);
                            Bundle b=new Bundle();

                            b.putString("email",username.getText().toString());

                            i.putExtras(b);
                            startActivity(i);

                        }
                        else {
                            Toast.makeText(Login.this,"Username and password is NOT correct",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                }
        );

    }
}

