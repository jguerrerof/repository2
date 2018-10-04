package org.primefaces.showcase.view.data.gmap;
 
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
 
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
 
@ManagedBean
public class MarkersView implements Serializable {
    
    private MapModel simpleModel;
  
    @PostConstruct
    public void init() {
        simpleModel = new DefaultMapModel();
          
        //Shared coordinates
        //LatLng coord1 = new LatLng(36.879466, 30.667648);
        LatLng coord1 = new LatLng(-2.060220, -79.877965);        
        LatLng coord2 = new LatLng(-2.1277843,-79.9042727);
        LatLng coord3 = new LatLng(-2.126074, -79.897165);
        LatLng coord4 = new LatLng(-2.146075, -79.901837); 
      //  LatLng coord3 = new LatLng(36.879703, 30.706707);
      //  LatLng coord4 = new LatLng(36.885233, 30.702323);
          
        //Basic marker
        simpleModel.addOverlay(new Marker(coord1, "Central - Urbanización Matices mz 6 villa 22"));
        simpleModel.addOverlay(new Marker(coord2, "Sucursal 1 - Sauces 8 mz 8 villa 6"));
        simpleModel.addOverlay(new Marker(coord3, "Sucursal 2 - Sauces 6 mz 7 villa 16 "));
        simpleModel.addOverlay(new Marker(coord4, "Sucursal 3 - Urdenor mz 3 villa 21"));
    }
  
    public MapModel getSimpleModel() {
        return simpleModel;
    }
}