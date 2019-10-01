package me.erika.githubjobs.model;

import android.util.Log;

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

        final Call<GitHubJobsDO> request = service.jobs(page);

        request.enqueue(new Callback<GitHubJobsDO>() {
            @Override
            public void onResponse(Call<GitHubJobsDO> call, Response<GitHubJobsDO> response) {
                mCallback.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<GitHubJobsDO> call, Throwable t) {
                Log.e("Erika", t.getMessage());
            }
        });
    }

    public void setCallbacks(Callbacks callback){
        mCallback = callback;
    }

    public interface Callbacks{
        void onResponse(GitHubJobsDO response);
        void onFailure(String message);
    }
}
