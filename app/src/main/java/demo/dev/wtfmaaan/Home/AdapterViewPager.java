package demo.dev.wtfmaaan.Home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class AdapterViewPager extends FragmentPagerAdapter {
    private List<ItemViewPager> fragments = new ArrayList<>();

    public AdapterViewPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (fragments.size() > position) {
            return fragments.get(position);
        } else {
            ItemViewPager itemMainViewPager = ItemViewPager.newInstance(position);
            fragments.add(itemMainViewPager);
            return itemMainViewPager;
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return String.valueOf("Page " + position);
    }
}
