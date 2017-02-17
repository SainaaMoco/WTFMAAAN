package demo.dev.wtfmaaan;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import demo.dev.wtfmaaan.Home.AdapterViewPager;
import demo.dev.wtfmaaan.Home.ItemViewPager;
import demo.dev.wtfmaaan.databinding.ActivityMainBinding;

public class ActivityMain extends AppCompatActivity {
    ActivityMainBinding binding;
    int currentPage = 0;
    private AdapterViewPager adapterViewPager;
    private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            currentPage = position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private View.OnClickListener deleteButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ((ItemViewPager) adapterViewPager.getItem(currentPage))
                    .adapterRecyclerView
                    .removeSelectedItems();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setSupportActionBar(binding.toolbar);
        setupViewPager();
        binding.delete.setOnClickListener(deleteButtonClickListener);
    }

    private void setupViewPager() {
        adapterViewPager = new AdapterViewPager(getSupportFragmentManager());
        binding.viewPager.setOffscreenPageLimit(adapterViewPager.getCount());
        binding.viewPager.setAdapter(adapterViewPager);
        binding.viewPager.addOnPageChangeListener(pageChangeListener);
        binding.tabLayout.setupWithViewPager(binding.viewPager);
    }
}
