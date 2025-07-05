/**
 * 
 */
package com.st.emailutility.qrt;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.st.common.CommonUtil;
import com.st.configuration.JobExecutor;
import com.st.efficiency.model.EffSummaryPrimary;
import com.st.efficiency.model.EffSummarySecondary;
import com.st.efficiency.model.Efficiency;
import com.st.efficiency.service.EfficiencyCodeService;
import com.st.efficiencypm5.model.EffSummaryPrimaryPM5;
import com.st.efficiencypm5.model.EffSummarySecondaryPM5;
import com.st.efficiencypm5.model.EfficiencyPM5;
import com.st.efficiencypm5.service.EfficiencyCodeServicePM5;
import com.st.production.automailer.ProductionReportAutoMailer;
import com.st.productionpm5.automailer.ProductionPM5ReportAutoMailer;
import com.st.qualitypm5.automailer.ReelRewinderPM5AutoMailer;
import com.st.qualitypm6.automailer.ReelRewinderAutoMailer;

/**
 * kishor vaishnav 2025
 * 
 *  Send production Summary report Daily (Morning 7:30 Am And  Evening  7:30 PM )
 */
public class ProductionSummaryeport {

	private static final Logger logger = LoggerFactory.getLogger(JobExecutor.class);

	@Autowired
	private ProductionReportAutoMailer productionReportAutoMailer;

	@Autowired
	private ProductionPM5ReportAutoMailer productionPM5ReportAutoMailer;

	@Autowired
	private EfficiencyCodeServicePM5 efficiencyCodePM5Service;

	@Autowired
	private ReelRewinderAutoMailer reelRewinderAutoMailer;

	@Autowired
	private ReelRewinderPM5AutoMailer reelRewinderPM5AutoMailer;

	@Autowired
	private EfficiencyCodeService efficiencyCodeService;

	/**
	 * @param shiftText
	 * @param date
	 * @param repientEmails 
	 */
	public void sendMorningProduction(String shiftText, Date date, String repientEmails) {
		summaryReportPm6(date,repientEmails);
		summaryReportPm5(date,repientEmails);
		/**
		 * Reel and Rewinder Report
		 */
		try {
			reelRewinderAutoMailer.sendMail(new Date(), shiftText ,repientEmails);
			logger.info("STT-PM6-Quality Report:{}", new Date());
			// mailboardService.save(new Date(), "STT-PM6-Quality Report_AM", "Daily", d,
			// true, "", "productionAM","Automailer");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			// mailboardService.save(new Date(), "STT-PM6-Quality Report_AM", "Daily", d,
			// false, ""+e,"productionAM","Automailer");
		}
		/**
		 * Reel and Rewinder Report For PM5
		 */
		try {
			reelRewinderPM5AutoMailer.sendMail(new Date(), shiftText,repientEmails);
			logger.info("STT-PM5-Quality Report:{}", new Date());
			// mailboardService.save(new Date(), "STT-PM5-Quality Report_AM", "Daily", d,
			// true, "","productionAM","Automailer");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			// mailboardService.save(new Date(), "STT-PM5-Quality Report_AM", "Daily", d,
			// false, ""+e,"productionAM","Automailer");
		}
		/**
		 * Efficiency By Shift stoped
		 */
		try {
			// efficiencyAutoMailer.sendEfficiencyByShiftMail();
			// logger.info("Efficiency By Shift Report:{}", new Date());
			// mailboardService.save(new Date(), "Efficiency By ShiftReport_AM", "Daily", d,
			// true, "","productionAM","Automailer");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			// mailboardService.save(new Date(), "Efficiency By Shift Report_AM", "Daily",
			// d, false, ""+e,"productionAM","Automailer");
		}
	}

