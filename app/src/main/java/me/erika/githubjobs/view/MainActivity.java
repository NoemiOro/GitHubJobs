package me.erika.githubjobs.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import me.erika.githubjobs.R;
import me.erika.githubjobs.model.GitHubJobsDO;
import me.erika.githubjobs.network.GitHubJobsApi;
import me.erika.githubjobs.viewmodel.GitHubJobsViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int page=1;

        GitHubJobsViewModel mModel = ViewModelProviders.of(this).get(GitHubJobsViewModel.class);

        if(savedInstanceState == null){
            mModel.init();
            mModel.loadGitHubJobs(page).observe(this, mObserver);
        }
        else{
           //load data from viewModel without retrieving info from server again
            // TODO Change liveDataObject for cached liveDataObject
            mModel.cachedList();
        }

    }

    private Observer<List<GitHubJobsDO>> mObserver = new Observer<List<GitHubJobsDO>>() {
        @Override
        public void onChanged(List<GitHubJobsDO> gitHubJobsDOS) {
            Log.v("Erika", gitHubJobsDOS.toString());
        }
    } ;
}
