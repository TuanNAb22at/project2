package com.javaweb.converter;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.javaweb.builder.BuildingSearchBuider;
import com.javaweb.utils.MapUtil;
@Component
public class BuildingSearchBuilderConverter {
	public static BuildingSearchBuider toBuildingSearchBuider(Map<String, Object> params, ArrayList<String> type) {
		BuildingSearchBuider buildingSearchBuider = new BuildingSearchBuider.Builder()
				.setName(MapUtil.getObject(params, "name", String.class))
				.setFloorarea(MapUtil.getObject(params, "floorarea", Integer.class))
				.setWard(MapUtil.getObject(params, "ward", String.class))
				.setDistrict(MapUtil.getObject(params, "district", String.class))
				.setStreet(MapUtil.getObject(params, "street", String.class))
				.setAreaFrom(MapUtil.getObject(params, "areaFrom", Integer.class))
				.setAreaTo(MapUtil.getObject(params, "areaTo", Integer.class))
				.setRentpriceFrom(MapUtil.getObject(params, "rentPriceFrom", Integer.class))
				.setRentpriceTo(MapUtil.getObject(params, "rentPriceTo", Integer.class))
				.setNumberofbasement(MapUtil.getObject(params, "numberofbasement", Integer.class))
				.setManagername(MapUtil.getObject(params, "managername", String.class))
				.setStaffid(MapUtil.getObject(params, "staffId", Integer.class))
				.buid();
		return buildingSearchBuider;
	}
}
