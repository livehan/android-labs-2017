package edu.hzuapps.androidlabs.homeworks.net1409081602222;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Net1409081602222ApplyCertificateActivity extends AppCompatActivity {

    EditText etName;
    EditText etTime;

    Button btSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_certificate_net1409081602222);

        etName= (EditText) findViewById(R.id.et_project_name);
        etTime= (EditText) findViewById(R.id.et_project_time);

        btSubmit= (Button) findViewById(R.id.bt_submit);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=etName.getText().toString();
                String time=etTime.getText().toString();

                if(check(name)){
                    Net1409081602222Helper net1409081602222Helper =new Net1409081602222Helper(Net1409081602222ApplyCertificateActivity.this);
                    ContentValues values=new ContentValues();
                    values.put("name",name);
                    values.put("apply_time",time);
                    net1409081602222Helper.getWritableDatabase().insert("certificate",null,values);
                    Toast.makeText(Net1409081602222ApplyCertificateActivity.this,"申请成功，请等待审核！！",Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(Net1409081602222ApplyCertificateActivity.this,"工程类型错误！！",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean check(String name){
        return true;
    }
}
