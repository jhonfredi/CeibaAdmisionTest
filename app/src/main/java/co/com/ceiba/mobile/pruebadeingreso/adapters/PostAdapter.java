package co.com.ceiba.mobile.pruebadeingreso.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.model.Post;
import co.com.ceiba.mobile.pruebadeingreso.viewHolders.PostViewHolder;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    private int layout;
    private List<Post> post;

    public PostAdapter(int layout, List<Post> post) {
        this.layout = layout;
        this.post = post;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        PostViewHolder viewHolder= new PostViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.bindData(post.get(position));
    }

    @Override
    public int getItemCount() {
        return post.size();
    }
}
