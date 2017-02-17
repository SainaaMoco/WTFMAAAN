package demo.dev.wtfmaaan.Home;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import demo.dev.wtfmaaan.Const;
import demo.dev.wtfmaaan.R;
import demo.dev.wtfmaaan.databinding.FragmentPagerItemBinding;

public class ItemViewPager extends Fragment {
    private final static String KEY_PAGE_NUMBER = "page_number";
    public AdapterRecyclerView adapterRecyclerView;
    FragmentPagerItemBinding binding;

    public ItemViewPager() {
    }

    public static ItemViewPager newInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_PAGE_NUMBER, position);
        ItemViewPager itemViewPager = new ItemViewPager();
        itemViewPager.setArguments(bundle);
        return itemViewPager;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int pageNumber = getArguments().getInt(KEY_PAGE_NUMBER);
        Const.setupMyData(pageNumber);
        adapterRecyclerView = new AdapterRecyclerView(getActivity(), pageNumber);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pager_item, container, false);
        binding.recyclerView.setLayoutManager(linearLayoutManager);
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setAdapter(adapterRecyclerView);
        binding.recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),
                linearLayoutManager.getOrientation()));
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        adapterRecyclerView.notifyDataSetChanged();
    }
}
