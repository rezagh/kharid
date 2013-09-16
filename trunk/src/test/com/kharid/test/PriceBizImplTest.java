package com.kharid.test;
import org.junit.Test;

import com.kharid.biz.PriceBiz;
import com.kharid.biz.impl.PriceBizImpl;
import com.kharid.model.type.PostTypeEnum;
import com.kharid.model.type.WeightTypeEnum;
import com.kharid.vo.PriceVO;

public class PriceBizImplTest extends BaseTest {

//	@Before
//	public void setup2(){
//		setup();
//	}
	
	@Test
	public void testCalculateCommission(){
		PriceBiz pb = new PriceBizImpl();
		//pb.calculateCommission("29.84", "IRR");
		PriceVO priceVO = new PriceVO();
		priceVO.setBasePrice("33");
		//priceVO.setBasePriceUnit("AUD");
		//priceVO.setGoodType(PurchaseTypeEnum.PHYSICAL.name());
		//priceVO.setPriceToAus("0");
		//priceVO.setPriceToAusUnit("USD");
		priceVO.setWeight("200");
		priceVO.setWeightUnit(WeightTypeEnum.GRAM.name());
		
		try {
			pb.calculateFinalPrice(priceVO, PostTypeEnum.AIR);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
