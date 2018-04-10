package com.example.froyd.beasy;

        import android.app.Activity;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.android.volley.AuthFailureError;
        import com.android.volley.Request;
        import com.android.volley.RequestQueue;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.StringRequest;
        import com.android.volley.toolbox.Volley;

//        import org.omg.CORBA.PUBLIC_MEMBER;

        import java.util.HashMap;
        import java.util.Map;

    //    import static sun.text.bidi.BidiBase.R;

   //     import javax.swing.text.PlainDocument;
    // import javax.swing.text.PlainView;
     //  import javax.xml.soap.Text;

       // import sun.net.www.content.text.PlainTextInputStream;

//  import sun.applet.Main;


public class MainActivity extends AppCompatActivity {


    //Intent intent = new Intent(this, home.class);

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView (R.layout.activity_main ) ;



        final Button button = (Button)findViewById(R.id.button);




        final TextView mTextView = (TextView) findViewById(R.id.json_view);
        final RequestQueue queue = Volley.newRequestQueue(this);
        final Intent intent = new Intent(this, home.class);

        final EditText login_input = (EditText)findViewById(R.id.login_edit);
        final EditText senha_input = (EditText)findViewById(R.id.senha_edit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





                String url = "http://httpbin.org/post";
                StringRequest postRequest = new StringRequest(Request.Method.POST, "http://ebeasy.com.br/mysqlbeasy/login.php",

                        new Response.Listener<String>()
                        {

                            @Override
                            public void onResponse(String response) {
                                mTextView.setText(response);

                                if (response.trim().equals("1")){
                                    startActivity(intent);
                                }else{
                                    mTextView.setText("Erro no login");
                                }




                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // error
                                //Log.d("Error.Response", onErrorResponse());
                               // mTextView.setText("erro");


                            }
                        }
                ) {
                    @Override
                    protected Map<String, String> getParams()
                    {
                        Map<String, String>  params = new HashMap<String, String>();
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



