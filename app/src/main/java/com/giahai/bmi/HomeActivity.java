package com.giahai.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    TextView tvBMI,tvMucDo;
    EditText edtCanNang, edtChieuCao;
    Button btnKQ;
    String a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvBMI = (TextView) findViewById(R.id.tvBMI);
        tvMucDo = (TextView) findViewById(R.id.tvMucDo);
        edtCanNang = (EditText) findViewById(R.id.edtCanNang);
        edtChieuCao = (EditText) findViewById(R.id.edtChieuCao);
        btnKQ = (Button) findViewById(R.id.button);
        btnKQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtCanNang.equals("") || edtChieuCao.equals("") || edtCanNang.length() == 0 || edtChieuCao.length() == 0){
                    Toast.makeText(HomeActivity.this,"Vui lòng nhập đầy đủ thông tin",Toast.LENGTH_LONG).show();
                }else {
                    dochisoBMI();
                }
            }
        });
    }
    public void dochisoBMI(){
        a = edtCanNang.getText().toString();
        b = edtChieuCao.getText().toString();
        Float sa = Float.parseFloat(a);
        Float sb = Float.parseFloat(b);
        Float c = sa/(sb*sb);
        if(c < 18.5){
            tvBMI.setText(" "+ c);
            tvMucDo.setText("Gầy, nguy cơ phát triển bệnh Thấp");
        } else if( c >= 18.5 && c <= 24.9){
            tvBMI.setText(" "+ c);
            tvMucDo.setText("Bình thường, nguy cơ phát triển bệnh Trung bình");
        } else if( c >= 25.0 && c <= 29.9){
            tvBMI.setText(" "+ c);
            tvMucDo.setText("Hơi béo, nguy cơ phát triển bệnh Cao");
        } else if( c >= 30.0 && c <= 34.9){
            tvBMI.setText(" "+ c);
            tvMucDo.setText("Béo phì cấp độ 1, nguy cơ phát triển bệnh Cao");
        } else if( c >= 35.0 && c <= 39.9){
            tvBMI.setText(" "+ c);
            tvMucDo.setText("Béo phì cấp độ 2, nguy cơ phát triển bệnh Cao");
        } else if( c > 40.0){
            tvBMI.setText(" "+ c);
            tvMucDo.setText("Béo phì cấp độ 3, nguy cơ phát triển bệnh Nguy hiểm");
        }
    }
}
