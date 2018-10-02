function initMap(){
 var pyrmont= { lat: -2.142, lng: -79.9140};
	var panel= document.getElementById('map');	
	map= new google.maps.Map(panel, {
		center: pyrmont,
		zoom: 15
	});
	
	 
         
	
	
	
	var services= new google.maps.places.PlacesService(map);	
services.nearbySearch({
	location: pyrmont,
	radius: 500,
		types: ['store']
},callback);	

infowindow = new google.maps.InfoWindow();





}
function callback(results,status){
	if(status== google.maps.places.PlacesServiceStatus.OK){
		for(var i=0; i< results.length;i++){
			createMarker(results[i]);
		}
	}	
}
function createMarker(place)
{	
	var marker= new google.maps.Marker({
		map: map,
		position: place.geometry.location		
	});	
	
	google.maps.event.addListener(marker, 'click', function(){
		infowindow.setContent(place.name + place.geometry.location.lng());
		infowindow.open(map,this);
		
			var latitude = place.geometry.location.lat();
			var longitude = place.geometry.location.lng(); 

		 var pyrmont2=  { lat: latitude, lng: longitude};
		 
		var panorama = new google.maps.StreetViewPanorama(
            document.getElementById('pano'), {
              position: pyrmont2,
              pov: {
                heading: 34,
                pitch: 10
              }
            });
        map.setStreetView(panorama);
		
	});
	
	
}
