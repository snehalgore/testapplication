package com.example.root.testapplication;

import android.app.Service;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class search_dialogue extends DialogFragment {

    View rootview;
    ListView itemlist;
    static search_dialogue newInstance() {
        return new search_dialogue();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        rootview = inflater.inflate(R.layout.search_popup, container, false);
        itemlist=(ListView)rootview.findViewById(R.id.itemlist);
        ArrayAdapter adapter = new ArrayAdapter(getActivity(),
                android.R.layout.simple_list_item_1, MainActivity.namelist);
        itemlist.setAdapter(adapter);




        return rootview;

    }



    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        /*if(isclose){
            getDialog().dismiss();
        }*/
    }



	/*public void onBackPressed() {

		// TODO Auto-generated method stub
		super.onBackPressed();
		try {

			InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(txtmsg1.getWindowToken(), 0);
		} catch (Exception e) {
			// TODO: handle exception
			Log.d("catch_Notify_me_popup", "\t" + e);
		}

	}*/

}