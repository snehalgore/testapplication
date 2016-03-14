package com.example.root.testapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;



public class DownloadProductModel {



    private volatile ImageView product_grid_imageitem;
    private volatile TextView txtname,txtprice;
    int ProductPosition;
    Activity activity;
    private String name,price;
    private Integer image;

    public DownloadProductModel(Activity activity,int image,String name,String price) {
        this.activity=activity;
        this.image=image;
        this.price=price;
        this.name=name;
    }
    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public int getImage()
   {
       return image;
   }

    public  void  setImage(int image)
    {
        this.image=image;
    }


    public String getName()
    {
        return name;
    }

    public  void  setName(String name)
    {
        this.name=name;
    }
    public String getPrice()
    {
        return price;
    }

    public  void  setPrice(String price)
    {
        this.price=price;
    }

    public ImageView getProduct_grid_imageitem()
    {
        return product_grid_imageitem;
    }

    public  void  setProduct_grid_imageitem(ImageView product_grid_imageitem)
    {
        this.product_grid_imageitem=product_grid_imageitem;
    }
    public TextView getTxtname()
    {
        return txtname;
    }

    public  void  setTxtname(TextView txtname)
    {
        this.txtname=txtname;
    }
    public TextView getTxtprice()
    {
        return txtprice;
    }

    public  void  setTxtprice(TextView txtprice)
    {
        this.txtprice=txtprice;
    }


}