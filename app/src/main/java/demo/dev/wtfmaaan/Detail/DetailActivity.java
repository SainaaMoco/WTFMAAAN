package demo.dev.wtfmaaan.Detail;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import demo.dev.wtfmaaan.Const;
import demo.dev.wtfmaaan.R;
import demo.dev.wtfmaaan.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailBinding binding;
    private AdapterViewPagerDetail viewPagerAdapter;
    private int currentPage;
    private int pageNumber;

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
            viewPagerAdapter.removeItem(currentPage);
            binding.detailViewPager.setOffscreenPageLimit(viewPagerAdapter.getCount());
            Const.getMyData(pageNumber).remove(currentPage);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);

        setSupportActionBar(binding.toolbar);
        setupViewPager();
        binding.delete.setOnClickListener(deleteButtonClickListener);
    }

    private void setupViewPager() {
        Bundle bundle = getIntent().getExtras();
        pageNumber = bundle.getInt(Const.KEY_PAGE_NUMBER);
        int itemNumber = bundle.getInt(Const.KEY_ITEM_NUMBER);
        viewPagerAdapter = new AdapterViewPagerDetail(getSupportFragmentManager(), pageNumber);
        binding.detailViewPager.addOnPageChangeListener(pageChangeListener);
        binding.detailViewPager.setAdapter(viewPagerAdapter);
        binding.detailViewPager.setCurrentItem(itemNumber);
        binding.detailViewPager.setOffscreenPageLimit(viewPagerAdapter.getCount());
    }
}
