package com.example.thedanileron.howtobeslugabed;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    String[] steps = new String[0];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);

        RecyclerView rv= (RecyclerView) findViewById(R.id.my_recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(this));

        MyAdapter adapter=new MyAdapter(this, new ArrayList<>(Arrays.asList(steps)), rv);
        rv.setAdapter(adapter);

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1, steps);
//
//        setInitialImage();
//        ListView listView = findViewById(R.id.listView);
//        listView.setAdapter(adapter);

//        listView.setOnItemClickListener(new MyListClickListener());
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        steps = getResources().getStringArray(R.array.steps);
        return super.onCreateView(name, context, attrs);
    }

    private void setInitialImage() {
//        final ImageView imageView = (ImageView) findViewById(R.id.imageDisplay);
//        int mainImage = R.drawable.main_image;
//        imageView.setImageResource(mainImage);
    }

    private class MyListClickListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            Intent intent = new Intent(getBaseContext(), StepDescription.class);
            intent.putExtra("CAT_NAME", steps[position]);
            startActivity(intent);
        }
    }
}
