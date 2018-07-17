package com.example.thedanileron.howtobeslugabed;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] catNames = new String[0];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, catNames);

        setInitialImage();
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new MyListClickListener());
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        catNames = getResources().getStringArray(R.array.steps);
        return super.onCreateView(name, context, attrs);
    }

    private void setInitialImage() {
        final ImageView imageView = (ImageView) findViewById(R.id.imageDisplay);
        int mainImage = R.drawable.main_image;
        imageView.setImageResource(mainImage);
    }

    private class MyListClickListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            Intent intent = new Intent(getBaseContext(), StepDescription.class);
            intent.putExtra("CAT_NAME", catNames[position]);
            startActivity(intent);
        }
    }
}
