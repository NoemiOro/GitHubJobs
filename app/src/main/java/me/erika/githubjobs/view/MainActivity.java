package me.erika.githubjobs.view;

import androidx.appcompat.app.AppCompatActivity;
import me.erika.githubjobs.R;
import me.erika.githubjobs.model.GitHubJobsDO;
import me.erika.githubjobs.network.GitHubJobsApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
