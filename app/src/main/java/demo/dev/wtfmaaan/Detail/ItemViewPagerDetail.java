package demo.dev.wtfmaaan.Detail;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import demo.dev.wtfmaaan.Model;
import demo.dev.wtfmaaan.R;
import demo.dev.wtfmaaan.databinding.FragmentItemViewPagerDetailBinding;

public class ItemViewPagerDetail extends Fragment {
    FragmentItemViewPagerDetailBinding binding;
    private Model data;

    public ItemViewPagerDetail() {
        // Required empty public constructor
    }

    public static ItemViewPagerDetail newInstance(Model data) {
        ItemViewPagerDetail itemViewPagerDetail = new ItemViewPagerDetail();
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", data);
        itemViewPagerDetail.setArguments(bundle);
        return itemViewPagerDetail;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = (Model) getArguments().getSerializable("data");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_item_view_pager_detail, container, false);
        binding.itemName.setText(data.getWtfName());
        return binding.getRoot();
    }

}
