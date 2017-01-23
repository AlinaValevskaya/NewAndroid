package com.example.user.assist;

import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LoginActivity extends AppCompatActivity {

    public static final String LOGIN_1 = "LOGIN_1";
    public static final String SETTINGS = "SETTINGS";


    @BindView(R2.id.login) EditText login1;
    @BindView(R2.id.password)EditText pass;
    @BindView(R2.id.button)Button button;

    String loginStr;
    String passStr;
    SharedPreferences mSharedPreferences;


   View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            loginStr = login1.getText().toString();
            passStr = pass.getText().toString();

            if(loginStr.isEmpty() || passStr.isEmpty()){
                Toast.makeText(LoginActivity.this, "Поля не должны быть пустыми", Toast.LENGTH_SHORT).show();
            }
            else
                if(loginStr.length() < 5 || passStr.length() < 5) {

                    Toast.makeText(LoginActivity.this, "Текст должен быть не менее 5 символов", Toast.LENGTH_SHORT).show();

                }else {
                    mSharedPreferences.edit().putString(LOGIN_1,loginStr).apply();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra(Constants.KEY_LOGIN,loginStr);
                    intent.putExtra(Constants.KEY_PASS,passStr);

                 //   Bundle bndl = new Bundle();
                 //   bndl.putString("keyLogin",loginStr);
                  //  bndl.putString("keyPass",passStr);
                 //   intent.putExtras(bndl);

                    startActivity(intent);
                    finish();
                    Toast.makeText(LoginActivity.this, "Авторизация пройдена", Toast.LENGTH_SHORT).show();
                }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        button.setOnClickListener(onClickListener);

        mSharedPreferences = getSharedPreferences(SETTINGS, MODE_PRIVATE);

        String login = mSharedPreferences.getString(LOGIN_1,null);
        if(login!=null){
            login1.setText(login);

        }




    }






}
