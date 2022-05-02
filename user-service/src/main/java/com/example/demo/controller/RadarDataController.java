package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RadarEntity;

import com.example.demo.service.RadarDataService;
import com.google.gson.Gson;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path="/radarcontroller")
public class RadarDataController {
	@Autowired
	private RadarDataService dataService;

	@GetMapping(path = "/getdata/{userName}/{page}")
	public List<RadarEntity> getData(@PathVariable String userName, int page) {
		return dataService.getData(userName, page);
	}

	@PostMapping(path = "/saveradar")
	public ResponseEntity saveRadar(@RequestBody RadarEntity radarData) {

		dataService.saveData(radarData);
		return ResponseEntity.ok(HttpStatus.OK);
	}

	@GetMapping(path = "/radarlocations")
	public String radarLocations() {
		Gson gson = new Gson(); 
		String json = "{\"KBLX\":\"BILLINGS, MT\",\"KABR\":\"ABERDEEN, SD\",\"KRTX\":\"PORTLAND, OR\",\"KBUF\":\"BUFFALO, NY\",\"KMRX\":\"MORRISTOWN, TN\",\"KVTX\":\"LOS ANGELES, CA\",\"KABX\":\"ALBUQUERQUE, NM\",\"KRLX\":\"CHARLESTON, WV\",\"KSFX\":\"SPRINGFIELD, ID\",\"KESX\":\"LAS VEGAS, NV\",\"KAKQ\":\"WAKEFIELD, VA\",\"KLWX\":\"STERLING, VA\",\"KJKL\":\"JACKSON, KY\",\"KFSX\":\"FLAGSTAFF, AZ\",\"KMAF\":\"MIDLAND, TX\",\"KLOT\":\"ROMEOVILLE, IL\",\"KMQT\":\"NEGAUNEE, MI\",\"KTWX\":\"TOPEKA, KS\",\"KDGX\":\"BRANDON, MS\",\"KFTG\":\"FRONT RANGE AP, CO\",\"KHGX\":\"DICKINSON, TX\",\"KLGX\":\"LANGLEY HILL, WA\",\"KEAX\":\"PLEASANT HILL, MO\",\"KFCX\":\"ROANOKE, VA\",\"KNKX\":\"SAN DIEGO, CA\",\"KMAX\":\"MEDFORD, OR\",\"KARX\":\"LA CROSSE, WI\",\"KLBB\":\"LUBBOCK, TX\",\"KILN\":\"WILMINGTON, OH\",\"KLRX\":\"ELKO, NV\",\"KMTX\":\"SALT LAKE CITY, UT\",\"KILX\":\"LINCOLN, IL\",\"KAMA\":\"AMARILLO, TX\",\"KCYS\":\"CHEYENNE, WY\",\"KFWS\":\"FORT WORTH, TX\",\"KSHV\":\"SHREVEPORT, LA\",\"KOHX\":\"OLD HICKORY, TN\",\"KGYX\":\"GRAY, ME\",\"KUDX\":\"NEW UNDERWOOD, SD\",\"KTBW\":\"RUSKIN, FL\",\"KPBZ\":\"CORAOPOLIS, PA\",\"KBGM\":\"BINGHAMTON, NY\",\"KCAE\":\"WEST COLUMBIA, SC\",\"KBMX\":\"ALABASTER, AL\",\"KSGF\":\"SPRINGFIELD, MO\",\"KMSX\":\"MISSOULA, MT\",\"KDIX\":\"FORT DIX, NJ\",\"KMKX\":\"DOUSMAN, WI\",\"KICT\":\"WICHITA, KS\",\"KPAH\":\"PADUCAH, KY\",\"KGGW\":\"GLASGOW, MT\",\"KICX\":\"CEDAR CITY, UT\",\"KLZK\":\"NORTH LITTLE ROCK, AR\",\"KSOX\":\"SANTA ANA MOUNTAINS, CA\",\"KLIX\":\"SLIDELL, LA\",\"KDAX\":\"DAVIS, CA\",\"KATX\":\"EVERETT, WA\",\"KCXX\":\"COLCHESTER, VT\",\"KFFC\":\"PEACHTREE CITY, GA\",\"KMLB\":\"MELBOURNE, FL\",\"KHTX\":\"HYTOP, AL\",\"KBHX\":\"EUREKA, CA\",\"KLTX\":\"SHALLOTTE, NC\",\"KTLH\":\"TALLAHASSEE, FL\",\"KMVX\":\"GRAND FORKS, ND\",\"KENX\":\"EAST BERNE, NY\",\"KGJX\":\"GRAND JUNCTION, CO\",\"KINX\":\"INOLA, OK\",\"KIWA\":\"PHOENIX, AZ\",\"KSRX\":\"CHAFFEE RIDGE, AR\",\"KCBX\":\"BOISE, ID\",\"KCBW\":\"HOULTON, ME\",\"KNQA\":\"MILLINGTON, TN\",\"KSJT\":\"SAN ANGELO, TX\",\"KBYX\":\"BOCA CHICA KEY, FL\",\"KTLX\":\"OKLAHOMA CITY, OK\",\"KMOB\":\"MOBILE, AL\",\"KPDT\":\"PENDLETON, OR\",\"KEWX\":\"NEW BRAUNFELS, TX\",\"KGSP\":\"GREER, SC\",\"KIWX\":\"NORTH WEBSTER, IN\",\"KAMX\":\"MIAMI, FL\",\"KBOX\":\"TAUNTON, MA\",\"KLSX\":\"WELDON SPRING, MO\",\"KLCH\":\"LAKE CHARLES, LA\",\"KEMX\":\"TUCSON, AZ\",\"KMUX\":\"LOS GATOS, CA\",\"KGRB\":\"GREEN BAY, WI\",\"KVWX\":\"OWENSVILLE, IN\",\"KYUX\":\"YUMA, AZ\",\"KCRP\":\"CORPUS CHRISTI, TX\",\"KDLH\":\"DULUTH, MN\",\"KIND\":\"INDIANAPOLIS, IN\",\"KOAX\":\"VALLEY, NE\",\"KDDC\":\"DODGE CITY, KS\",\"KRGX\":\"NIXON, NV\",\"KDTX\":\"WHITE LAKE, MI\",\"KUEX\":\"BLUE HILL, NE\",\"KGRR\":\"GRAND RAPIDS, MI\",\"KLVX\":\"FORT KNOX, KY\",\"KHNX\":\"HANFORD, CA\",\"KCLX\":\"GRAYS, SC\",\"KEPZ\":\"SANTA TERESA, NM\",\"KLNX\":\"NORTH PLATTE, NE\",\"KMPX\":\"CHANHASSEN, MN\",\"KOTX\":\"SPOKANE, WA\",\"KFSD\":\"SIOUX FALLS, SD\",\"KMHX\":\"NEWPORT, NC\",\"KTFX\":\"GREAT FALLS, MT\",\"KBIS\":\"BISMARCK, ND\",\"KDMX\":\"JOHNSTON, IA\",\"KPUX\":\"PUEBLO, CO\",\"KCCX\":\"STATE COLLEGE, PA\",\"KDVN\":\"DAVENPORT, IA\",\"KCLE\":\"CLEVELAND, OH\",\"KOKX\":\"UPTON, NY\",\"KJAX\":\"JACKSONVILLE, FL\",\"KRIW\":\"RIVERTON, WY\",\"KGLD\":\"GOODLAND, KS\",\"KBRO\":\"BROWNSVILLE, TX\",\"KAPX\":\"GAYLORD, MI\",\"KRAX\":\"CLAYTON, NC\"}";//gson.toJson(dataService.radarLocations()); 
		//json=json.replace("\n", "").replace("\r", "");
		return json;
	}
}
