package demo.dev.wtfmaaan.Home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import demo.dev.wtfmaaan.Const;
import demo.dev.wtfmaaan.Detail.DetailActivity;
import demo.dev.wtfmaaan.R;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.MViewHolder> {
    private Context context;
    private int pageNumber;

    AdapterRecyclerView(Context context, int pageNumber) {
        this.context = context;
        this.pageNumber = pageNumber;
    }

    @SuppressLint("InflateParams")
    @Override
    public MViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.item_recycler_view, null));
    }

    @Override
    public void onBindViewHolder(MViewHolder holder, int position) {
        final int _position = position;
        holder.checkBox.setText(Const.getMyData(pageNumber).get(_position).getWtfName());
        holder.checkBox.setOnCheckedChangeListener(null);
        holder.checkBox.setChecked(Const.getMyData(pageNumber).get(position).isWtfIsSelected());
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Const.getMyData(pageNumber).get(_position).setWtfIsSelected(b);
            }
        });

        holder.goToDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(Const.KEY_PAGE_NUMBER, pageNumber);
                intent.putExtra(Const.KEY_ITEM_NUMBER, _position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Const.getMyData(pageNumber).size();
    }

    public void removeSelectedItems() {
        if (Const.getMyData(pageNumber).size() == 0) {
            Toast.makeText(context, R.string.warning_select, Toast.LENGTH_SHORT).show();
        } else {
            for (int i = Const.getMyData(pageNumber).size() - 1; i >= 0; i--) {
                if (Const.getMyData(pageNumber).get(i).isWtfIsSelected()) {
                    Const.getMyData(pageNumber).remove(i);
                    notifyItemRemoved(i);
                }
            }
        }
    }

    class MViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        FrameLayout container;
        TextView goToDetail;

        MViewHolder(View itemView) {
            super(itemView);
            container = (FrameLayout) itemView.findViewById(R.id.container);
            container.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, 150));
            checkBox = (CheckBox) itemView.findViewById(R.id.item_title);
            goToDetail = (TextView) itemView.findViewById(R.id.button_detail);
        }
    }
}
