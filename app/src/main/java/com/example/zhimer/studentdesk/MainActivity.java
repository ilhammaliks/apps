package com.example.zhimer.studentdesk;


import android.app.Activity;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.zhimer.studentdesk.Fragment.Biodata;
import com.example.zhimer.studentdesk.Fragment.ChatOnline;
import com.example.zhimer.studentdesk.Fragment.HalamanUtama;
import com.example.zhimer.studentdesk.Fragment.IsiKrs;
import com.example.zhimer.studentdesk.Fragment.Keuangan;
import com.example.zhimer.studentdesk.Fragment.Nilai;
import com.example.zhimer.studentdesk.Fragment.Perkuliahan;
import com.example.zhimer.studentdesk.Fragment.PermintaanSurat;
import com.example.zhimer.studentdesk.Fragment.RingkasanAkademik;
import com.example.zhimer.studentdesk.Fragment.TestQuran;
import com.example.zhimer.studentdesk.Fragment.UaiEnglishTest;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.auth.AuthScope;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;
    private SessionManager session;


    private HalamanUtama halamanUtama;
    private Biodata biodata;
    private PermintaanSurat permintaanSurat;
    private ChatOnline chatOnline;
    private TestQuran testQuran;
    private UaiEnglishTest uaiEnglishTest;
    private RingkasanAkademik ringkasanAkademik;
    private Keuangan keuangan;
    private IsiKrs isiKrs;
    private Perkuliahan perkuliahan;
    private Nilai nilai;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerlayout = findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerlayout, R.string.open, R.string.close);
        mDrawerlayout.addDrawerListener(mToggle);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /*setupDrawerContent(navigationView);*/

        halamanUtama = new HalamanUtama();
        biodata = new Biodata();
        permintaanSurat = new PermintaanSurat();
        chatOnline = new ChatOnline();
        testQuran = new TestQuran();
        uaiEnglishTest = new UaiEnglishTest();
        ringkasanAkademik = new RingkasanAkademik();
        keuangan = new Keuangan();
        isiKrs = new IsiKrs();
        perkuliahan = new Perkuliahan();
        nilai = new Nilai();


        session= new SessionManager(getApplicationContext());

        setFragment(halamanUtama);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.biodata:
                        setFragment(biodata);
                        return true;

                    case R.id.chat:
                        setFragment(chatOnline);
                        return true;

                    case R.id.halamanUtama:
                        setFragment(halamanUtama);
                        return true;

                    case R.id.krs:
                        setFragment(isiKrs);
                        return true;

                    case R.id.keuangan:
                        setFragment(keuangan);
                        return true;

                    case R.id.nilai:
                        setFragment(nilai);
                        return true;

                    case R.id.perkuliahan:
                        setFragment(perkuliahan);
                        return true;

                    case R.id.surat:
                        setFragment(permintaanSurat);
                        return true;

                    case R.id.akademik:
                        setFragment(ringkasanAkademik);
                        return true;

                    case R.id.quran:
                        setFragment(testQuran);
                        return true;

                    case R.id.uet:
                        setFragment(uaiEnglishTest);
                        return true;

                    default:
                        return true;
                }

            }
        });
    }



    /*private void  gettingData()
    {
        String url = "https://studentdesk.uai.ac.id/rest/index.php/api/notifikasi/getNotifikasiByNIM/nim/0102512008/format/json";
        AsyncHttpClient client = new AsyncHttpClient();
        client.setBasicAuth("admin", "1234");
        client.get(url, new JsonHttpResponseHandler()
        {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Log.d("getKampus", response + "");

                session.setAPI(response.toString());

                Log.d("napayak", response + "");

                *//*try {
                    JSONArray halamanUtama = response.getJSONArray("datas");
                    Log.d("hasil", halamanUtama+"");

                    for (int i = 0 ; i < halamanUtama.length(); i++)
                    {
                        JSONObject hasilData = halamanUtama.getJSONObject(i);

                        if (hasilData.getString("jenis").equals("PENGUMUMAN"))
                        {

                            String pengirim = hasilData.getString("pengirim");
                            String tanggal = hasilData.getString("TanggalBuat");
                            String judul = hasilData.getString("JudulNotifikasi");

                            String isinya = hasilData.getString("IsiNotifikasi");
                            String isi = Html.fromHtml(isinya).toString();


                            Log.d("datas", tanggal);
                            Log.d("datas", judul);
                            Log.d("datas", isi);
                            Log.d("datas", pengirim);
                        }
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }*//*

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Log.d("getKampus", errorResponse + " gagal");
            }
        });
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /*public void selectNavigation (MenuItem menuItem)
    {
        Fragment fragment = null;
        String title = "";
        Class activity;
        Class fragmentClass;
        switch (menuItem.getItemId())
        {
            case R.id.surat:
                fragmentClass = PermintaanSurat.class;
                break;

            case R.id.krs:
                fragmentClass = IsiKrs.class;
                break;

            case R.id.chat:
                fragmentClass = ChatOnline.class;
                break;

            case R.id.quran:
                fragmentClass = TestQuran.class;
                break;

            case R.id.akademik:
                fragmentClass = RingkasanAkademik.class;
//                title = "Ringkasan Akademik";
                break;

            case R.id.biodata:
                fragmentClass = Biodata.class;
                break;

            case R.id.keuangan:
                fragmentClass = Keuangan.class;
//                title = "Ringkasan Akademik";
                break;

            case R.id.perkuliahan:
                fragmentClass = Perkuliahan.class;
                break;

            case R.id.nilai:
                fragmentClass = Nilai.class;
                break;

            case R.id.uet:
                fragmentClass = UaiEnglishTest.class;
//                title = "Perkuliahan";
                break;

            default:
                fragmentClass = HalamanUtama.class;
        }
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }




        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content, fragment);
        menuItem.setChecked(true);
//        setTitle(menuItem.getTitle());
        mDrawerlayout.closeDrawers();
        transaction.addToBackStack("myScreen");
        Log.d("ngetes", (String) menuItem.getTitle());
        transaction.commit();
    }*/

    private void setFragment (Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content, fragment);

        mDrawerlayout.closeDrawers();
        transaction.addToBackStack("myScreen");
        transaction.commit();
    }



    /*private void setupDrawerContent(NavigationView navigationView)
    {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectNavigation(item);
                return true;
            }
        });
    }*/

}
