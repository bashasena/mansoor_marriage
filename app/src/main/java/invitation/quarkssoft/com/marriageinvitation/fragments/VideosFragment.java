package invitation.quarkssoft.com.marriageinvitation.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import invitation.quarkssoft.com.marriageinvitation.R;
import invitation.quarkssoft.com.marriageinvitation.constansts.NavigationDrawerConstants;


public class VideosFragment extends Fragment implements OnMapReadyCallback {

    MapView mapView;
    GoogleMap map;
    private static final String MAP_VIEW_BUNDLE_KEY = "MapViewBundleKey";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(NavigationDrawerConstants.TAG_HOME_TITLE);
        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAP_VIEW_BUNDLE_KEY);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_videos, container, false);

        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAP_VIEW_BUNDLE_KEY);
        }
        mapView = (MapView) v.findViewById(R.id.map_view_location);
        mapView.onCreate(mapViewBundle);
        mapView.getMapAsync(this); //this is important

        return v;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.setMinZoomPreference(12);
        map.setIndoorEnabled(true);
        UiSettings uiSettings = map.getUiSettings();
        uiSettings.setIndoorLevelPickerEnabled(true);
        uiSettings.setMyLocationButtonEnabled(true);
        uiSettings.setMapToolbarEnabled(true);
        uiSettings.setCompassEnabled(true);
        uiSettings.setZoomControlsEnabled(true);

        Double latD=Double.parseDouble(getResources().getString(R.string.lat_location));
        Double longD=Double.parseDouble(getResources().getString(R.string.long_location));

        Log.i("Latitude",latD+"");
        Log.i("Longtitude",longD+"");
        LatLng ny = new LatLng(latD, longD);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(ny);
        map.addMarker(markerOptions);

        map.moveCamera(CameraUpdateFactory.newLatLng(ny));

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        Bundle mapViewBundle = outState.getBundle(MAP_VIEW_BUNDLE_KEY);
        if (mapViewBundle == null) {
            mapViewBundle = new Bundle();
            outState.putBundle(MAP_VIEW_BUNDLE_KEY, mapViewBundle);
        }

        mapView.onSaveInstanceState(mapViewBundle);

    }
}
