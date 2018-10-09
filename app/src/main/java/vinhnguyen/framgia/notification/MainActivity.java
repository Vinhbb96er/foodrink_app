package vinhnguyen.framgia.notification;

import android.app.VoiceInteractor;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.iid.FirebaseInstanceId;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import vinhnguyen.framgia.notification.Services.MyFirebaseMessagingService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        JSONObject params = new JSONObject();
//        try {
//            params.put("userId", 10);
//            params.put("title", "Hello");
//            params.put("body", "Hello description");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

//        JsonArrayRequest objectRequest = new JsonArrayRequest(
//                Request.Method.GET,
//                "https://foodrinkappapi.herokuapp.com/api/devices",
//                null,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        try {
//                            Log.d("abc", response.toString());
//                            for (int i = 0; i < response.length(); i++) {
//                                Log.d("abc", response.getJSONObject(i).toString());
//                            }
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.d("abc", error.toString());
//                    }
//                }
//        );


//        JsonObjectRequest objectRequest = new JsonObjectRequest(
//                Request.Method.DELETE,
//                "https://foodrinkappapi.herokuapp.com/api/devices/1",
//                null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        Log.d("abc", response.toString());
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.d("abc", error.toString());
//                    }
//                }
//        );
//
//        requestQueue.add(objectRequest);

//        String android_id = FirebaseInstanceId.getInstance().getToken();
//        Log.d("abc", android_id);

    }
}
