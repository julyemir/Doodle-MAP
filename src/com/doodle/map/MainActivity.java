package com.doodle.map;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity {
	private LocationManager lm;
	private GoogleMap mMap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		mMap = ((SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map)).getMap();
		// .findFragmentById(
		// R.id.map)).getMap();
		// mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Criteria c = new Criteria();
		lm.requestLocationUpdates(lm.getBestProvider(c, true), 0, 0,
				new LocationListener() {

					@Override
					public void onStatusChanged(String arg0, int arg1,
							Bundle arg2) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onProviderEnabled(String arg0) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onProviderDisabled(String arg0) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onLocationChanged(Location arg0) {
						// TODO Auto-generated method stub
						Log.e("location changed", "" + arg0.getLatitude());
						Log.e("location changed", "" + arg0.getLongitude());
						MarkerOptions mMarker = new MarkerOptions()
								.position(new LatLng(arg0.getLatitude(), arg0
										.getLongitude()));
						mMap.addMarker(mMarker);
						mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
								mMarker.getPosition(), 0));

					}
				});
	}
}