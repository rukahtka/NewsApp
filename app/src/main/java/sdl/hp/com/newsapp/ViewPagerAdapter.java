package sdl.hp.com.newsapp;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> FragmentList = new ArrayList<>();
    ArrayList<String> FragmentTitle = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentList.get(position);
    }

    @Override
    public int getCount() {
        return FragmentList.size();
    }

    public void addFragmentToAdapter(Fragment f, String name){
        FragmentList.add(f);
        FragmentTitle.add(name);
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return FragmentTitle.get(position);
    }
}
