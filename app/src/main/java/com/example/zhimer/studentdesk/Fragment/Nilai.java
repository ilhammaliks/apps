package com.example.zhimer.studentdesk.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhimer.studentdesk.R;
import com.example.zhimer.studentdesk.tabNilai.NilaiAktif;
import com.example.zhimer.studentdesk.tabNilai.NilaiSeluruh;
import com.example.zhimer.studentdesk.tabNilai.NilaiSemester;
import com.example.zhimer.studentdesk.tabPerkuliahan.TabJadwal;
import com.example.zhimer.studentdesk.tabPerkuliahan.TabKehadiran;
import com.example.zhimer.studentdesk.tabPerkuliahan.TabPengganti;

import java.util.ArrayList;
import java.util.List;

public class Nilai extends Fragment {

    View view;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public Nilai() {
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
        view = inflater.inflate(R.layout.nav_nilai, container, false);

        tabLayout = view.findViewById(R.id.tabs);
        viewPager = view.findViewById(R.id.viewpager);

        tabLayout.setupWithViewPager(viewPager);
        setupViewPager(viewPager);

        return view;
    }

    private void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());

        adapter.addFragment(new NilaiAktif(), "Aktif");
        adapter.addFragment(new NilaiSemester(), "Semester");
        adapter.addFragment(new NilaiSeluruh(), "Seluruh");

        viewPager.setAdapter(adapter);
    }

    public class ViewPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> Fragment = new ArrayList<>();
        private List<String> PageTitle = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager)
        {
            super(manager);
        }

        private void addFragment(Fragment fragment, String title)
        {
            Fragment.add(fragment);
            PageTitle.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return Fragment.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return PageTitle.get(position);
        }

        @Override
        public int getCount() {
            return PageTitle.size();
        }
    }
}
