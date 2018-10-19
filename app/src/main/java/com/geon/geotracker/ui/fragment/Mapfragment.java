package com.geon.geotracker.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geon.geotracker.AppGlobal;
import com.geon.geotracker.R;

public class Mapfragment extends BaseMapFragment {

    private View mView;
    private AppGlobal mGlobals;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.map_fragment,container,false);

        mGlobals = ((AppGlobal)getActivity().getApplicationContext());


        Toolbar toolbar = (Toolbar)mView.findViewById(R.id.app_bar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle("Deals");
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setHasOptionsMenu(true);


        DrawerLayout drawer = (DrawerLayout) activity.findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(), drawer, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        TextView mtv = (TextView)mView.findViewById(R.id.vehicle_id);
        mtv.setText("dhk-working");


        buildGoogleApiClient();
        if (checkPlayServices()) {
            Log.e("=====google api======","ase google api");
            buildGoogleApiClient();
        }



        return mView;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_navigation, menu);
    }
}
