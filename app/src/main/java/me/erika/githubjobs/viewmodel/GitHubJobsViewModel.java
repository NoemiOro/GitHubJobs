package me.erika.githubjobs.viewmodel;

import android.util.Log;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import me.erika.githubjobs.model.GitHubJobsDO;
import me.erika.githubjobs.model.Repository;

public class GitHubJobsViewModel extends ViewModel {

    MutableLiveData<List <GitHubJobsDO>> mGitHubJobsDOMutableLiveData;
    Repository repo;


    public void init(){
        mGitHubJobsDOMutableLiveData = new MutableLiveData<>();
        repo = new Repository();
        repo.setCallbacks(mCallbacks);
    }



    private Repository.Callbacks mCallbacks = new Repository.Callbacks() {
        @Override
        public void onResponse(List<GitHubJobsDO> response) {
            mGitHubJobsDOMutableLiveData.postValue(response);
        }

        @Override
        public void onFailure(String message) {
            Log.e("Erika", "onFailure: "+ message);
        }
    };

    public LiveData<List<GitHubJobsDO>> loadGitHubJobs(int page){
        repo.loadData(page);
        return mGitHubJobsDOMutableLiveData;
    }

    public LiveData<List<GitHubJobsDO>> cachedList(){
        //TODO Change liveDataObject for cached liveDataObject
        return mGitHubJobsDOMutableLiveData;
    }

}
