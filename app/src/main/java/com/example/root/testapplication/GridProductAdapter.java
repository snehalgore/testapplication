package com.example.root.testapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;



public class GridProductAdapter extends ArrayAdapter<DownloadProductModel> {

    private Activity activity;
    private Context mContext;
    LayoutInflater mInflater;
    private List<DownloadProductModel> object;


    public GridProductAdapter(Activity activity, int gridViewResourceId,
                              List<DownloadProductModel> objects) {

        super(activity, gridViewResourceId, objects);

        this.activity = activity;
        this.mContext = activity.getApplicationContext();
        this.object = objects;

    }

    class ViewHolder {

        ImageView product_grid_imageitem;
        TextView txtname,txtprice;
        String name,price;
        int image;
        DownloadProductModel info;

    }

    @Override
    public View getView(final int position, final View convertView,
                        final ViewGroup parent) {
        Log.d("orders", "position==" + position);
        final DownloadProductModel info = getItem(position);

        final ViewHolder holder;


        Log.d("orders convertView", "convertView==" + convertView);
        View view = convertView;
        mInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        try {
            if (view == null) {
                holder = new ViewHolder();
                view = mInflater.inflate(R.layout.product_grid, parent,
                        false);
                holder.txtname = (TextView)view.findViewById(R.id.txtname);
                holder.txtprice = (TextView) view.findViewById(R.id.txtprice);
                holder.product_grid_imageitem = (ImageView) view.findViewById(R.id.product_grid_imageitem);

                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
                holder.info = info;
            }

            info.setActivity(activity);

            info.setProduct_grid_imageitem(holder.product_grid_imageitem);
            info.setTxtname(holder.txtname);
            info.setTxtprice(holder.txtprice);
             info.getProduct_grid_imageitem().setBackgroundResource(info.getImage());
            Log.d("name","name=="+info.getName());
             info.getTxtname().setText(info.getName());
             info.getTxtprice().setText(info.getPrice());

        } catch (Exception e) {
            e.printStackTrace();

        }

        return view;
    }

}
