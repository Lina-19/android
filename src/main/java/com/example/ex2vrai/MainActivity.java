package com.example.ex2vrai;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private static final String HTTP_URL = "https://belatar.name/rest/profile.php?login=test&passwd=test&id=9998";
    private static final String HTTP_IMAGES = "https://belatar.name/images/";
    private Etudiant etd;
ImageView imageView;
    // private static final String TAGNAME = MainActivity.class.getCanonicalName(); //pour la ligne 23

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");
       // Log.d(MainActivity.class.getCanonicalName(),"OnCreate");
     //  Log.d(TAGNAME,"onCreate");
    }

    @SuppressLint("RestrictedApi")
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onStart");
    }

    @SuppressLint("RestrictedApi")
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onResume");

        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, HTTP_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(MainActivity.class.getSimpleName(),response.toString());
                try {
                    etd =new Etudiant(response.getInt("id"),response.getString("nom"),

                            response.getString("prenom"),response.getString("classe"),
                            response.getString("phone"),null
                            );
                    VolleySingleton.getInstance(getApplicationContext()).getImageLoader()
                            .get(HTTP_IMAGES + response.getString("photo"), new ImageLoader.ImageListener() {
                                @Override
                                public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                                    etd.setImage(response.getBitmap());
                                            ImageView img = findViewById(R.id.image);
                                            img.setImageBitmap(etd.getImage());
                                }

                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Log.e(MainActivity.class.getSimpleName(),error.getMessage());
                                }
                            });
                    EditText txtnom=findViewById(R.id.labelNom);
                    EditText txtprenom=findViewById(R.id.labelPrenom);
                    EditText  txtclasse=findViewById(R.id.labelClasse);

                    txtnom.setText(etd.getNom());
                    txtprenom.setText(etd.getPrenom());
                    txtclasse.setText(etd.getClasse());

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.e(MainActivity.class.getSimpleName(),error.getMessage());

            }
        }
        );
        VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(request);

    }

    @SuppressLint("RestrictedApi")
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onPause");
    }

    @SuppressLint("RestrictedApi")
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onStop");
    }

    @SuppressLint("RestrictedApi")
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onDestroy");
    }

    @SuppressLint("RestrictedApi")
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onRestart");
    }
}