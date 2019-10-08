package me.erika.githubjobs.model;

import android.util.Log;

import java.util.List;

import me.erika.githubjobs.network.GitHubJobsApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {

    private Callbacks mCallback;

    public void loadData(int page){

        Retrofit retro = new Retrofit.Builder()
                .baseUrl("https://jobs.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubJobsApi service = retro.create(GitHubJobsApi.class);

        final Call<List<GitHubJobsDO>> request = service.jobs(page);

        request.enqueue(new Callback<List<GitHubJobsDO>>() {
            @Override
            public void onResponse(Call<List<GitHubJobsDO>> call, Response<List<GitHubJobsDO>> response) {
                mCallback.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<List<GitHubJobsDO>> call, Throwable t) {
                Log.e("Erika", t.getMessage());
            }
        });

    }

    public void setCallbacks(Callbacks callback){
        mCallback = callback;
    }

    public interface Callbacks{
        void onResponse(List<GitHubJobsDO> response);
        void onFailure(String message);
    }
}
