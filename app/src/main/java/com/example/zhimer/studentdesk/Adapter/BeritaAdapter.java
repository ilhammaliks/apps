package com.example.zhimer.studentdesk.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_berita, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Berita berita = beritaList.get(position);

        holder.judul.setText(berita.getJudul());
        holder.pengirim.setText(berita.getPengirim());
        holder.tanggal.setText(berita.getTanggal());
        holder.isinotif.setText(berita.getIsinotif());
    }

    @Override
    public int getItemCount() {
        return beritaList.size();
    }

    // view holder harus ada 3 method minimal onCreateVH, onBind, sama getCount

    /*public static final String KEY_JUDUL = "judul";
    public static final String KEY_PENGIRIM = "pengirim";
    public static final String KEY_TANGGAL = "tanggal";
    public static final String KEY_ISI = "isi";

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView judul;
        public TextView pengirim;
        public TextView tanggal;
        public TextView isi;
        public LinearLayout berita;

        public ViewHolder(View itemView) {
            super(itemView);

            judul = (TextView)itemView.findViewById(R.id.berita_judul);
            pengirim = (TextView)itemView.findViewById(R.id.berita_pengirim);
            tanggal = (TextView)itemView.findViewById(R.id.berita_tanggal);
            isi = (TextView)itemView.findViewById(R.id.berita_isi);
            berita = (LinearLayout)itemView.findViewById(R.id.berita);
        }
    }

    // define list dari model class "Berita"

    private List<Berita> beritaLists;
    private Context context;

    public BeritaAdapter(List<Berita> beritaLists, Context context)
    {
        this.beritaLists = beritaLists;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_berita, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        // data yang mau di iket ke View Holder taro disini buat di lempar ke view

        final Berita beritaList = beritaLists.get(position);
        holder.judul.setText(beritaList.getJudul());
        holder.pengirim.setText(beritaList.getPengirim());
        holder.tanggal.setText(beritaList.getTanggal());
        holder.isi.setText(beritaList.getIsinotif());
    }

    @Override
    public int getItemCount() {
        return beritaLists.size();
    }*/
}
