package classTest;

import java.text.SimpleDateFormat;

public class StandardModelResultController {
	@Autowired
	private IStandardModelResultService standardMoedlResultService;
	
	//通过给定的任务id和巡查类型，在数据库中进行查找，并返回对应的模型结果
	@RequestMapping(value = "getStandardMpdelResultService")
	@ResponseBody
	public Object getStandardModelResult(@RequestBody StandardModelResult standardModel) {
		if(StringUtils.isBlank(standardModel.getTaskId()) || standardModel.getPatrolType() == nul) {
			return new ReesultViewModel(412, "任务ID和巡查类型不能为空");
		}
		try {
			return new ResultViewModel(200, "成功", standardModelResultService.getStandardModelResult(standardModel));
		} catch (Exception e) {
			return new ResultViewMode(500, e.toString);
		}
	}
	
	//保存模型计算结果
	@RequestMapping(value = "SaveStandardModelResult")
	@ResponseBody
	public Object SaveStandardModelResult(@RequestBody StandardModelResultViewModel standardModelVM) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		standardModelVM.setDate(sdf.format(new Date()));
		
		
		try {
			if(standardModelResultSevice.SaveStandardModelResult(standardModelVM)) {
				return new ResultViewModel(200, "成功！");
			}
			else {
				return new ResultViewModel(500, "存储错误！");
			}
		}catch(Exception e) {
			return new ReusltViewModel(500, e.toString());
		}
	}
		
}
