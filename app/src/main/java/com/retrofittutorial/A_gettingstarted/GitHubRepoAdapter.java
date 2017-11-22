package com.retrofittutorial.A_gettingstarted;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.retrofittutorial.R;

import java.util.List;

/**
 * Created by INFYZO\shailesh.pateliya on 21/11/17.
 */

public class GitHubRepoAdapter extends ArrayAdapter<GitHubRepo> {
    private Context context;
    private List<GitHubRepo> values;
    public GitHubRepoAdapter(Context context,List<GitHubRepo> values) {
        super(context, R.layout.list_item_githubrepo, values);
        this.context = context;
        this.values = values;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        GitHubRepo repo = values.get(position);
        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.list_item_githubrepo, parent, false);
        }
        TextView name = (TextView)row.findViewById(R.id.name);
        name.setText(repo.getName());
        return row;
    }
}
