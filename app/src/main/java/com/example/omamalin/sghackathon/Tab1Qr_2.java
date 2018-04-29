package com.example.omamalin.sghackathon;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
public class Tab1Qr_2 extends AppCompatActivity{
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab1qr_2);
        imageView = (ImageView)this.findViewById(R.id.imageView);
        Bitmap bitmap = getIntent().getParcelableExtra("pic");
        imageView.setImageBitmap(bitmap);
    }
}
