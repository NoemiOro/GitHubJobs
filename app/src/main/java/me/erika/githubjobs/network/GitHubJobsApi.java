package me.erika.githubjobs.network;

import me.erika.githubjobs.model.GitHubJobsDO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GitHubJobsApi {

    @GET("positions.json")
    Call<GitHubJobsDO> jobs(@Query("page")int page);
}