	/**
	 * Summary Report For PM5
	 * @param repientEmails 
	 */
	private void summaryReportPm5(Date date, String repientEmails) {
		try {
			Map<String, Object> datas1 = new HashMap<>();
			List<EffSummaryPrimaryPM5> summaryPrimaries = new ArrayList<>();
			try {
				Calendar scal = Calendar.getInstance();
				scal.setTime(date);
				scal.set(Calendar.HOUR_OF_DAY, 6);
				scal.set(Calendar.MINUTE, 0);
				scal.set(Calendar.SECOND, 0);
				scal.set(Calendar.MILLISECOND, 0);

				Calendar ecal = Calendar.getInstance();
				ecal.setTime(date);
				ecal.set(Calendar.HOUR_OF_DAY, 5);
				ecal.set(Calendar.MINUTE, 59);
				ecal.set(Calendar.SECOND, 0);
				ecal.set(Calendar.MILLISECOND, 0);
				ecal.add(Calendar.DATE, 1);

				summaryPrimaries = formatSummaryData_PM5(scal.getTime(), ecal.getTime(), 0, 0);

			} catch (Exception e) {
				e.printStackTrace();
			}
			int totalmin = 0;
			for (EffSummaryPrimaryPM5 effSummaryPrimary : summaryPrimaries) {
				totalmin += effSummaryPrimary.getTotalMin();
			}
			datas1.put("summaryPrimaries", summaryPrimaries);
			datas1.put("hh", totalmin / 60);
			datas1.put("mm", totalmin % 60);

			productionPM5ReportAutoMailer.sendMailAt7pm(date, datas1,repientEmails);
			logger.info("STT-PM5-Production Summary Report:{}", new Date());
			// mailboardService.save(new Date(), "STT-PM5-Production Summary Report_AM",
			// "Daily", d, true, "","productionAM","Automailer");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			// mailboardService.save(new Date(), "STT-PM5-Production Summary Report_AM",
			// "Daily", d, false, ""+e,"productionAM","Automailer");
		}
	}

	/**
	 * Summary Report For PM6
	 * @param repientEmails 
	 */
	private void summaryReportPm6(Date date, String repientEmails) {
		try {
			Map<String, Object> datas1 = new HashMap<>();
			List<EffSummaryPrimary> summaryPrimaries = new ArrayList<>();
			try {

				Calendar scal = Calendar.getInstance();
				scal.setTime(date);
				scal.set(Calendar.HOUR_OF_DAY, 6);
				scal.set(Calendar.MINUTE, 0);
				scal.set(Calendar.SECOND, 0);
				scal.set(Calendar.MILLISECOND, 0);

				Calendar ecal = Calendar.getInstance();
				ecal.setTime(date);
				ecal.set(Calendar.HOUR_OF_DAY, 5);
				ecal.set(Calendar.MINUTE, 59);
				ecal.set(Calendar.SECOND, 0);
				ecal.set(Calendar.MILLISECOND, 0);
				ecal.add(Calendar.DATE, 1);

				summaryPrimaries = formatSummaryData(scal.getTime(), ecal.getTime(), 0, 0);

			} catch (Exception e) {
				e.printStackTrace();
			}
			int totalmin = 0;
			for (EffSummaryPrimary effSummaryPrimary : summaryPrimaries) {
				totalmin += effSummaryPrimary.getTotalMin();
			}
			datas1.put("summaryPrimaries", summaryPrimaries);
			datas1.put("hh", totalmin / 60);
			datas1.put("mm", totalmin % 60);
			productionReportAutoMailer.sendMailAt7pm(date, datas1,repientEmails);
			logger.info("STT-PM6-Production Summary Report:{}", new Date());
			// mailboardService.save(new Date(), "STT-PM6-Production Summary Report_AM",
			// "Daily", d, true, "", "productionAM","Automailer");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			// mailboardService.save(new Date(), "STT-PM6-Production Summary Report_AM",
			// "Daily", d, false, ""+e, "productionAM","Automailer");
		}
	}

