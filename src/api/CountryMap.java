package api;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CountryMap {

	private static final Map<String, Location> COUNTRY_LOCATION;
	static {
		/**
		 * Source: CIA World Factbook
		 */
		Map<String, Location> countryMap = new HashMap<String, Location>();
		countryMap.put("AD", new Location(42.5000, 1.5000));
		countryMap.put("AE", new Location(24.0000, 54.0000));
		countryMap.put("AF", new Location(33.0000, 65.0000));
		countryMap.put("AG", new Location(17.0500, -61.8000));
		countryMap.put("AI", new Location(18.2500, -63.1667));
		countryMap.put("AL", new Location(41.0000, 20.0000));
		countryMap.put("AM", new Location(40.0000, 45.0000));
		countryMap.put("AN", new Location(12.2500, -68.7500));
		countryMap.put("AO", new Location(-12.5000, 18.5000));
		countryMap.put("AP", new Location(35.0000, 105.0000));
		countryMap.put("AQ", new Location(-90.0000, 0.0000));
		countryMap.put("AR", new Location(-34.0000, -64.0000));
		countryMap.put("AS", new Location(-14.3333, -170.0000));
		countryMap.put("AT", new Location(47.3333, 13.3333));
		countryMap.put("AU", new Location(-27.0000, 133.0000));
		countryMap.put("AW", new Location(12.5000, -69.9667));
		countryMap.put("AZ", new Location(40.5000, 47.5000));
		countryMap.put("BA", new Location(44.0000, 18.0000));
		countryMap.put("BB", new Location(13.1667, -59.5333));
		countryMap.put("BD", new Location(24.0000, 90.0000));
		countryMap.put("BE", new Location(50.8333, 4.0000));
		countryMap.put("BF", new Location(13.0000, -2.0000));
		countryMap.put("BG", new Location(43.0000, 25.0000));
		countryMap.put("BH", new Location(26.0000, 50.5500));
		countryMap.put("BI", new Location(-3.5000, 30.0000));
		countryMap.put("BJ", new Location(9.5000, 2.2500));
		countryMap.put("BM", new Location(32.3333, -64.7500));
		countryMap.put("BN", new Location(4.5000, 114.6667));
		countryMap.put("BO", new Location(-17.0000, -65.0000));
		countryMap.put("BR", new Location(-10.0000, -55.0000));
		countryMap.put("BS", new Location(24.2500, -76.0000));
		countryMap.put("BT", new Location(27.5000, 90.5000));
		countryMap.put("BV", new Location(-54.4333, 3.4000));
		countryMap.put("BW", new Location(-22.0000, 24.0000));
		countryMap.put("BY", new Location(53.0000, 28.0000));
		countryMap.put("BZ", new Location(17.2500, -88.7500));
		countryMap.put("CA", new Location(60.0000, -95.0000));
		countryMap.put("CC", new Location(-12.5000, 96.8333));
		countryMap.put("CD", new Location(0.0000, 25.0000));
		countryMap.put("CF", new Location(7.0000, 21.0000));
		countryMap.put("CG", new Location(-1.0000, 15.0000));
		countryMap.put("CH", new Location(47.0000, 8.0000));
		countryMap.put("CI", new Location(8.0000, -5.0000));
		countryMap.put("CK", new Location(-21.2333, -159.7667));
		countryMap.put("CL", new Location(-30.0000, -71.0000));
		countryMap.put("CM", new Location(6.0000, 12.0000));
		countryMap.put("CN", new Location(35.0000, 105.0000));
		countryMap.put("CO", new Location(4.0000, -72.0000));
		countryMap.put("CR", new Location(10.0000, -84.0000));
		countryMap.put("CU", new Location(21.5000, -80.0000));
		countryMap.put("CV", new Location(16.0000, -24.0000));
		countryMap.put("CX", new Location(-10.5000, 105.6667));
		countryMap.put("CY", new Location(35.0000, 33.0000));
		countryMap.put("CZ", new Location(49.7500, 15.5000));
		countryMap.put("DE", new Location(51.0000, 9.0000));
		countryMap.put("DJ", new Location(11.5000, 43.0000));
		countryMap.put("DK", new Location(56.0000, 10.0000));
		countryMap.put("DM", new Location(15.4167, -61.3333));
		countryMap.put("DO", new Location(19.0000, -70.6667));
		countryMap.put("DZ", new Location(28.0000, 3.0000));
		countryMap.put("EC", new Location(-2.0000, -77.5000));
		countryMap.put("EE", new Location(59.0000, 26.0000));
		countryMap.put("EG", new Location(27.0000, 30.0000));
		countryMap.put("EH", new Location(24.5000, -13.0000));
		countryMap.put("ER", new Location(15.0000, 39.0000));
		countryMap.put("ES", new Location(40.0000, -4.0000));
		countryMap.put("ET", new Location(8.0000, 38.0000));
		countryMap.put("EU", new Location(47.0000, 8.0000));
		countryMap.put("FI", new Location(64.0000, 26.0000));
		countryMap.put("FJ", new Location(-18.0000, 175.0000));
		countryMap.put("FK", new Location(-51.7500, -59.0000));
		countryMap.put("FM", new Location(6.9167, 158.2500));
		countryMap.put("FO", new Location(62.0000, -7.0000));
		countryMap.put("FR", new Location(46.0000, 2.0000));
		countryMap.put("GA", new Location(-1.0000, 11.7500));
		countryMap.put("GB", new Location(54.0000, -2.0000));
		countryMap.put("GD", new Location(12.1167, -61.6667));
		countryMap.put("GE", new Location(42.0000, 43.5000));
		countryMap.put("GF", new Location(4.0000, -53.0000));
		countryMap.put("GH", new Location(8.0000, -2.0000));
		countryMap.put("GI", new Location(36.1833, -5.3667));
		countryMap.put("GL", new Location(72.0000, -40.0000));
		countryMap.put("GM", new Location(13.4667, -16.5667));
		countryMap.put("GN", new Location(11.0000, -10.0000));
		countryMap.put("GP", new Location(16.2500, -61.5833));
		countryMap.put("GQ", new Location(2.0000, 10.0000));
		countryMap.put("GR", new Location(39.0000, 22.0000));
		countryMap.put("GS", new Location(-54.5000, -37.0000));
		countryMap.put("GT", new Location(15.5000, -90.2500));
		countryMap.put("GU", new Location(13.4667, 144.7833));
		countryMap.put("GW", new Location(12.0000, -15.0000));
		countryMap.put("GY", new Location(5.0000, -59.0000));
		countryMap.put("HK", new Location(22.2500, 114.1667));
		countryMap.put("HM", new Location(-53.1000, 72.5167));
		countryMap.put("HN", new Location(15.0000, -86.5000));
		countryMap.put("HR", new Location(45.1667, 15.5000));
		countryMap.put("HT", new Location(19.0000, -72.4167));
		countryMap.put("HU", new Location(47.0000, 20.0000));
		countryMap.put("ID", new Location(-5.0000, 120.0000));
		countryMap.put("IE", new Location(53.0000, -8.0000));
		countryMap.put("IL", new Location(31.5000, 34.7500));
		countryMap.put("IN", new Location(20.0000, 77.0000));
		countryMap.put("IO", new Location(-6.0000, 71.5000));
		countryMap.put("IQ", new Location(33.0000, 44.0000));
		countryMap.put("IR", new Location(32.0000, 53.0000));
		countryMap.put("IS", new Location(65.0000, -18.0000));
		countryMap.put("IT", new Location(42.8333, 12.8333));
		countryMap.put("JM", new Location(18.2500, -77.5000));
		countryMap.put("JO", new Location(31.0000, 36.0000));
		countryMap.put("JP", new Location(36.0000, 138.0000));
		countryMap.put("KE", new Location(1.0000, 38.0000));
		countryMap.put("KG", new Location(41.0000, 75.0000));
		countryMap.put("KH", new Location(13.0000, 105.0000));
		countryMap.put("KI", new Location(1.4167, 173.0000));
		countryMap.put("KM", new Location(-12.1667, 44.2500));
		countryMap.put("KN", new Location(17.3333, -62.7500));
		countryMap.put("KP", new Location(40.0000, 127.0000));
		countryMap.put("KR", new Location(37.0000, 127.5000));
		countryMap.put("KW", new Location(29.3375, 47.6581));
		countryMap.put("KY", new Location(19.5000, -80.5000));
		countryMap.put("KZ", new Location(48.0000, 68.0000));
		countryMap.put("LA", new Location(18.0000, 105.0000));
		countryMap.put("LB", new Location(33.8333, 35.8333));
		countryMap.put("LC", new Location(13.8833, -61.1333));
		countryMap.put("LI", new Location(47.1667, 9.5333));
		countryMap.put("LK", new Location(7.0000, 81.0000));
		countryMap.put("LR", new Location(6.5000, -9.5000));
		countryMap.put("LS", new Location(-29.5000, 28.5000));
		countryMap.put("LT", new Location(56.0000, 24.0000));
		countryMap.put("LU", new Location(49.7500, 6.1667));
		countryMap.put("LV", new Location(57.0000, 25.0000));
		countryMap.put("LY", new Location(25.0000, 17.0000));
		countryMap.put("MA", new Location(32.0000, -5.0000));
		countryMap.put("MC", new Location(43.7333, 7.4000));
		countryMap.put("MD", new Location(47.0000, 29.0000));
		countryMap.put("ME", new Location(42.0000, 19.0000));
		countryMap.put("MG", new Location(-20.0000, 47.0000));
		countryMap.put("MH", new Location(9.0000, 168.0000));
		countryMap.put("MK", new Location(41.8333, 22.0000));
		countryMap.put("ML", new Location(17.0000, -4.0000));
		countryMap.put("MM", new Location(22.0000, 98.0000));
		countryMap.put("MN", new Location(46.0000, 105.0000));
		countryMap.put("MO", new Location(22.1667, 113.5500));
		countryMap.put("MP", new Location(15.2000, 145.7500));
		countryMap.put("MQ", new Location(14.6667, -61.0000));
		countryMap.put("MR", new Location(20.0000, -12.0000));
		countryMap.put("MS", new Location(16.7500, -62.2000));
		countryMap.put("MT", new Location(35.8333, 14.5833));
		countryMap.put("MU", new Location(-20.2833, 57.5500));
		countryMap.put("MV", new Location(3.2500, 73.0000));
		countryMap.put("MW", new Location(-13.5000, 34.0000));
		countryMap.put("MX", new Location(23.0000, -102.0000));
		countryMap.put("MY", new Location(2.5000, 112.5000));
		countryMap.put("MZ", new Location(-18.2500, 35.0000));
		countryMap.put("NA", new Location(-22.0000, 17.0000));
		countryMap.put("NC", new Location(-21.5000, 165.5000));
		countryMap.put("NE", new Location(16.0000, 8.0000));
		countryMap.put("NF", new Location(-29.0333, 167.9500));
		countryMap.put("NG", new Location(10.0000, 8.0000));
		countryMap.put("NI", new Location(13.0000, -85.0000));
		countryMap.put("NL", new Location(52.5000, 5.7500));
		countryMap.put("NO", new Location(62.0000, 10.0000));
		countryMap.put("NP", new Location(28.0000, 84.0000));
		countryMap.put("NR", new Location(-0.5333, 166.9167));
		countryMap.put("NU", new Location(-19.0333, -169.8667));
		countryMap.put("NZ", new Location(-41.0000, 174.0000));
		countryMap.put("OM", new Location(21.0000, 57.0000));
		countryMap.put("PA", new Location(9.0000, -80.0000));
		countryMap.put("PE", new Location(-10.0000, -76.0000));
		countryMap.put("PF", new Location(-15.0000, -140.0000));
		countryMap.put("PG", new Location(-6.0000, 147.0000));
		countryMap.put("PH", new Location(13.0000, 122.0000));
		countryMap.put("PK", new Location(30.0000, 70.0000));
		countryMap.put("PL", new Location(52.0000, 20.0000));
		countryMap.put("PM", new Location(46.8333, -56.3333));
		countryMap.put("PR", new Location(18.2500, -66.5000));
		countryMap.put("PS", new Location(32.0000, 35.2500));
		countryMap.put("PT", new Location(39.5000, -8.0000));
		countryMap.put("PW", new Location(7.5000, 134.5000));
		countryMap.put("PY", new Location(-23.0000, -58.0000));
		countryMap.put("QA", new Location(25.5000, 51.2500));
		countryMap.put("RE", new Location(-21.1000, 55.6000));
		countryMap.put("RO", new Location(46.0000, 25.0000));
		countryMap.put("RS", new Location(44.0000, 21.0000));
		countryMap.put("RU", new Location(60.0000, 100.0000));
		countryMap.put("RW", new Location(-2.0000, 30.0000));
		countryMap.put("SA", new Location(25.0000, 45.0000));
		countryMap.put("SB", new Location(-8.0000, 159.0000));
		countryMap.put("SC", new Location(-4.5833, 55.6667));
		countryMap.put("SD", new Location(15.0000, 30.0000));
		countryMap.put("SE", new Location(62.0000, 15.0000));
		countryMap.put("SG", new Location(1.3667, 103.8000));
		countryMap.put("SH", new Location(-15.9333, -5.7000));
		countryMap.put("SI", new Location(46.0000, 15.0000));
		countryMap.put("SJ", new Location(78.0000, 20.0000));
		countryMap.put("SK", new Location(48.6667, 19.5000));
		countryMap.put("SL", new Location(8.5000, -11.5000));
		countryMap.put("SM", new Location(43.7667, 12.4167));
		countryMap.put("SN", new Location(14.0000, -14.0000));
		countryMap.put("SO", new Location(10.0000, 49.0000));
		countryMap.put("SR", new Location(4.0000, -56.0000));
		countryMap.put("ST", new Location(1.0000, 7.0000));
		countryMap.put("SV", new Location(13.8333, -88.9167));
		countryMap.put("SY", new Location(35.0000, 38.0000));
		countryMap.put("SZ", new Location(-26.5000, 31.5000));
		countryMap.put("TC", new Location(21.7500, -71.5833));
		countryMap.put("TD", new Location(15.0000, 19.0000));
		countryMap.put("TF", new Location(-43.0000, 67.0000));
		countryMap.put("TG", new Location(8.0000, 1.1667));
		countryMap.put("TH", new Location(15.0000, 100.0000));
		countryMap.put("TJ", new Location(39.0000, 71.0000));
		countryMap.put("TK", new Location(-9.0000, -172.0000));
		countryMap.put("TM", new Location(40.0000, 60.0000));
		countryMap.put("TN", new Location(34.0000, 9.0000));
		countryMap.put("TO", new Location(-20.0000, -175.0000));
		countryMap.put("TR", new Location(39.0000, 35.0000));
		countryMap.put("TT", new Location(11.0000, -61.0000));
		countryMap.put("TV", new Location(-8.0000, 178.0000));
		countryMap.put("TW", new Location(23.5000, 121.0000));
		countryMap.put("TZ", new Location(-6.0000, 35.0000));
		countryMap.put("UA", new Location(49.0000, 32.0000));
		countryMap.put("UG", new Location(1.0000, 32.0000));
		countryMap.put("UM", new Location(19.2833, 166.6000));
		countryMap.put("US", new Location(38.0000, -97.0000));
		countryMap.put("UY", new Location(-33.0000, -56.0000));
		countryMap.put("UZ", new Location(41.0000, 64.0000));
		countryMap.put("VA", new Location(41.9000, 12.4500));
		countryMap.put("VC", new Location(13.2500, -61.2000));
		countryMap.put("VE", new Location(8.0000, -66.0000));
		countryMap.put("VG", new Location(18.5000, -64.5000));
		countryMap.put("VI", new Location(18.3333, -64.8333));
		countryMap.put("VN", new Location(16.0000, 106.0000));
		countryMap.put("VU", new Location(-16.0000, 167.0000));
		countryMap.put("WF", new Location(-13.3000, -176.2000));
		countryMap.put("WS", new Location(-13.5833, -172.3333));
		countryMap.put("YE", new Location(15.0000, 48.0000));
		countryMap.put("YT", new Location(-12.8333, 45.1667));
		countryMap.put("ZA", new Location(-29.0000, 24.0000));
		countryMap.put("ZM", new Location(-15.0000, 30.0000));
		countryMap.put("ZW", new Location(-20.0000, 30.0000));
		COUNTRY_LOCATION = Collections.unmodifiableMap(countryMap);
	}

	/**
	 * 
	 * @param countryCode
	 * @return Country Location values (lat & long)
	 */
	public Location getCountryLocationByCode(String countryCode) {
		return COUNTRY_LOCATION.get(countryCode);
	}
}
