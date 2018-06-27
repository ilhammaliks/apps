package com.example.zhimer.studentdesk.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zhimer.studentdesk.Model.Berita;
import com.example.zhimer.studentdesk.R;

import java.util.List;

// di adapter recycler view minimal harus ada 2 class, class adapter dan inner class View Holder yang 2 2 nya nge extend recycler

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.ViewHolder> {
    // view holder harus ada 3 override/method minimal onCreateVH, onBind, sama getCount

    private Context context;
    private List<Berita> beritaList;
    private LayoutInflater inflater = null;

    public BeritaAdapter(List<Berita> beritaList, Context context)
    {
        this.beritaList = beritaList;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_berita2, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Berita berita = beritaList.get(position);

        Log.d("dataAPI", beritaList.get(0).getJudul());

        holder.judul.setText(berita.getJudul());
        holder.pengirim.setText(berita.getPengirim());
        holder.tanggal.setText(berita.getTanggal());
        holder.isinotif.setText(berita.getIsinotif());
    }

    @Override
    public int getItemCount() {
        return beritaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView judul, pengirim, tanggal, isinotif;

        ViewHolder(View itemView)
        {
            super(itemView);

            judul       = itemView.findViewById(R.id.berita_judul);
            pengirim    = itemView.findViewById(R.id.berita_pengirim);
            tanggal     = itemView.findViewById(R.id.berita_tanggal);
            isinotif    = itemView.findViewById(R.id.berita_isi);

        }
    }
}
