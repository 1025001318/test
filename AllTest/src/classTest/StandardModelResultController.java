package classTest;

import java.text.SimpleDateFormat;

public class StandardModelResultController {
	@Autowired
	private IStandardModelResultService standardMoedlResultService;
	
	//ͨ������������id��Ѳ�����ͣ������ݿ��н��в��ң������ض�Ӧ��ģ�ͽ��
	@RequestMapping(value = "getStandardMpdelResultService")
	@ResponseBody
	public Object getStandardModelResult(@RequestBody StandardModelResult standardModel) {
		if(StringUtils.isBlank(standardModel.getTaskId()) || standardModel.getPatrolType() == nul) {
			return new ReesultViewModel(412, "����ID��Ѳ�����Ͳ���Ϊ��");
		}
		try {
			return new ResultViewModel(200, "�ɹ�", standardModelResultService.getStandardModelResult(standardModel));
		} catch (Exception e) {
			return new ResultViewMode(500, e.toString);
		}
	}
	
	//����ģ�ͼ�����
	@RequestMapping(value = "SaveStandardModelResult")
	@ResponseBody
	public Object SaveStandardModelResult(@RequestBody StandardModelResultViewModel standardModelVM) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		standardModelVM.setDate(sdf.format(new Date()));
		
		
		try {
			if(standardModelResultSevice.SaveStandardModelResult(standardModelVM)) {
				return new ResultViewModel(200, "�ɹ���");
			}
			else {
				return new ResultViewModel(500, "�洢����");
			}
		}catch(Exception e) {
			return new ReusltViewModel(500, e.toString());
		}
	}
		
}
