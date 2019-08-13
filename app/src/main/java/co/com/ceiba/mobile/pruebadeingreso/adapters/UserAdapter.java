package co.com.ceiba.mobile.pruebadeingreso.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.zip.Inflater;

import co.com.ceiba.mobile.pruebadeingreso.contracts.ViewPostListener;
import co.com.ceiba.mobile.pruebadeingreso.model.User;
import co.com.ceiba.mobile.pruebadeingreso.viewHolders.UserViewHolder;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private List<User> users;
    private int layout;
    private ViewPostListener postListener;

    public UserAdapter(List<User> users, int layout, ViewPostListener postListener) {
        this.users = users;
        this.layout = layout;
        this.postListener = postListener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        UserViewHolder viewHolder= new UserViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.onBind(users.get(position),position,this.postListener);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void updateUsersList(List<User> users){
        this.users =users;
        notifyDataSetChanged();
    }
}
