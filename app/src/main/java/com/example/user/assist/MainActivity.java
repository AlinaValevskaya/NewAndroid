package com.example.user.assist;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.assist.model.Auth;
import com.example.user.assist.model.Theme;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "";

    MyAdapter adapter;
    Dialog dialog;
    Retrofit retrofit;

    interface AssistApi{
        @POST ("/auth")
        Call<Object> auth (Auth auth);
        @GET ("/themes")
        Call<Object> themes (@Query("token") String token);

    }

    MyAdapter.OnClickCallBack callBack = new MyAdapter.OnClickCallBack() {
        @Override
        public void clickElement(int id){

            Toast.makeText(MainActivity.this, "Запись была удалена", Toast.LENGTH_SHORT).show();

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.add_theme:
                dialog.show();
                //some action
        break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getIntent().getStringExtra(Constants.KEY_LOGIN);
        getIntent().getStringExtra(Constants.KEY_PASS);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RV);
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);

        adapter = new MyAdapter(callBack);




        final EditText themeEditText=new EditText(this);

        DialogInterface.OnClickListener okClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String theme = themeEditText.getText().toString();

                Log.d(TAG,"onclick:"+theme);

                Theme newTheme = new Theme();
                newTheme.setName(theme);
                newTheme.save();
                Toast.makeText(MainActivity.this, "Тема добавлена", Toast.LENGTH_SHORT).show();

                ArrayList<Theme>themes =(ArrayList<Theme>) SQLite.select().from(Theme.class).queryList();

                adapter.setArr(themes);

                //Запись в базу данных и обновление adapter
            }
        };
        dialog = new AlertDialog.Builder(this).setTitle ("Введите тему")
                .setMessage("Введите тему для тестирования")
                .setView(themeEditText)
                .setPositiveButton("Ok",okClickListener)
                .setNegativeButton("Отмена",null)
                .create();

        recyclerView.setLayoutManager(llm);

        recyclerView.setAdapter(adapter);

       // ArrayList<String> arrayList = new ArrayList<>();
      //  arrayList.add("Текст");
       // adapter.setArr(arrayList);
    }
}
