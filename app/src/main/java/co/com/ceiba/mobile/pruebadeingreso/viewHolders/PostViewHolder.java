package co.com.ceiba.mobile.pruebadeingreso.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.model.Post;

public class PostViewHolder extends RecyclerView.ViewHolder {

    private TextView tvTitle, tvBody;

    public PostViewHolder(View itemView) {
        super(itemView);
        this.tvTitle = itemView.findViewById(R.id.title);
        this.tvBody = itemView.findViewById(R.id.body);
    }

    public void bindData(final Post post){
        this.tvTitle.setText(post.getTitle());
        this.tvBody.setText(post.getBody());
    }
}
