package vinhnguyen.framgia.notification.Controllers;

import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import vinhnguyen.framgia.notification.R;

public class OrderRequestActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String ACCEPT_ACTION = "Accept";
    public static final String REJECT_ACTION = "Reject";
    public static final String SHOW_ACTION = "Show";

    private RequestQueue requestQueue;
    private String apiURL;
    private Intent intent;
    private ProgressDialog progress;

    private TextView tv;
    private Button btnAccept;
    private Button btnReject;
    private LinearLayout orderAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_request);

        hideNotification();
        getWidgets();
        process();
    }

    private void process() {
        String action = intent.getAction();

        if (action == null) {
            return;
        }

        switch (action) {
            case OrderRequestActivity.ACCEPT_ACTION:
                tv.setText("Accept");
                acceptOrder();
                break;

            case OrderRequestActivity.REJECT_ACTION:
                tv.setText("Reject");
                rejectOrder();
                break;

            default:
                break;
        }
    }

    private void getWidgets() {
        intent = getIntent();
        apiURL = getString(R.string.api_url);
        requestQueue = Volley.newRequestQueue(this);

        tv = (TextView) findViewById(R.id.tv);
        btnAccept = (Button) findViewById(R.id.btnAccept);
        btnReject = (Button) findViewById(R.id.btnReject);
        orderAction = (LinearLayout) findViewById(R.id.orderAction);

        btnAccept.setOnClickListener(this);
        btnReject.setOnClickListener(this);

        progress = new ProgressDialog(this);
        progress.setTitle("Loading");
        progress.setMessage("Đang gửi yêu cầu...");
        progress.setCancelable(false);
    }

    private void hideNotification() {
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.cancel(getIntent().getIntExtra("NOTIFICATION_ID", -1));
    }

    private void rejectOrder() {
        Toast.makeText(this, "Từ chối đơn hàng thành công", Toast.LENGTH_SHORT).show();
        finish();
    }

    private void acceptOrder() {
        try {
            progress.show();

            int orderId = intent.getIntExtra("ORDER_ID", 0);

            if (orderId <= 0) {
                throw new Exception("Order ID not found");
            }

            JSONObject params = new JSONObject();
            params.put("shipper_id", 12);

            JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.PUT,
                apiURL + "orders/" + 1,
                params,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Order", response.toString());

                        Toast.makeText(OrderRequestActivity.this, "Chấp nhận đơn hàng thành công", Toast.LENGTH_SHORT).show();
                        orderAction.removeAllViews();
                        View child = getLayoutInflater().inflate(R.layout.order_status, null);
                        orderAction.addView(child);

                        progress.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Order", error.toString());
                    }
                }
            );

            requestQueue.add(objectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAccept:
                acceptOrder();
                break;

            case R.id.btnReject:
                rejectOrder();
                break;
        }
    }
}
