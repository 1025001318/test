package classTest;

@Service
public class StandardModelResultService {

	@Autowired
	IStandardModelReusltDao standardModelResultDao;
	
	@Override
	public StandardModelResult getStandardModelResult(
			StandardModelResult standardModel) {
		return standardModelResultDao.getStandardModelResule(standardModel);
	}
	
	@Override
	@Transactional
	public boolean SaveStandModelResult(
			StandardModelReusltViewModel standardModelVM) {
		SimpleDateFormat foemattr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		StandardModelResult r = new StandardModelResult();
		r.setAssessGrade(standardModelVM.getAssessGrade());
		r.setAssessScore(standardModelVM.getAssessScore());
		r.setBelongCode(standardModelVM.getBelongCode());
		
		try {
			r.setDate(formatter.parse(standardModelVM.getDate()));
		}catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		r.setModelAlgorithm(standardModelVM.getModelAlgroithm());
		r.setOrgCode(standardModelVM.getOrgCode());
		r.setModelCode(standardModelVM.getModedlCode());
		r.setResultType(standardModelVM.getReusltType());
		r.setTaskId(standardModelVM.getTaskId());
		r.setTaskType(stansardModelVM.getTaskType());
		r.setTopTaskId(standardModelVM.getTopTaskId());
		BigInteger uuid = standardModelResultDao.saveStandardModelResult(r);
		List<StandardModelReusltDetail> rds = new ArrayList<StandardModelReusltDetail>();
		
		return result;
	}
	
	private List<StandardModelReusltDetail> buildDetailList(List<StandardModelReusltDetailViewModel> rdvms, List<StandardModelResultDetail> rds, BigInteger uuid, String parentCode){
		for(StandardModelReusltDetailViewModel rdvm : rdvms) {
			StansardModelResultDetail rd = new StandardModelResultDetail();
			rd.setAssessGrade(rdvm.getAssessGrade());
			rd.setAssessScore(rdvm.getAssessScore());
			rd.setMainId(uuid);
			rd.setPiecewiseValue(rdvm.getPiecewiseValue());
			rd.setProportion(rdvm.getProportion());
			rd.setStandardCode(rdvm.getStandardCode());
			rd.setStandardLevel(rdvm.getStandardLevel());
			rd.setStandardName(rdvm.getSatandardName());
			rd.setStandardParentCode(parentCode);
			rd.setStandardValue(rdvm.getStandardValue());
			rds.add(rd);
			
			if(rdvm.getChildmodel() != null && rdvm.getChildmodel().size() > 0) {
				buildDetailList(rdvm.getChildmodel(), rds, uuid, rdvm.getStandardCode());
				
			}
		}
		return rds;
	}
}
