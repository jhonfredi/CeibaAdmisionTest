package co.com.ceiba.mobile.pruebadeingreso.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.contracts.ViewPostListener;
import co.com.ceiba.mobile.pruebadeingreso.model.User;

public class UserViewHolder extends RecyclerView.ViewHolder {

    private TextView etName,etPhone,etEmail;
    private Button btnViewPost;


    public UserViewHolder(View itemView) {
        super(itemView);
        this.etName=itemView.findViewById(R.id.name);
        this.etPhone=itemView.findViewById(R.id.phone);
        this.etEmail=itemView.findViewById(R.id.email);
        this.btnViewPost = itemView.findViewById(R.id.btn_view_post);

    }

    public void onBind(final User user, final int position, final ViewPostListener postListener){

        this.etName.setText(user.getName());
        this.etPhone.setText(user.getPhone());
        this.etEmail.setText(user.getEmail());

        this.btnViewPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postListener.onClickListener(user,position);
            }
        });

    }
}
