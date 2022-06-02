package com.example.utspraktik_if5_10119181_ramaramdani;
/*
 *     Nim : 10119181
 *     Nama : Rama Ramdani
 *     Tanggal Pengerjaan : 2 Juni 2022
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    EditText edit_nik, edit_nama, edit_tgl_lahir,tgl_konfirmasi;
    RadioButton radiolaki, radioperempuan, rortu, rnikah, ranak, rlainnya, rapid, rpcr;
    Button btn_simpan;
    String nik, nama, tgl_lahir, jkelamin, hub, jenistes, tgl_konfir;
    RadioGroup rg, rg2, jt;
    String tempJK, temp2, temp3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_nik=(EditText)findViewById(R.id.nik);
        edit_nama=(EditText)findViewById(R.id.nama);
        tgl_konfirmasi=(EditText)findViewById(R.id.tgl_konfirmasi);
        edit_tgl_lahir=(EditText)findViewById(R.id.tgl_lahir);

        rapid=(RadioButton)findViewById(R.id.RA);
        rapid.setOnClickListener(null);
        rpcr=(RadioButton)findViewById(R.id.PCR);
        rpcr.setOnClickListener(null);
        jt=(RadioGroup)findViewById(R.id.jt);
        jt.setOnCheckedChangeListener(this::onCheckedChanged);

        radiolaki=(RadioButton)findViewById(R.id.cowo);
        radiolaki.setOnClickListener(null);
        radioperempuan=(RadioButton)findViewById(R.id.cewe);
        radioperempuan.setOnClickListener(null);
        rg=(RadioGroup)findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(this::onCheckedChanged1);

        rortu=(RadioButton)findViewById(R.id.ortu);
        rnikah=(RadioButton)findViewById(R.id.nikah);
        ranak=(RadioButton)findViewById(R.id.anak);
        rlainnya=(RadioButton)findViewById(R.id.lainnya);
        rg2=(RadioGroup)findViewById(R.id.rg2) ;
        rg2.setOnCheckedChangeListener(this::onCheckedChanged2);




        btn_simpan=(Button)findViewById(R.id.simpan);
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tgl_konfir=tgl_konfirmasi.getText().toString();
                nik=edit_nik.getText().toString();
                nama=edit_nama.getText().toString();
                tgl_lahir=edit_tgl_lahir.getText().toString();
                jkelamin=tempJK.toString();
                jenistes=temp3.toString();
                hub=temp2.toString();



                Intent i = new Intent(getApplicationContext(),MainActivity2.class);
                i.putExtra("Jenis Tes", jenistes);
                i.putExtra("Tanggal Terkonfirmasi", tgl_konfir);
                i.putExtra("Nik", nik);
                i.putExtra("Nama", nama);
                i.putExtra("Tgl_lahir", tgl_lahir);
                i.putExtra("Jk", jkelamin);
                i.putExtra("Hub", hub);
                startActivity(i);

            }
        });
    }
    public void onCheckedChanged(RadioGroup arg0, int arg1) {
        if(rapid.isChecked()){
            temp3 = "Rapid Antigen";
        }
        if(rpcr.isChecked()){
            temp3 = "PCR";
        }
    }

    public void onCheckedChanged1(RadioGroup arg0, int arg1) {
        if(radiolaki.isChecked()){
            tempJK = "Pria";
        }
        if(radioperempuan.isChecked()){
            tempJK = "Wanita";
        }
    }

    public void onCheckedChanged2(RadioGroup arg0, int arg1) {

        if(rortu.isChecked()){
            temp2 = "Orang Tua";
        }
        if(rnikah.isChecked()){
            temp2 = "Suami/Istri";
        }
        if(ranak.isChecked()){
            temp2 = "Anak";
        }
        if(rlainnya.isChecked()){
            temp2 = "Hubungan Lainnya";
        }
    }
}