package com.example.mokle.helprohingaapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class SubmitActivity extends AppCompatActivity {
    EditText etxName, etxEmail, etxMobile, etxAmount, etxAddress, etxMessage;
    Spinner spinner;
    Button btnSubmit;

    String name, email, mobile, catgry, amount, address, message;

    RequestQueue requestQueue;
    ProgressDialog progressDialog;

    String HttpUrl = "https://android-examples.000webhostapp.com/insert_record.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        etxName = (EditText) findViewById(R.id.etx_name);
        etxEmail = (EditText) findViewById(R.id.etx_email);
        etxMobile = (EditText) findViewById(R.id.etx_phone);
        etxAmount = (EditText) findViewById(R.id.etx_amount);
        etxAddress = (EditText) findViewById(R.id.etx_address);
        etxMessage = (EditText) findViewById(R.id.etx_message);

        spinner = (Spinner) findViewById(R.id.spinner);

        btnSubmit = (Button) findViewById(R.id.btn_submit);


        requestQueue = Volley.newRequestQueue(SubmitActivity.this);
        progressDialog = new ProgressDialog(SubmitActivity.this);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                GetValueFromEditText();

                if (name.isEmpty() && email.isEmpty() && mobile.isEmpty() && catgry.isEmpty() && amount.isEmpty() && address.isEmpty() && message.isEmpty()) {
                    Toast.makeText(SubmitActivity.this, "PLEASE FILL", Toast.LENGTH_SHORT).show();
                }else {

                    progressDialog.setMessage("Please Wait, We are Inserting Your Data on Server");
                    progressDialog.show();

                    // Creating string request with post method.
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, HttpUrl,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String ServerResponse) {

                                    // Hiding the progress dialog after all task complete.
                                    progressDialog.dismiss();

                                    // Showing response message coming from server.
                                    Toast.makeText(SubmitActivity.this, ServerResponse, Toast.LENGTH_LONG).show();
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError volleyError) {

                                    // Hiding the progress dialog after all task complete.
                                    progressDialog.dismiss();

                                    // Showing error message if something goes wrong.
                                    Toast.makeText(SubmitActivity.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                                }
                            }) {
                        @Override
                        protected Map<String, String> getParams() {

                            // Creating Map String Params.
                            Map<String, String> params = new HashMap<String, String>();

                            // Adding All values to Params.
//                        params.put("first_name", FirstNameHolder);
//                            params.put("last_name", LastNameHolder);
//                            params.put("email", EmailHolder);

                            return params;
                        }

                    };

                    // Creating RequestQueue.
                    RequestQueue requestQueue = Volley.newRequestQueue(SubmitActivity.this);

                    // Adding the StringRequest object into requestQueue.
                    requestQueue.add(stringRequest);
                }

            }
        });

    }


    public void GetValueFromEditText(){
        name = etxName.getText().toString().trim();
        email = etxEmail.getText().toString().trim();
        mobile = etxMobile.getText().toString().trim();
        catgry = spinner.getSelectedItem().toString().trim();
        amount = etxAmount.getText().toString().trim();
        address = etxAddress.getText().toString().trim();
        message = etxMessage.getText().toString().trim();
        if (catgry.equals("SELECT")){
            catgry = "";
        }
    }
}
