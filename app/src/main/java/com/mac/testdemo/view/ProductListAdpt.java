package com.mac.testdemo.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.mac.testdemo.R;
import com.mac.testdemo.databinding.ItemProductBinding;
import com.mac.testdemo.model.Datum;

import java.util.List;

public class ProductListAdpt extends RecyclerView.Adapter<ProductListAdpt.VeHold> {

    private List<Datum> datumList;

    public ProductListAdpt(List<Datum> datumList) {
        this.datumList = datumList;
    }

    @NonNull
    @Override
    public VeHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemProductBinding view = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_product,parent,false);
        return new VeHold(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VeHold holder, int position) {

    }

    @Override
    public int getItemCount() {
        return datumList.size();
    }

    public class VeHold extends RecyclerView.ViewHolder {
        public VeHold(@NonNull ItemProductBinding itemView) {
            super(itemView.getRoot());
        }
    }
}
