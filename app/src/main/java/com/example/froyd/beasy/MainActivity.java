package com.example.froyd.beasy;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

        import com.android.volley.Request;
        import com.android.volley.RequestQueue;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.StringRequest;
        import com.android.volley.toolbox.Volley;

        import java.util.HashMap;
        import java.util.Map;

      //  import sun.applet.Main;


public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView (R.layout.activity_main ) ;

        RequestQueue queue = Volley.newRequestQueue(this);
        final TextView mTextView = (TextView) findViewById(R.id.json_view);

        final Button button = (Button)findViewById(R.id.button);





        String url = "http://httpbin.org/post";
        StringRequest postRequest = new StringRequest(Request.Method.POST, "http://ebeasy.com.br/mysqlbeasy/login.php",

                new Response.Listener<String>()
                {

                    @Override
                    public void onResponse(String response) {
                        mTextView.setText(response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        //Log.d("Error.Response", onErrorResponse());
                        mTextView.setText("erro");
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("login", "froyd");
                params.put("senha", "123");


                return params;
            }
        };
        queue.add(postRequest);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, home.class);
                 startActivity(intent);

            }
        });

       // Intent intent = new Intent(this, home.class);
       // startActivity(intent);



























    }

}
