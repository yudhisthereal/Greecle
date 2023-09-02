package com.ggroup.greecle.activities

import android.location.Location
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ggroup.greecle.R
import com.ggroup.greecle.adapters.StationAdapter

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.ggroup.greecle.databinding.ActivityMapsBinding
import com.ggroup.greecle.fragments.MapControlFragment
import com.ggroup.greecle.models.Station

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var stationRecyclerView: RecyclerView
    private lateinit var stationNames: Array<String>
    private lateinit var stationAvailabilities: Array<Boolean>
    private lateinit var stationCoords: Array<Location>
    private lateinit var stationsList: ArrayList<Station>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        stationNames = arrayOf("Stasiun Dau", "Stasiun Veteran", "Stasiun Sawojajar", "Stasiun Pahlawan", "Pusing Tolong")
        stationAvailabilities = arrayOf(true, false, true, true, true)

        val gpsProvider = LocationManager.GPS_PROVIDER
        val location1 = Location(gpsProvider)
        val location2 = Location(gpsProvider)
        val location3 = Location(gpsProvider)
        val location4 = Location(gpsProvider)
        val location5 = Location(gpsProvider)

        location1.latitude = -7.931851
        location1.longitude = 112.596709

        location2.latitude = -7.956865
        location2.longitude = 112.612439

        location3.latitude = -7.974901
        location3.longitude = 112.650036

        location4.latitude = -7.960135
        location4.longitude = 112.621169

        location5.latitude = -24.436064
        location5.longitude = 99.349678

        stationCoords = arrayOf(location1, location2, location3, location4, location5)

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val controls: MapControlFragment = supportFragmentManager
            .findFragmentById(R.id.mapControls) as MapControlFragment

        stationsList = arrayListOf()

        for (i in stationAvailabilities.indices) {
            val stationPos = LatLng(stationCoords[i].latitude, stationCoords[i].longitude)
            mMap.addMarker(MarkerOptions().position(stationPos).title(stationNames[i]))

            val station = Station(stationNames[i], stationCoords[i], stationAvailabilities[i])
            stationsList.add(station)
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLng(LatLng(stationCoords[0].latitude, stationCoords[0].longitude)))

        stationRecyclerView = findViewById(R.id.stationsList)
        stationRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        stationRecyclerView.setHasFixedSize(true)
        stationRecyclerView.adapter = StationAdapter(stationsList)
        Log.d("RecyclerView", "Recycler View's adapter attached")

    }
}