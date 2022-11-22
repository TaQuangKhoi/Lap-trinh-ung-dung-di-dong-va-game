package com.taquangkhoi.tien_luyen_tay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.Priority;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPOutputStream;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap mMap;
    SupportMapFragment mapFragment;
    Spinner spinner;
    Geocoder geocoder;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestLocationPermissions();
        addControls();
        addEvents();
        //Hiện map trên màn hình
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void requestLocationPermissions() {
        //Kiểm tra SDK hiện tại có hỗ trợ quyền truy cập vị trí hay không
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //Nếu không hỗ trợ thì yêu cầu cấp quyền
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 100);
            }
        } else{
            addMyLocaiton();
        }
    }

    private void addEvents() {
    //Sự kiện của spinner
    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String type = parent.getItemAtPosition(position).toString();
            switch (type){
                case "Roadmap":
                    mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    break;
                case "Satellite":
                    mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                    break;
                case "Terrain":
                    mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                    break;
                case "Hybrid":
                    mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });
    addSearchView();
    }

    private void addSearchView() {
    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            try {
                List<Address> addressList = geocoder.getFromLocationName(query,1);
                if (addressList.size() > 0){
                    Address address = addressList.get(0);
                    LatLng latLng = new LatLng(address.getLatitude(),address.getLongitude());
                    mMap.addMarker(new MarkerOptions().position(latLng).title(query));
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    });
    }

    private void addControls() {
    spinner = findViewById(R.id.Spinner);
    searchView = findViewById(R.id.searchView);
    //Tạo mạng
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Roadmap");
        arrayList.add("Satellite");
        arrayList.add("Terrain");
        arrayList.add("Hybrid");
    //ArrayAdapter dùng để hiển thị dữ liệu
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayList);
        geocoder = new Geocoder(this);
        spinner.setAdapter(arrayAdapter);
    }
    // Hàm chạy khi Map đã sẵn sàng
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        //thêm nút Thu nhỏ, Phóng to
        mMap.getUiSettings().setZoomControlsEnabled(true);
        //thêm cử chỉ phóng to thu nhỏ
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        //thêm MyLocation Button
        addMyLocaiton();
    }

    private void addMyLocaiton() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                 && ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){
            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            addMyLocaiton();
            Toast.makeText(this, "Quyền đã chấp nhận", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Quyền đã từ chối", Toast.LENGTH_SHORT).show();
        }
    }
    //Method yêu cầu bật GPS
    private void requestLocation(){
        // LocationRequest Builder
        LocationRequest locationRequest = new LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY)
                    .setIntervalMillis(1000)
                    .build();

        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                    .addLocationRequest(locationRequest);

    }
}