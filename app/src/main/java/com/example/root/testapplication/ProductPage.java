package com.example.root.testapplication;






/*import com.google.analytics.tracking.android.EasyTracker;*/


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductPage extends ActionBarActivity {
     ImageView imageView;
    TextView txtname,txtprice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.productpage);
      imageView=(ImageView)findViewById(R.id.imageView);
        txtname=(TextView)findViewById(R.id.txtname);
        txtprice=(TextView)findViewById(R.id.txtprice);
        Bundle b=getIntent().getExtras();
        imageView.setBackgroundResource(b.getInt("image"));
        txtname.setText(b.getString("name"));
        txtprice.setText(b.getString("price"));



    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }


    @Override
    protected void onResume() {
        super.onResume();

    }


}