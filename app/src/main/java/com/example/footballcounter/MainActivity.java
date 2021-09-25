package com.example.footballcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private int arg = 0;
private int jam = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        resetUI();
    }

    @Override
    protected void onSaveInstanceState(Bundle outstate) {
        super.onSaveInstanceState(outstate);
        outstate.putInt("argcount", arg);
        outstate.putInt("jamcount", jam);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null &&
                savedInstanceState.containsKey("argcount")&&savedInstanceState.containsKey("jamcount")) {
            arg = savedInstanceState.getInt("argcount");
            jam = savedInstanceState.getInt("jamcount");}


    }

    private void resetUI() {
        ((TextView) findViewById(R.id.jam)).setText("" + jam);
        ((TextView) findViewById(R.id.arg)).setText("" + arg);
    }



    public void addArg(View view) {
        arg++;
        TextView counterView = (TextView)findViewById(R.id.arg);
        counterView.setText(""+arg);
    }
    public void addJam(View view) {
        jam++;
        TextView counterView = (TextView)findViewById(R.id.jam);
        counterView.setText(""+jam);
    }
    public void resetAll(View view) {
        arg=0;
        jam=0;
        TextView counterView = (TextView)findViewById(R.id.arg);
        counterView.setText(""+arg);
        counterView = (TextView)findViewById(R.id.jam);
        counterView.setText(""+jam);
    }
}