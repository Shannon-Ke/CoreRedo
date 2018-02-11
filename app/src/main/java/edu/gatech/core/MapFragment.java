package edu.gatech.core;


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
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap map;

    public MapFragment() {
        // Required empty public constructor
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
        MarkerOptions option1 = new MarkerOptions();
        MarkerOptions option2 = new MarkerOptions();

        // add GT marker
        LatLng gt = new LatLng(33.775466, -84.396264);
        option.position(gt).title("Georgia Tech");
        map.addMarker(option);

        // add Ferst marker
        LatLng ferst = new LatLng(33.775232, -84.399322);
        option1.position(ferst).title("Nufonia Must Fall").snippet("February 13, 2018 \n 7:30PM-9:00PM");
        map.addMarker(option1);

        // add McCamish marker
        LatLng mccamish = new LatLng(33.780907, -84.392836);
        option2.position(mccamish).title("Women's Basketball Game").snippet("February 15, 2018 \n 7:00PM-9:00PM");
        map.addMarker(option2);

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(gt, 15));
    }
}
