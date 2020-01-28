package com.yasser.egpaytask.ui.main;


import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.yasser.egpaytask.Pojo.User;
import com.yasser.egpaytask.retrofit.APIInterface;
import com.yasser.egpaytask.retrofit.ApiUtil;

import java.util.ArrayList;

import retrofit2.Callback;

public class UserPresenter {

    UserView userView;
    APIInterface apiInterface;
    String result="";
    Context mContext;

    static String spinnerValue = "";

    public UserPresenter(UserView userView,Context context) {
        this.mContext= context;
        this.userView = userView;
    }


    public String sendUser() {
        apiInterface = ApiUtil.getAPIService();
        apiInterface.saveUser(1520,"Yasser","yes","type","defult","multi"
                ,"2").enqueue(new Callback<User>() {
            @Override
            public void onResponse(retrofit2.Call<User> call, retrofit2.Response<User> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(mContext, "Added Successfully", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(retrofit2.Call<User> call, Throwable t) {
                Toast.makeText(mContext, "Fail! " + t, Toast.LENGTH_SHORT).show();

            }
        });
        return result;
    }
    public LinearLayout initViews(final Context mContext) {

        // for VERTIVAL linearlayout
        LinearLayout linearLayout2 = new LinearLayout(mContext);
        linearLayout2.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        linearLayout2.setOrientation(LinearLayout.VERTICAL);

        EditText ed_name = new EditText(mContext);
        Spinner spinner_required = new Spinner(mContext);
        EditText ed_type = new EditText(mContext);
        EditText ed_defultValue = new EditText(mContext);
        EditText ed_Multipule = new EditText(mContext);
        EditText ed_sort = new EditText(mContext);
        Button btn_post = new Button(mContext);

        spinner_required.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT , ViewGroup.LayoutParams.WRAP_CONTENT));

        final ArrayList<String> spinnerArray = new ArrayList<String>();
        spinnerArray.add("Please Select Requird");
        spinnerArray.add("Yes");
        spinnerArray.add("No");

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_dropdown_item, spinnerArray);
        spinner_required.setAdapter(spinnerArrayAdapter);

        ed_name.setHint("Name");
        ed_name.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT , ViewGroup.LayoutParams.WRAP_CONTENT));

        ed_type.setHint("Type");
        ed_type.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT , ViewGroup.LayoutParams.WRAP_CONTENT));

        ed_defultValue.setHint("defult Value");
        ed_defultValue.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT , ViewGroup.LayoutParams.WRAP_CONTENT));

        ed_Multipule.setHint("Multipule");
        ed_Multipule.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT , ViewGroup.LayoutParams.WRAP_CONTENT));

        ed_sort.setHint("Sort");
        ed_sort.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT , ViewGroup.LayoutParams.WRAP_CONTENT));

        btn_post.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT , ViewGroup.LayoutParams.WRAP_CONTENT));
        btn_post.setText("Post Data");
        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setMessage("Look at this dialog!")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        spinner_required.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (spinnerArray.get(i).equals("Yes")){
                    Toast.makeText(mContext, "Required", Toast.LENGTH_SHORT).show();
                }else if (spinnerArray.get(i).equals("No"))
                {
                    Toast.makeText(mContext, "Optional", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(mContext, "Please Select Value", Toast.LENGTH_SHORT).show();
                    spinnerValue = "no value";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(mContext, "Please Select Value From Spinner", Toast.LENGTH_SHORT).show();
            }
        });

        // add components to linearlayout
        linearLayout2.addView(ed_name);
        linearLayout2.addView(spinner_required);
        linearLayout2.addView(ed_type);
        linearLayout2.addView(ed_Multipule);
        linearLayout2.addView(ed_defultValue);
        linearLayout2.addView(ed_sort);
        linearLayout2.addView(btn_post);


        return linearLayout2;
    }


}
