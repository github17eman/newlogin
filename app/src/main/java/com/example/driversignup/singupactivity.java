package com.example.driversignup;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class singupactivity<sigupactivity> extends AppCompatActivity {

    EditText name, address, email, password, code;

    private Button login;
    private  Button signup;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singupactivity);
        name=(EditText) findViewById(R.id.signup_name);
        address = (EditText) findViewById(R.id.signup_address);
        email = (EditText) findViewById(R.id.signup_email);
        password= (EditText) findViewById(R.id.signup_password);
        code= (EditText) findViewById(R.id.signup_code_car);
        login= (Button) findViewById(R.id.login_login);
        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(singupactivity.this, MainActivity.class);
                startActivity(intent);
                finish();


            }
        });


        signup= (Button) findViewById(R.id.signup2_button);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalVariable.name1=name.getText().toString();
                GlobalVariable.addr=address.getText().toString();
                GlobalVariable.em=email.getText().toString();
                GlobalVariable.pass=password.getText().toString();
                GlobalVariable.co=code.getText().toString();

                if (validate(name)&&validate(address)
                        &&validate(email)&&validate(password)&&validate(code)&&pssw(password)&&pssw(code))
                {
                    Toast.makeText(getApplicationContext(),"SuccessFully Register",Toast.LENGTH_LONG).show();
                    if(v.getId()==R.id.signup2_button){
                        Intent intent= new Intent(singupactivity.this,MainActivity.class);
                        startActivity(intent);
                    }

                }
            }
        });
    }



    private boolean validate(EditText editText) {
        if (editText.getText().toString().trim().length() < 1) {
            editText.setError("Please Fill This.!!!");
            editText.requestFocus();
            return false;
        }
        return true;
    }
    private boolean pssw(EditText editText) {
        if (editText.getText().toString().trim().length() < 6) {
            editText.setError("less than 6");
            editText.requestFocus();
            return false;
        }
        return true;
    }

}


