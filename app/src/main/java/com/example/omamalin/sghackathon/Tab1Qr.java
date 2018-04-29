package com.example.omamalin.sghackathon;
import android.support.v4.app.Fragment;
//import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;


public class Tab1Qr extends Fragment {
    private Button button;
    private EditText nameText;
    private EditText phoneText;
    //Twizo twizo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.tab1qr,container,false);

        final Context context = getActivity();
        nameText = (EditText) rootView.findViewById(R.id.nameText);
        phoneText = (EditText) rootView.findViewById(R.id.phoneText);
        button = (Button) rootView.findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String text2Qr = nameText.getText().toString();
//                String text2Qr = "BIZCARD:N:Sean;X:Owen;T:Software Engineer;C:Google;A:76 9th Avenue, New York, NY";
                String text2Qr = "MECARD:N:" + nameText.getText().toString() + ";ADR:76 9th Avenue, 4th Floor, New York, NY 10011;TEL:" + phoneText.getText().toString() + ";EMAIL:john.doe@example.com;";
                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try {
                    BitMatrix bitMatrix = multiFormatWriter.encode(text2Qr, BarcodeFormat.QR_CODE, 200, 200);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    Intent intent = new Intent(context, Tab1Qr_2.class);
                    intent.putExtra("pic", bitmap);
                    context.startActivity(intent);
                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });
        return rootView;
    }

}
