package com.juanjose.rappiapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.juanjose.rappiapp.model.dao.ManagerConnection;
import com.juanjose.rappiapp.model.dao.daoListener.onListener;
import com.juanjose.rappiapp.model.dto.MainDto;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements onListener {

    ManagerConnection managerConnection = new ManagerConnection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        managerConnection.sendRequest(this);
    }

    @Override
    public void onWebServiceResponse(MainDto data) {
        Log.i("api connect", "succes data..."+data.getInfo().get(0).getCategory());
    }
}
