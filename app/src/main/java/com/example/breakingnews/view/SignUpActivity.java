package com.example.breakingnews.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.breakingnews.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class SignUpActivity extends AppCompatActivity
{
    TextInputEditText mUserEditText;
    MaterialButton mSignUpButton;
    SharedPreferences mPrefs;
    SharedPreferences.Editor mEditor;

    boolean mRegisteration;
    private final static String USER_NAME = "UserName";
    private final static String REGISTRATION = "Registration";
    @Override
    protected void onCreate(android.os.Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mPrefs = getSharedPreferences(getApplicationInfo().packageName, Context.MODE_PRIVATE);
        mEditor = mPrefs.edit();

        mRegisteration =  mPrefs.getBoolean(REGISTRATION, false);
        if(mRegisteration)
        {
            Intent lIntent = new Intent(this, MainActivity.class);
            finish();
            startActivity(lIntent);
        }
        setContentView(R.layout.activity_signup);
        initialization();
    }

    private void initialization()
    {
        mUserEditText = findViewById(R.id.signup_username);
        mSignUpButton = findViewById(R.id.button);

        mSignUpButton.setOnClickListener(view -> SignUpActivity.this.onClick());
    }

    public void onClick()
    {
        if(mUserEditText.getText() == null ||
                mUserEditText.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Please Provide User Name",Toast.LENGTH_SHORT).show();
        }else{
            mEditor.putString(USER_NAME, mUserEditText.getText().toString());
            mEditor.putBoolean(REGISTRATION, true);
            mEditor.commit();
            Intent lIntent = new Intent(this, MainActivity.class);
            finish();
            startActivity(lIntent);
        }
    }
}
