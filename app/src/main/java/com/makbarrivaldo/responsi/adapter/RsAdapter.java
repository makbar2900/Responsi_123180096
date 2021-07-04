package com.makbarrivaldo.responsi.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makbarrivaldo.responsi.R;
import com.makbarrivaldo.responsi.model.rs.RsDataItem;

import java.util.ArrayList;

public class RsAdapter extends RecyclerView.Adapter<RsAdapter.ViewHolder> {

    private ArrayList<RsDataItem> rsDataItems = new ArrayList<>();
    private Context context;

    public RsAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<RsDataItem> items){
        rsDataItems.clear();
        rsDataItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist_rs, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RsAdapter.ViewHolder holder, int position) {
        holder.tvNamaRs.setText(rsDataItems.get(position).getNama());
        holder.tvAlamat.setText(rsDataItems.get(position).getAlamat());
        holder.btnMaps.setOnClickListener(v -> {
            Uri gmnIntentUri = Uri.parse("geo:"
                    +String.valueOf(rsDataItems.get(position).getLatitude())
                    +","+String.valueOf(rsDataItems.get(position).getLongitude())
                    +"?q="+String.valueOf(rsDataItems.get(position).getNama())
            );
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmnIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            context.startActivity(mapIntent);
        });
    }

    @Override
    public int getItemCount() {
        return rsDataItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaRs, tvAlamat;
        Button btnMaps;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaRs = itemView.findViewById(R.id.tvnamars);
            tvAlamat = itemView.findViewById(R.id.tv_alamatrs);
            btnMaps = itemView.findViewById(R.id.btn_mapsrs);
        }
    }
}
