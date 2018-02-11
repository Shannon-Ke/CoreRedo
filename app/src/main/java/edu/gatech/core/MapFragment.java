package edu.gatech.core;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    GoogleMap map;

    public MapFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_map, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        MarkerOptions option = new MarkerOptions();

        // add GT marker
        LatLng gt = new LatLng(33.775466, -84.396264);
        option.position(gt).title("Georgia Tech");
        map.addMarker(option);

        // add Ferst marker
        LatLng ferst = new LatLng(33.775232, -84.399322);
        option.position(ferst).title("Nufonia Must Fall").snippet("tap for details");
        map.addMarker(option);

        // add McCamish marker
        LatLng mccamish = new LatLng(33.780907, -84.392836);
        option.position(mccamish).title("Women's Basketball: GT v NCU").snippet("tap for details");
        map.addMarker(option);

        // add CCF marker
        LatLng ccf = new LatLng(33.775847, -84.391643);
        option.position(ccf).title("Thursday Night Dinners").snippet("tap for details");
        map.addMarker(option);

        // add Student Center marker
        LatLng studentCenter = new LatLng(33.774201, -84.398877);
        option.position(studentCenter).title("Q-Chat: Men's Group").snippet("tap for details");
        map.addMarker(option);

        map.moveCamera(CameraUpdateFactory.newLatLng(gt));
        map.setOnInfoWindowClickListener(this);
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Intent myIntent = new Intent(this.getActivity(), EventPageActivity.class);
        startActivity(myIntent);
    }
}
