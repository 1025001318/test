package jsontest;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

public class JsonChange {
	public static void convertObject() {
		InitialValue iv = new InitialValue();
		iv.setStandardCode("A002B001C008");
		
		List<InitialValue> model = new ArrayList<InitialValue>();
		model.add(iv);
		
		InitialValuesParam ivp = new InitialValuesParam();
		ivp.setModel(model);
		ivp.setOrgCode("602010001");
		
		JSONObject json = JSONObject.fromObject(ivp);
		
		String strJson = json.toString();
		
		System.out.println(strJson);
	}
	
	public static void convertObject2() {
		StandardModelResult smr = new StandardModelResult();
		smr.setPatrolType(1);
		smr.setTaskId("00000000001");
		
		JSONObject json = JSONObject.fromObject(smr);
		String strJson = json.toString();
		
		System.out.println(strJson);
	}
	public static void convertObject3() {
		StandardModelResultDetailViewModel smrdv1 = new StandardModelResultDetailViewModel();
		List<StandardModelResultDetailViewModel> list = new ArrayList<StandardModelResultDetailViewModel>();
		List<StandardModelResultDetailViewModel> list2 = new ArrayList<StandardModelResultDetailViewModel>();
		StandardModelResultDetailViewModel smrdv2 = new StandardModelResultDetailViewModel();
		
		smrdv1.setStandardCode("4545454545");
		smrdv1.setStandardName("56565656");
		smrdv2.setStandardCode("666666666");
		smrdv2.setStandardName("23232332");
		
		list.add(smrdv2);
		smrdv1.setChildmodel(list);
		list2.add(smrdv1);
		list2.add(smrdv2);
		
		StandardModelResultViewModel smrvm = new StandardModelResultViewModel();
		smrvm.setOrgCode("7878787878");
		smrvm.setModel(list2);
		
		JSONObject json = JSONObject.fromObject(smrvm);
		String strJson = json.toString();
		
		System.out.println(strJson);
	}
	//≤‚ ‘
	public static void main(String[] args) {
		JsonChange.convertObject3();
	}
}
