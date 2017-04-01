package com.app.dbjk.adapters;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.dbjk.activities.MainActivity;
import com.app.dbjk.model.DetailProducts;
import com.app.dbjk.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {

    private Context mContext;
    private List<DetailProducts> searchList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView brandName, name, color, price, size, available;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            brandName = (TextView) view.findViewById(R.id.brandName);
            name = (TextView) view.findViewById(R.id.name);
            color = (TextView) view.findViewById(R.id.color);
            size = (TextView) view.findViewById(R.id.size);
            price = (TextView) view.findViewById(R.id.price);
            available = (TextView) view.findViewById(R.id.available);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            overflow = (ImageView) view.findViewById(R.id.overflow);
        }
    }


    public SearchAdapter(Context mContext, List<DetailProducts> searchList) {
        this.mContext = mContext;
        this.searchList = searchList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.search_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final DetailProducts results = searchList.get(position);
        holder.brandName.setText(results.getBrand().getName());
        holder.brandName.setTypeface(null, Typeface.BOLD);
        holder.name.setText(results.getName());
        holder.color.setText("Color: " + results.getCurrentVariantProduct().getColor());
        holder.size.setText("Size: " + results.getCurrentVariantProduct().getSize());
        if (results.getCurrentVariantProduct().getAvailability().getAvailable()) {
            holder.available.setText("Available in stock");
        } else {
            holder.available.setText("Not Available");
        }

        holder.price.setText(results.getSellingPrice().getCurrencyCode() + " " + String.valueOf(results.getSellingPrice().getValue()));
        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    String url = "http:" + results.getUrl();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    mContext.startActivity(i);

                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                }


            }
        });


        // loading using Glide library
        Glide.with(mContext).load("http:" + results.getCurrentVariantProduct().getImages().get(0).getUrl()).into(holder.thumbnail);

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_card, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_wish_list:
                    Toast.makeText(mContext, "Add to wish list", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_add_cart:
                    Toast.makeText(mContext, "Add to cart", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return searchList.size();
    }
}
