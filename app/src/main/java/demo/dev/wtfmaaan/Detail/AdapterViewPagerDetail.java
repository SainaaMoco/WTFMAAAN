package demo.dev.wtfmaaan.Detail;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import demo.dev.wtfmaaan.Const;
import demo.dev.wtfmaaan.Model;

class AdapterViewPagerDetail extends FragmentPagerAdapter {
    private List<ItemViewPagerDetail> fragments = new ArrayList<>();

    AdapterViewPagerDetail(FragmentManager fm, int pageNumber) {
        super(fm);
        List<Model> datas = Const.getMyData(pageNumber);
        for (Model data : datas) {
            fragments.add(ItemViewPagerDetail.newInstance(data));
        }
    }

    void removeItem(int position) {
        fragments.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public int getItemPosition(Object object) {
        if (fragments.contains(object)) {
            return fragments.indexOf(object);
        } else {
            return POSITION_NONE;
        }
    }
}
