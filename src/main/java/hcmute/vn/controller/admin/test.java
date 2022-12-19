package hcmute.vn.controller.admin;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import hcmute.vn.entity.Store;
import hcmute.vn.entity.StoreLevel;
import hcmute.vn.service.IStoreService;
import hcmute.vn.service.impl.StoreServiceImpl;
import hcmute.vn.util.HashPassword;
import hcmute.vn.util.HashPassword.*;

public class test  {

	public static void main(String[] args) {
		
		IStoreService storeService = new StoreServiceImpl();
		
		Store store = storeService.findbyId(2007);
		
		
		StoreLevel storeLevel = new StoreLevel();
		
		storeLevel.setStore(store);

		
	}
}