	/**
	 * @param time
	 * @param time2
	 * @param i
	 * @param j
	 * @return
	 */
	private List<EffSummaryPrimary> formatSummaryData(Date sdate, Date edate, int pcode, int scode) {

		List<Efficiency> efficiencies = efficiencyCodeService.getSummaryData(sdate, edate, pcode, scode);
		List<EffSummaryPrimary> effSummaryPrimaries = new ArrayList<>();
		for (Efficiency efficiency : efficiencies) {
			EffSummaryPrimary effSummaryPrimary = getEffSummaryPrimary(effSummaryPrimaries, efficiency.getPcode());
			if (effSummaryPrimary == null) {
				effSummaryPrimary = new EffSummaryPrimary();
				effSummaryPrimary.setCode(efficiency.getPcode());
				// Secondary code
				EffSummarySecondary effSummarySecondary = new EffSummarySecondary();
				effSummarySecondary.setCode(efficiency.getScode());
				int hh = CommonUtil.getHoursDuration(efficiency.getStartTime(), efficiency.getEndTime());
				int mm = CommonUtil.getMinutesDuration(efficiency.getStartTime(), efficiency.getEndTime());
				int total = (hh * 60) + mm;
				effSummarySecondary.setTotalMin(total);
				effSummarySecondary.setHh(effSummarySecondary.getTotalMin() / 60);
				effSummarySecondary.setMm(effSummarySecondary.getTotalMin() % 60);
				effSummaryPrimary.getSummarySecondaries().add(effSummarySecondary);
				// Set Counter;
				effSummarySecondary.setCounter(1);
				effSummaryPrimaries.add(effSummaryPrimary);

			} else {
				List<EffSummarySecondary> effSummarySecondaries = effSummaryPrimary.getSummarySecondaries();
				EffSummarySecondary effSummarySecondary = getEffSummarySecondary(effSummarySecondaries,
						efficiency.getScode());
				if (effSummarySecondary == null) {
					effSummarySecondary = new EffSummarySecondary();
					effSummarySecondary.setCode(efficiency.getScode());
					int hh = CommonUtil.getHoursDuration(efficiency.getStartTime(), efficiency.getEndTime());
					int mm = CommonUtil.getMinutesDuration(efficiency.getStartTime(), efficiency.getEndTime());
					int total = (hh * 60) + mm;
					effSummarySecondary.setTotalMin(total);
					effSummarySecondary.setHh(effSummarySecondary.getTotalMin() / 60);
					effSummarySecondary.setMm(effSummarySecondary.getTotalMin() % 60);
					effSummarySecondaries.add(effSummarySecondary);
					effSummarySecondary.setCounter(1);

				} else {
					int hh = CommonUtil.getHoursDuration(efficiency.getStartTime(), efficiency.getEndTime());
					int mm = CommonUtil.getMinutesDuration(efficiency.getStartTime(), efficiency.getEndTime());
					int total = (hh * 60) + mm;
					effSummarySecondary.setTotalMin(effSummarySecondary.getTotalMin() + total);
					effSummarySecondary.setHh(effSummarySecondary.getTotalMin() / 60);
					effSummarySecondary.setMm(effSummarySecondary.getTotalMin() % 60);

					effSummarySecondary.setCounter(effSummarySecondary.getCounter() + 1);
				}
			}
		}

		for (EffSummaryPrimary effSummaryPrimary : effSummaryPrimaries) {
			int total = 0;
			for (EffSummarySecondary effSummarySecondary : effSummaryPrimary.getSummarySecondaries()) {
				total += effSummarySecondary.getTotalMin();
			}
			effSummaryPrimary.setTotalMin(total);
			effSummaryPrimary.setHh(total / 60);
			effSummaryPrimary.setMm(total % 60);
		}

		return effSummaryPrimaries;
	}

	/**
	 * @param effSummarySecondaries
	 * @param scode
	 * @return
	 */
	private EffSummarySecondary getEffSummarySecondary(List<EffSummarySecondary> effSummarySecondaries, String scode) {
		EffSummarySecondary effSummarySecondary = null;
		for (EffSummarySecondary ess : effSummarySecondaries) {
			if (ess.getCode().equals(scode)) {
				effSummarySecondary = ess;
				break;
			}
		}
		return effSummarySecondary;
	}

	/**
	 * FRP- Daily Production - Report
	 * 
	 * @param effSummaryPrimaries
	 * @param pcode
	 * @return
	 */
	private EffSummaryPrimary getEffSummaryPrimary(List<EffSummaryPrimary> effSummaryPrimaries, String pcode) {
		EffSummaryPrimary effSummaryPrimary = null;
		for (EffSummaryPrimary esp : effSummaryPrimaries) {
			if (esp.getCode().equals(pcode)) {
				effSummaryPrimary = esp;
				break;
			}
		}
		return effSummaryPrimary;
	}

