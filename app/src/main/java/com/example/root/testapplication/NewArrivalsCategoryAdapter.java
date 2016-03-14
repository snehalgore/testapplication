package com.example.root.testapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;



import java.util.List;

/**
 * Created by prasad on 04/01/16.
 */
public class NewArrivalsCategoryAdapter extends ArrayAdapter<DownloadProductModel> {

    private Activity mActivity;
    private Context mContext;
    LayoutInflater mInflater;
    Typeface tf;
    private Animation anim, upscale, fadeIn;

    private RelativeLayout msg_layout;
    private TextView txt_msg;
    Runnable mRunnable;
    Handler mHandler;
    private List<DownloadProductModel> mInnerData;

    public NewArrivalsCategoryAdapter(Activity activity, int resource, List<DownloadProductModel> objects) {
        super(activity, resource, objects);
        mActivity = activity;
        mContext = activity.getApplicationContext();

    }

    class ViewHolder {

        ImageView imageView;
        RelativeLayout productItem;
        TextView txtCatName;
        DownloadProductModel info;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final DownloadProductModel info = getItem(position);

        final ViewHolder holder;

        mHandler = new Handler();

        mRunnable = new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub

                msg_layout.setVisibility(View.GONE);
            }
        };


        View view = convertView;
        mInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        try {
            if (view == null) {
                holder = new ViewHolder();
                view = mInflater.inflate(R.layout.new_arrivals_all_category, parent,
                        false);
                holder.productItem = (RelativeLayout) view
                        .findViewById(R.id.linear_item);

                holder.imageView = (ImageView) view
                        .findViewById(R.id.product_grid_imageitem);

                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
                holder.info = info;
            }

            info.setActivity(mActivity);

            info.setProduct_grid_imageitem(holder.imageView);
            //info.setmProductItem(holder.productItem);
            /*holder.txtCatName.setText("" + info.getCategoryName());
            holder.txtCatName.setTypeface(MainActivity.tf);*/
            info.getProduct_grid_imageitem().setBackgroundResource(info.getImage());
           /* Log.d("newimage", "" + info.getmOriginalThumb());*/
            info.getProduct_grid_imageitem().setMinimumHeight(200);



        } catch (Exception e) {
            e.printStackTrace();

        }

        return view;
    }
}
