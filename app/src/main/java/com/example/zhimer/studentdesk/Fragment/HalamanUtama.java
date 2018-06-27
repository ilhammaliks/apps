package com.example.zhimer.studentdesk.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.zhimer.studentdesk.Adapter.BeritaAdapter;
import com.example.zhimer.studentdesk.Model.Berita;
import com.example.zhimer.studentdesk.R;
import com.example.zhimer.studentdesk.SessionManager;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;


public class HalamanUtama extends Fragment {

    View view;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;

    private SessionManager session;

    private RecyclerView.Adapter adapter;
    private ArrayList<Berita> beritaList;

    public HalamanUtama() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.nav_halaman_utama, container, false);

        session = new SessionManager(getContext().getApplicationContext());
        beritaList = new ArrayList<>();
        //TODO 1: Harus inisialisasi dulu adapternya cuy
        adapter = new BeritaAdapter(beritaList, getActivity());

        recyclerView = view.findViewById(R.id.listBerita);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        gettingData();

        return view;
    }

    private void  gettingData()
    {
        String url = "https://studentdesk.uai.ac.id/rest/index.php/api/notifikasi/getNotifikasiByNIM/nim/0102512008/format/json";
        AsyncHttpClient client = new AsyncHttpClient();
        client.setBasicAuth("admin", "1234");
        client.get(url, new JsonHttpResponseHandler()
        {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                try {
                    JSONObject object = new JSONObject(response.toString());
                    JSONArray jsonArray = object.getJSONArray("data");

                    Log.d("dataAPI", jsonArray.length()+"");

                    for (int i = 0; i < jsonArray.length(); i++)
                    {
                        JSONObject exploreObject = jsonArray.getJSONObject(i);
                        Berita berita = new Berita();

                        String judul = exploreObject.getString("JudulNotifikasi");
                        String pengirim = exploreObject.getString("pengirim");
                        String tanggal = exploreObject.getString("TanggalBuat");
                        String isi = exploreObject.getString("IsiNotifikasi");

                        String isiotif = Html.fromHtml(isi).toString();

                        berita.setJudul(judul);
                        berita.setPengirim(pengirim);
                        berita.setTanggal(tanggal);
                        berita.setIsinotif(isiotif);

                        beritaList.add(berita);
                        //TODO 2: tambah method notifyDataSetChanged() tujuannya setiap data di add adapternya bakal berubah
                        adapter.notifyDataSetChanged();
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Log.d("getKampus", errorResponse + " gagal");
            }
        });
    }
}
