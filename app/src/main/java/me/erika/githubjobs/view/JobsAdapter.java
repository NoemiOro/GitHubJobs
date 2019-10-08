package me.erika.githubjobs.view;


import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class JobsAdapter extends  RecyclerView.Adapter<JobsAdapter.JobsViewHolder>{

    @NonNull
    @Override
    public JobsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull JobsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class JobsViewHolder extends RecyclerView.ViewHolder {
        public JobsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
