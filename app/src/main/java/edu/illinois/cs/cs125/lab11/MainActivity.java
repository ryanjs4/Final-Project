package edu.illinois.cs.cs125.lab11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Main class for our UI design lab.
 */
public final class MainActivity extends AppCompatActivity {
    /** Default logging tag for messages from the main activity. */
    private static final String TAG = "FinalProject:Main";

    /** Request queue for our API requests. */
    private static RequestQueue requestQueue;

    /** Request queue for our API requests. */
    private TextView quoteText;
    /** Request queue for our API requests. */
    private TextView authorText;
    /** Request queue for our API requests. */
    private Button quoteOfTheDay;
    /** Request queue for our API requests. */
    private Button inspirational;
    /** Request queue for our API requests. */
    private Button funny;
    /** Request queue for our API requests. */
    private Button sports;
    /** Request queue for our API requests. */
    private Button life;

    /**
     * Run when this activity comes to the foreground.
     *
     * @param savedInstanceState unused
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set up the queue for our API requests
        requestQueue = Volley.newRequestQueue(this);

        setContentView(R.layout.activity_main);

        quoteText = findViewById(R.id.quote);
        authorText = findViewById(R.id.author);

        quoteOfTheDay = findViewById(R.id.qOD);
        quoteOfTheDay.setOnClickListener(v -> {
            Log.d(TAG, "Quote of the Day Button");
            quoteOfTheDay("");
        });

        inspirational = findViewById(R.id.inspiration);
        inspirational.setOnClickListener(v -> {
            Log.d(TAG, "Quote of the Day Button");
            quoteOfTheDay("");
        });

        funny = findViewById(R.id.fun);
        funny.setOnClickListener(v -> {
            Log.d(TAG, "Quote of the Day Button");
            quoteOfTheDay("");
        });

        sports = findViewById(R.id.sport);
        sports.setOnClickListener(v -> {
            Log.d(TAG, "Quote of the Day Button");
            quoteOfTheDay("");
        });

        life = findViewById(R.id.life);
        life.setOnClickListener(v -> {
            Log.d(TAG, "Quote of the Day Button");
            quoteOfTheDay("");
        });
    }

    /**
     * Run when this activity is no longer visible.
     */
    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     * Make a call for the quote of the day
     *
     * @param category IP address to look up
     */

    //theysaidso.com/api/#
    void quoteOfTheDay(final String category) {
        try {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    "https://quotes.rest/qod" + category + ".json",
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(final JSONObject response) {
                            quoteOfDayDone(response);
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(final VolleyError error) {
                            Log.e(TAG, error.toString());
                        }
                    });

            jsonObjectRequest.setShouldCache(false);
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handle the response from our IP geolocation API.
     *
     * @param response response from our IP geolocation API.
     */
    void quoteOfDayDone(final JSONObject response) {
        try {
            Log.d(TAG, response.toString(2));
            // Example of how to pull a field off the returned JSON object
            //Log.i(TAG, response.get("hostname").toString());
            String quote = response.getJSONObject("contents").getJSONArray("quotes").getJSONObject(0).getString("quote");
            System.out.println(quote);
            String author = response.getJSONObject("contents").getJSONArray("quotes").getJSONObject(0).getString("author");
            quoteText.setText(quote + "~" + author);
            authorText.setText("~" + author);
        } catch (JSONException ignored) { }
    }

    /**
     * Handle the response from our IP geolocation API.
     *
     * @param response response from our IP geolocation API.
     */
    void inspirational(final JSONObject response) {
        try {
            Log.d(TAG, response.toString(2));
            // Example of how to pull a field off the returned JSON object
            //Log.i(TAG, response.get("hostname").toString());
            String quote = response.getJSONObject("contents").getJSONArray("quotes").getJSONObject(0).getString("quote");
            System.out.println(quote);
            String author = response.getJSONObject("contents").getJSONArray("quotes").getJSONObject(0).getString("author");
            quoteText.setText(quote + "~" + author);
            authorText.setText("~" + author);
        } catch (JSONException ignored) { }
    }

    /**
     * Handle the response from our IP geolocation API.
     *
     * @param response response from our IP geolocation API.
     */
    void funny(final JSONObject response) {
        try {
            Log.d(TAG, response.toString(2));
            // Example of how to pull a field off the returned JSON object
            //Log.i(TAG, response.get("hostname").toString());
            String quote = response.getJSONObject("contents").getJSONArray("quotes").getJSONObject(0).getString("quote");
            System.out.println(quote);
            String author = response.getJSONObject("contents").getJSONArray("quotes").getJSONObject(0).getString("author");
            quoteText.setText(quote + "  " + author);
            authorText.setText("  " + author);
        } catch (JSONException ignored) { }
    }

    /**
     * Handle the response from our IP geolocation API.
     *
     * @param response response from our IP geolocation API.
     */
    void sports(final JSONObject response) {
        try {
            Log.d(TAG, response.toString(2));
            // Example of how to pull a field off the returned JSON object
            //Log.i(TAG, response.get("hostname").toString());
            String quote = response.getJSONObject("contents").getJSONArray("quotes").getJSONObject(0).getString("quote");
            System.out.println(quote);
            String author = response.getJSONObject("contents").getJSONArray("quotes").getJSONObject(0).getString("author");
            quoteText.setText(quote + "-" + author);
            authorText.setText("-" + author);
        } catch (JSONException ignored) { }
    }

    /**
     * Handle the response from our IP geolocation API.
     *
     * @param response response from our IP geolocation API.
     */
    void life(final JSONObject response) {
        try {
            Log.d(TAG, response.toString(2));
            // Example of how to pull a field off the returned JSON object
            //Log.i(TAG, response.get("hostname").toString());
            String quote = response.getJSONObject("contents").getJSONArray("quotes").getJSONObject(0).getString("quote");
            System.out.println(quote);
            String author = response.getJSONObject("contents").getJSONArray("quotes").getJSONObject(0).getString("author");
            quoteText.setText(quote + "+" + author);
            authorText.setText("+" + author);
        } catch (JSONException ignored) { }
    }
}
