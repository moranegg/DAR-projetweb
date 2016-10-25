<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<title>MAP</title>
<style type="text/css">
html { height: 100% }
body { height: 100%; margin: 0px; padding: 0px }
#map_canvas { width: 100%; height: 100% }
</style>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true&client=musexpress"></script>
<script type="text/javascript">
function initialize() {
	  map = new google.maps.Map(document.getElementById("map_canvas"), {
	        zoom: 19,
	        center: new google.maps.LatLng(48.858565, 2.347198),
	        mapTypeId: google.maps.MapTypeId.ROADMAP
	      });
	}

	if (navigator.geolocation)
	  var watchId = navigator.geolocation.watchPosition(successCallback,
	                            null,
	                            {enableHighAccuracy:true});
	else
	  alert("Votre navigateur ne prend pas en compte la géolocalisation HTML5");

	function successCallback(position){
	  map.panTo(new google.maps.LatLng(position.coords.latitude, position.coords.longitude));
	  var marker = new google.maps.Marker({
	    position: new google.maps.LatLng(position.coords.latitude, position.coords.longitude),
	    map: map
	  });
	}
</script>
</head>
<body onload="initialize()">
<!-- <div id="map_canvas"></div> -->

<iframe src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d167826.82315274!2d2.4458014!3d48.909788500000005!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sfr!2sfr!4v1477261004748" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
</body>

</html>

