package com.arun.samplerecycle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.security.acl.Owner;
import java.util.ArrayList;

public class OwnerAdapter extends RecyclerView.Adapter<OwnerAdapter.OwnerViewHolder> {
    private ValueEventListener mCtx;
    private ArrayList<Owner> owners;
    Context context;
    DatabaseReference reference;

    OwnerAdapter(Context context, ArrayList<Owner> itemList)
    {
        this.context = context;
        owners = itemList;
    }

    @NonNull
    @Override
    public OwnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater=LayoutInflater.from((Context) context);
        View view=layoutInflater.inflate(R.layout.admin_accept_cardview,null);
        return new OwnerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OwnerViewHolder holder, final int position)
    {
        holder.t1.setText(owners.get(position).getOwnerName());
        holder.t2.setText(owners.get(position).getShopName());
        holder.t3.setText(owners.get(position).getShopID());
        holder.t4.setText(owners.get(position).getOwnerMobile());
        holder.t5.setText(owners.get(position).getAddress());

        reference= FirebaseDatabase.getInstance().getReference().child("Shop_Owners");


        holder.button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Query query=reference.orderByChild("shopID").equalTo(owners.get(position).getShopID());
                query.addListenerForSingleValueEvent(new ValueEventListener()
                {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                    {
                        for (DataSnapshot snapshot:dataSnapshot.getChildren())
                        {
                            snapshot.getRef().child("status").setValue(true);
                            Toast.makeText(context, owners.get(position).getShopID()+" Has accepted", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError)
                    {
                        Toast.makeText(context, "Error....!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return owners.size();
    }

    class OwnerViewHolder extends RecyclerView.ViewHolder
    {
        TextView t1,t2,t3,t4,t5;
        ImageView imageView,imageView2;
        Button button;

        public OwnerViewHolder(@NonNull View ownerView) {
            super(ownerView);
            t1=(TextView) ownerView.findViewById(R.id.OwnerName);
            t2=(TextView)ownerView.findViewById(R.id.ShopNamee);
            t3=(TextView)ownerView.findViewById(R.id.ShopIDe);
            t4=(TextView)ownerView.findViewById(R.id.Owerno);
            t5=(TextView)ownerView.findViewById(R.id.Addresse);
            button=(Button)ownerView.findViewById(R.id.permitButton);

        }
    }

}
