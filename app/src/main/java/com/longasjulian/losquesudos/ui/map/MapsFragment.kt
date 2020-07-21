package com.longasjulian.losquesudos.ui.map

import android.Manifest
import android.content.pm.PackageManager
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PointOfInterest
import com.longasjulian.losquesudos.R

class MapsFragment : Fragment(), GoogleMap.OnPoiClickListener {

    private lateinit var mMap: GoogleMap

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */

        mMap = googleMap
        mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
        mMap.uiSettings.isZoomControlsEnabled= true
        mMap.setOnPoiClickListener(this)
        activarMiUbicacion()

        val Tienda_Poblado = LatLng(6.1945321, -75.5761618)
        googleMap.addMarker(MarkerOptions().position(Tienda_Poblado).title("Sede Poblado"))
        val Tienda_America = LatLng(6.2501439,-75.6092471)
        googleMap.addMarker(MarkerOptions().position(Tienda_America).title("Sede América"))
        val Tienda_Laureles = LatLng(6.2446271,-75.5893939)
        googleMap.addMarker(MarkerOptions().position(Tienda_Laureles).title("Sede Laureles"))
        val Tienda_Belen = LatLng(6.2241329,-75.5994588)
        googleMap.addMarker(MarkerOptions().position(Tienda_Belen).title("Sede Belén"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Tienda_Belen,12F))
        val Tienda_Envigado = LatLng(6.1689433,-75.5939257)
        googleMap.addMarker(MarkerOptions().position(Tienda_Envigado).title("Sede Envigado"))
        val Tienda_Bello = LatLng(6.3362843,-75.5597451)
        googleMap.addMarker(MarkerOptions().position(Tienda_Bello).title("Sede Bello"))
        val Tienda_Sabaneta = LatLng(6.1514239,-75.6225165)
        googleMap.addMarker(MarkerOptions().position(Tienda_Sabaneta).title("Sede Sabaneta"))
        val Tienda_itagui = LatLng(6.1722142,-75.6117091)
        googleMap.addMarker(MarkerOptions().position(Tienda_itagui).title("Sede Itagüi"))
    }

    private fun activarMiUbicacion() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        mMap.isMyLocationEnabled = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    override fun onPoiClick(p0: PointOfInterest?) {
        requireContext()
    }
}