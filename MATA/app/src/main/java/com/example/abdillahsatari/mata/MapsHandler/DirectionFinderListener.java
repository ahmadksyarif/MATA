package com.example.abdillahsatari.mata.MapsHandler;

import com.example.abdillahsatari.mata.MapsFragment;

import java.util.List;

/**
 * Created by Mai Thanh Hiep on 4/3/2016.
 */
public interface DirectionFinderListener {
    void onDirectionFinderStart();
    void onDirectionFinderSuccess(List<Route> route);

    void getMap(MapsFragment mapsFragment);
}
