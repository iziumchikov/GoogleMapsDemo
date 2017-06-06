package demo.googlemapsdemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MapActivity extends Activity
{
    private EditText slan, slon;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        slan = (EditText) findViewById(R.id.slat);
        slon = (EditText) findViewById(R.id.slon);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        slan.setText("");
        slon.setText("");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }

    public void showMap(View v)
    {
        String lan = slan.getText().toString();
        String lon = slon.getText().toString();

        if(lan.isEmpty() || lon.isEmpty())
        {
            lan = "38.8891";
            lon = "-77.0492";
        }
        Uri uri = Uri.parse("geo:" + lan + "," + lon);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}
