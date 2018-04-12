package com.example.froyd.beasy;

        import android.Manifest;
        import android.content.Intent;
        import android.content.pm.PackageManager;
        import android.os.Bundle;
        import android.support.v4.app.ActivityCompat;
        import android.support.v4.content.ContextCompat;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
        import com.google.android.gms.maps.OnMapReadyCallback;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.util.HashMap;
        import java.util.Iterator;
        import java.util.Map;

//        import org.omg.CORBA.PUBLIC_MEMBER;

    //    import static sun.text.bidi.BidiBase.R;

   //     import javax.swing.text.PlainDocument;
    // import javax.swing.text.PlainView;
     //  import javax.xml.soap.Text;

       // import sun.net.www.content.text.PlainTextInputStream;

//  import sun.applet.Main;


public class MainActivity extends AppCompatActivity {

    Boolean mLocationPermissionGranted = false;
    //Intent intent = new Intent(this, home.class);

    protected void onCreate(Bundle savedInstanceState) {



        try {
            JSONObject j = new JSONObject("{\n" +
                    "  \"1\": {\n" +
                    "    \"titulo\" : \"oficina do Leo\",\n" +
                    "    \"lat\": \"-3.0162625\",\n" +
                    "    \"lng\": \"-59.9966521\"\n" +
                    "  },\n" +
                    "  \"2\": {\n" +
                    "    \"titulo\" : \"oficina do Jean\",\n" +
                    "    \"lat\": \"-3.0046582\",\n" +
                    "    \"lng\": \"-60.0037182\"\n" +
                    "  },\n" +
                    "  \"3\": {\n" +
                    "    \"titulo\" : \"oficiana do Henrique\",\n" +
                    "    \"lat\": \"-3.0199969\",\n" +
                    "    \"lng\": \"-60.1633112\"\n" +
                    "  }\n" +
                    "\n" +
                    "}");


                    JSONObject bloco = j.getJSONObject("1");

            String titulo = bloco.getString("titulo");

            Log.d("testeee", titulo);






        } catch (JSONException e) {
            Log.d("testeee", "deu erro parça");
        }


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);




        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mLocationPermissionGranted = true;


        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    1234);


        }


        if (mLocationPermissionGranted) {


            final Button button = (Button) findViewById(R.id.button);


            final TextView mTextView = (TextView) findViewById(R.id.json_view);
            final RequestQueue queue = Volley.newRequestQueue(this);
            final Intent intent = new Intent(this, maps.class);
            startActivity(intent);

            final EditText login_input = (EditText) findViewById(R.id.login_edit);
            final EditText senha_input = (EditText) findViewById(R.id.senha_edit);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    String url = "http://httpbin.org/post";
                    StringRequest postRequest = new StringRequest(Request.Method.POST, "http://ebeasy.com.br/mysqlbeasy/login.php",

                            new Response.Listener<String>() {

                                @Override
                                public void onResponse(String response) {
                                    mTextView.setText(response);

                                    if (response.trim().equals("1")) {
                                        startActivity(intent);
                                    } else {
                                        mTextView.setText("Erro no login");
                                    }

//


                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    // error
                                    //Log.d("Error.Response", onErrorResponse());
                                    // mTextView.setText("erro");


                                }
                            }
                    ) {
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("login", login_input.getText().toString().trim());
                            params.put("senha", senha_input.getText().toString().trim());


                            return params;
                        }
                    };
                    queue.add(postRequest);


                    // Intent intent = new Intent(MainActivity.this, home.class);
                    // startActivity(intent);

                }
            });
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1234) {
            if (permissions.length == 1 &&
                    permissions[0] == Manifest.permission.ACCESS_FINE_LOCATION &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                Intent intent = new Intent(this, maps.class);
                startActivity(intent);
                mLocationPermissionGranted = true;
            }



            } else {
            Intent intent = new Intent(this, maps.class);
            startActivity(intent);
            }
        }

}