	/**
	 * @param time
	 * @param time2
	 * @param i
	 * @param j
	 * @return
	 */
	private List<EffSummaryPrimaryPM5> formatSummaryData_PM5(Date sdate, Date edate, int pcode, int scode) {

		List<EfficiencyPM5> efficiencies = efficiencyCodePM5Service.getSummaryData(sdate, edate, pcode, scode);
		List<EffSummaryPrimaryPM5> effSummaryPrimaries = new ArrayList<>();
		for (EfficiencyPM5 efficiency : efficiencies) {
			EffSummaryPrimaryPM5 effSummaryPrimary = getEffSummaryPrimary_PM5(effSummaryPrimaries,
					efficiency.getPcode());
			if (effSummaryPrimary == null) {
				effSummaryPrimary = new EffSummaryPrimaryPM5();
				effSummaryPrimary.setCode(efficiency.getPcode());

				// Secondary code
				EffSummarySecondaryPM5 effSummarySecondary = new EffSummarySecondaryPM5();
				effSummarySecondary.setCode(efficiency.getScode());
				int hh = CommonUtil.getHoursDuration(efficiency.getStartTime(), efficiency.getEndTime());
				int mm = CommonUtil.getMinutesDuration(efficiency.getStartTime(), efficiency.getEndTime());
				int total = (hh * 60) + mm;
				effSummarySecondary.setTotalMin(total);
				effSummarySecondary.setHh(effSummarySecondary.getTotalMin() / 60);
				effSummarySecondary.setMm(effSummarySecondary.getTotalMin() % 60);
				effSummaryPrimary.getSummarySecondaries().add(effSummarySecondary);

				// Set Counter;
				effSummarySecondary.setCounter(1);
				effSummaryPrimaries.add(effSummaryPrimary);

			} else {
				List<EffSummarySecondaryPM5> effSummarySecondaries = effSummaryPrimary.getSummarySecondaries();
				EffSummarySecondaryPM5 effSummarySecondary = getEffSummarySecondary_PM5(effSummarySecondaries,
						efficiency.getScode());
				if (effSummarySecondary == null) {
					effSummarySecondary = new EffSummarySecondaryPM5();
					effSummarySecondary.setCode(efficiency.getScode());
					int hh = CommonUtil.getHoursDuration(efficiency.getStartTime(), efficiency.getEndTime());
					int mm = CommonUtil.getMinutesDuration(efficiency.getStartTime(), efficiency.getEndTime());
					int total = (hh * 60) + mm;
					effSummarySecondary.setTotalMin(total);
					effSummarySecondary.setHh(effSummarySecondary.getTotalMin() / 60);
					effSummarySecondary.setMm(effSummarySecondary.getTotalMin() % 60);
					effSummarySecondaries.add(effSummarySecondary);
					effSummarySecondary.setCounter(1);

				} else {
					int hh = CommonUtil.getHoursDuration(efficiency.getStartTime(), efficiency.getEndTime());
					int mm = CommonUtil.getMinutesDuration(efficiency.getStartTime(), efficiency.getEndTime());
					int total = (hh * 60) + mm;
					effSummarySecondary.setTotalMin(effSummarySecondary.getTotalMin() + total);
					effSummarySecondary.setHh(effSummarySecondary.getTotalMin() / 60);
					effSummarySecondary.setMm(effSummarySecondary.getTotalMin() % 60);

					effSummarySecondary.setCounter(effSummarySecondary.getCounter() + 1);
				}
			}
		}

		for (EffSummaryPrimaryPM5 effSummaryPrimary : effSummaryPrimaries) {
			int total = 0;
			for (EffSummarySecondaryPM5 effSummarySecondary : effSummaryPrimary.getSummarySecondaries()) {
				total += effSummarySecondary.getTotalMin();
			}
			effSummaryPrimary.setTotalMin(total);
			effSummaryPrimary.setHh(total / 60);
			effSummaryPrimary.setMm(total % 60);
		}

		return effSummaryPrimaries;
	}

	/**
	 * @param effSummarySecondaries
	 * @param scode
	 * @return
	 */
	private EffSummarySecondaryPM5 getEffSummarySecondary_PM5(List<EffSummarySecondaryPM5> effSummarySecondaries,
			String scode) {
		EffSummarySecondaryPM5 effSummarySecondary = null;
		for (EffSummarySecondaryPM5 ess : effSummarySecondaries) {
			if (ess.getCode().equals(scode)) {
				effSummarySecondary = ess;
				break;
			}
		}
		return effSummarySecondary;
	}

	/**
	 * @param effSummaryPrimaries
	 * @param pcode
	 * @return
	 */
	private EffSummaryPrimaryPM5 getEffSummaryPrimary_PM5(List<EffSummaryPrimaryPM5> effSummaryPrimaries,
			String pcode) {
		EffSummaryPrimaryPM5 effSummaryPrimary = null;
		for (EffSummaryPrimaryPM5 esp : effSummaryPrimaries) {
			if (esp.getCode().equals(pcode)) {
				effSummaryPrimary = esp;
				break;
			}
		}
		return effSummaryPrimary;
	}

	public void sendEveningProduction(String shiftText, Date date, String repientEmails) {
		summaryReportPm6(date,repientEmails);
		summaryReportPm5(date,repientEmails);
		
	}

}
