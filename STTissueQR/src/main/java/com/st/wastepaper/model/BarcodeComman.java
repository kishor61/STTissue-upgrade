/**
 *Jul 23, 2015
 *Barcode.java
 * TODO
 *com.st.wastepaperunloadbale.model
 *Barcode.java
 *Sunil Singh Bora
 */
package com.st.wastepaper.model;

/**
 * @author roshan
 *
 */
public class BarcodeComman {


	private int prtmix;
	private int mwl;
	private int mcl;
	private int mwlwigs;
	private int cbs;
	private int ctdGdwd;
	private int swlsortedwhite;
	private int onpolnNewsprint;
	private int oinews;
	private int lightprtsbs;
	private int hw;
	private int heavyprtsbs;
	private int sow;
	private int unprtsbs;
	private int newsblank;
	private int whitegdwdblend;
	private int mailundeliverable;
	private int hoggedbooks;
	private int occ;
	private int dlk;
	private int mixedpaper;
	private int softwoodchips;
	private int hardwoodchips;
	private int whitebroke;
	private int pwe;
	private int brownnapkinbroke;
	private int pulpwetlap;
	private int virginpulp;
	private int brownwetLap;
	private int pulpdryLap;
	private int otherrolls;
	private int stbaleswetlap;
	private int sttbaledbrokebutl;
	private int unctdflyleafshvgs;
	private int looseest;
	private int	virginSoftWood;
	private int	virginHardWood;
	private int	virginEucalyptus;
	private int	scnNews;
	private int	virginSW_Fluff;
	
	private int virginhardwood;
	private int virginsoftwood;
	
	private int total;
	
	//Col for Weight
	private double prtmixw;
	private double mwlw;
	private double mclw;
	private double mwlwigsw;
	private double cbsw;
	private double ctdGdwdw;
	private double swlsortedwhitew;
	private double onpolnNewsprintw;
	private double oinewsw;
	private double lightprtsbsw;
	private double hww;
	private double heavyprtsbsw;
	private double soww;
	private double unprtsbsw;
	private double newsblankw;
	private double whitegdwdblendw;
	private double mailundeliverablew;
	private double hoggedbooksw;
	private double occw;
	private double dlkw;
	private double mixedpaperw;
	private double softwoodchipsw;
	private double hardwoodchipsw;
	private double whitebrokew;
	private double pwew;
	private double brownnapkinbrokew;
	private double pulpwetlapw;
	private double virginpulpw;
	private double brownwetLapw;
	private double pulpdryLapw;
	private double otherrollsw;
	private double stbaleswetlapw;
	private double sttbaledbrokebutlw;
	
	private double unctdflyleafshvgsw;
	private double looseestW;
	private double virginhardwoodw;
	private double virginsoftwoodw;
	private double	virginSoftWoodw;
	private double	virginHardWoodw;
	private double	virginEucalyptusw;
	private double	scnNewsw;
	private double	virginSW_Fluffw;
	private double totalweight;
	//Col For Opening And Closing
	
	private int closemonth;
	private int closeyear;
	
	private double total_tonnage;
	
	/**
	 * @return the prtmix
	 */
	public int getPrtmix() {
		return prtmix;
	}
	/**
	 * @param prtmix the prtmix to set
	 */
	public void setPrtmix(int prtmix) {
		this.prtmix = prtmix;
	}
	/**
	 * @return the mwl
	 */
	public int getMwl() {
		return mwl;
	}
	/**
	 * @param mwl the mwl to set
	 */
	public void setMwl(int mwl) {
		this.mwl = mwl;
	}
	/**
	 * @return the mcl
	 */
	public int getMcl() {
		return mcl;
	}
	/**
	 * @param mcl the mcl to set
	 */
	public void setMcl(int mcl) {
		this.mcl = mcl;
	}
	/**
	 * @return the mwlwigs
	 */
	public int getMwlwigs() {
		return mwlwigs;
	}
	/**
	 * @param mwlwigs the mwlwigs to set
	 */
	public void setMwlwigs(int mwlwigs) {
		this.mwlwigs = mwlwigs;
	}
	/**
	 * @return the cbs
	 */
	public int getCbs() {
		return cbs;
	}
	/**
	 * @param cbs the cbs to set
	 */
	public void setCbs(int cbs) {
		this.cbs = cbs;
	}
	/**
	 * @return the ctdGdwd
	 */
	public int getCtdGdwd() {
		return ctdGdwd;
	}
	/**
	 * @param ctdGdwd the ctdGdwd to set
	 */
	public void setCtdGdwd(int ctdGdwd) {
		this.ctdGdwd = ctdGdwd;
	}
	/**
	 * @return the swlsortedwhite
	 */
	public int getSwlsortedwhite() {
		return swlsortedwhite;
	}
	/**
	 * @param swlsortedwhite the swlsortedwhite to set
	 */
	public void setSwlsortedwhite(int swlsortedwhite) {
		this.swlsortedwhite = swlsortedwhite;
	}
	/**
	 * @return the onpolnNewsprint
	 */
	public int getOnpolnNewsprint() {
		return onpolnNewsprint;
	}
	/**
	 * @param onpolnNewsprint the onpolnNewsprint to set
	 */
	public void setOnpolnNewsprint(int onpolnNewsprint) {
		this.onpolnNewsprint = onpolnNewsprint;
	}
	/**
	 * @return the oinews
	 */
	public int getOinews() {
		return oinews;
	}
	/**
	 * @param oinews the oinews to set
	 */
	public void setOinews(int oinews) {
		this.oinews = oinews;
	}
	/**
	 * @return the lightprtsbs
	 */
	public int getLightprtsbs() {
		return lightprtsbs;
	}
	/**
	 * @param lightprtsbs the lightprtsbs to set
	 */
	public void setLightprtsbs(int lightprtsbs) {
		this.lightprtsbs = lightprtsbs;
	}
	/**
	 * @return the hw
	 */
	public int getHw() {
		return hw;
	}
	/**
	 * @param hw the hw to set
	 */
	public void setHw(int hw) {
		this.hw = hw;
	}
	/**
	 * @return the heavyprtsbs
	 */
	public int getHeavyprtsbs() {
		return heavyprtsbs;
	}
	/**
	 * @param heavyprtsbs the heavyprtsbs to set
	 */
	public void setHeavyprtsbs(int heavyprtsbs) {
		this.heavyprtsbs = heavyprtsbs;
	}
	/**
	 * @return the sow
	 */
	public int getSow() {
		return sow;
	}
	/**
	 * @param sow the sow to set
	 */
	public void setSow(int sow) {
		this.sow = sow;
	}
	/**
	 * @return the unprtsbs
	 */
	public int getUnprtsbs() {
		return unprtsbs;
	}
	/**
	 * @param unprtsbs the unprtsbs to set
	 */
	public void setUnprtsbs(int unprtsbs) {
		this.unprtsbs = unprtsbs;
	}
	/**
	 * @return the newsblank
	 */
	public int getNewsblank() {
		return newsblank;
	}
	/**
	 * @param newsblank the newsblank to set
	 */
	public void setNewsblank(int newsblank) {
		this.newsblank = newsblank;
	}
	/**
	 * @return the whitegdwdblend
	 */
	public int getWhitegdwdblend() {
		return whitegdwdblend;
	}
	/**
	 * @param whitegdwdblend the whitegdwdblend to set
	 */
	public void setWhitegdwdblend(int whitegdwdblend) {
		this.whitegdwdblend = whitegdwdblend;
	}
	/**
	 * @return the mailundeliverable
	 */
	public int getMailundeliverable() {
		return mailundeliverable;
	}
	/**
	 * @param mailundeliverable the mailundeliverable to set
	 */
	public void setMailundeliverable(int mailundeliverable) {
		this.mailundeliverable = mailundeliverable;
	}
	/**
	 * @return the hoggedbooks
	 */
	public int getHoggedbooks() {
		return hoggedbooks;
	}
	/**
	 * @param hoggedbooks the hoggedbooks to set
	 */
	public void setHoggedbooks(int hoggedbooks) {
		this.hoggedbooks = hoggedbooks;
	}
	/**
	 * @return the occ
	 */
	public int getOcc() {
		return occ;
	}
	/**
	 * @param occ the occ to set
	 */
	public void setOcc(int occ) {
		this.occ = occ;
	}
	/**
	 * @return the dlk
	 */
	public int getDlk() {
		return dlk;
	}
	/**
	 * @param dlk the dlk to set
	 */
	public void setDlk(int dlk) {
		this.dlk = dlk;
	}
	/**
	 * @return the mixedpaper
	 */
	public int getMixedpaper() {
		return mixedpaper;
	}
	/**
	 * @param mixedpaper the mixedpaper to set
	 */
	public void setMixedpaper(int mixedpaper) {
		this.mixedpaper = mixedpaper;
	}
	/**
	 * @return the softwoodchips
	 */
	public int getSoftwoodchips() {
		return softwoodchips;
	}
	/**
	 * @param softwoodchips the softwoodchips to set
	 */
	public void setSoftwoodchips(int softwoodchips) {
		this.softwoodchips = softwoodchips;
	}
	/**
	 * @return the hardwoodchips
	 */
	public int getHardwoodchips() {
		return hardwoodchips;
	}
	/**
	 * @param hardwoodchips the hardwoodchips to set
	 */
	public void setHardwoodchips(int hardwoodchips) {
		this.hardwoodchips = hardwoodchips;
	}
	/**
	 * @return the whitebroke
	 */
	public int getWhitebroke() {
		return whitebroke;
	}
	/**
	 * @param whitebroke the whitebroke to set
	 */
	public void setWhitebroke(int whitebroke) {
		this.whitebroke = whitebroke;
	}
	/**
	 * @return the pwe
	 */
	public int getPwe() {
		return pwe;
	}
	/**
	 * @param pwe the pwe to set
	 */
	public void setPwe(int pwe) {
		this.pwe = pwe;
	}
	/**
	 * @return the brownnapkinbroke
	 */
	public int getBrownnapkinbroke() {
		return brownnapkinbroke;
	}
	/**
	 * @param brownnapkinbroke the brownnapkinbroke to set
	 */
	public void setBrownnapkinbroke(int brownnapkinbroke) {
		this.brownnapkinbroke = brownnapkinbroke;
	}
	/**
	 * @return the pulpwetlap
	 */
	public int getPulpwetlap() {
		return pulpwetlap;
	}
	/**
	 * @param pulpwetlap the pulpwetlap to set
	 */
	public void setPulpwetlap(int pulpwetlap) {
		this.pulpwetlap = pulpwetlap;
	}
	/**
	 * @return the virginpulp
	 */
	public int getVirginpulp() {
		return virginpulp;
	}
	/**
	 * @param virginpulp the virginpulp to set
	 */
	public void setVirginpulp(int virginpulp) {
		this.virginpulp = virginpulp;
	}
	/**
	 * @return the brownwetLap
	 */
	public int getBrownwetLap() {
		return brownwetLap;
	}
	/**
	 * @param brownwetLap the brownwetLap to set
	 */
	public void setBrownwetLap(int brownwetLap) {
		this.brownwetLap = brownwetLap;
	}
	/**
	 * @return the pulpdryLap
	 */
	public int getPulpdryLap() {
		return pulpdryLap;
	}
	/**
	 * @param pulpdryLap the pulpdryLap to set
	 */
	public void setPulpdryLap(int pulpdryLap) {
		this.pulpdryLap = pulpdryLap;
	}
	/**
	 * @return the otherrolls
	 */
	public int getOtherrolls() {
		return otherrolls;
	}
	/**
	 * @param otherrolls the otherrolls to set
	 */
	public void setOtherrolls(int otherrolls) {
		this.otherrolls = otherrolls;
	}
	/**
	 * @return the stbaleswetlap
	 */
	public int getStbaleswetlap() {
		return stbaleswetlap;
	}
	/**
	 * @param stbaleswetlap the stbaleswetlap to set
	 */
	public void setStbaleswetlap(int stbaleswetlap) {
		this.stbaleswetlap = stbaleswetlap;
	}
	/**
	 * @return the sttbaledbrokebutl
	 */
	public int getSttbaledbrokebutl() {
		return sttbaledbrokebutl;
	}
	/**
	 * @param sttbaledbrokebutl the sttbaledbrokebutl to set
	 */
	public void setSttbaledbrokebutl(int sttbaledbrokebutl) {
		this.sttbaledbrokebutl = sttbaledbrokebutl;
	}
	/**
	 * @return the prtmixw
	 */
	public double getPrtmixw() {
		return prtmixw;
	}
	/**
	 * @param prtmixw the prtmixw to set
	 */
	public void setPrtmixw(double prtmixw) {
		this.prtmixw = prtmixw;
	}
	/**
	 * @return the mwlw
	 */
	public double getMwlw() {
		return mwlw;
	}
	/**
	 * @param mwlw the mwlw to set
	 */
	public void setMwlw(double mwlw) {
		this.mwlw = mwlw;
	}
	/**
	 * @return the mclw
	 */
	public double getMclw() {
		return mclw;
	}
	/**
	 * @param mclw the mclw to set
	 */
	public void setMclw(double mclw) {
		this.mclw = mclw;
	}
	/**
	 * @return the mwlwigsw
	 */
	public double getMwlwigsw() {
		return mwlwigsw;
	}
	/**
	 * @param mwlwigsw the mwlwigsw to set
	 */
	public void setMwlwigsw(double mwlwigsw) {
		this.mwlwigsw = mwlwigsw;
	}
	/**
	 * @return the cbsw
	 */
	public double getCbsw() {
		return cbsw;
	}
	/**
	 * @param cbsw the cbsw to set
	 */
	public void setCbsw(double cbsw) {
		this.cbsw = cbsw;
	}
	/**
	 * @return the ctdGdwdw
	 */
	public double getCtdGdwdw() {
		return ctdGdwdw;
	}
	/**
	 * @param ctdGdwdw the ctdGdwdw to set
	 */
	public void setCtdGdwdw(double ctdGdwdw) {
		this.ctdGdwdw = ctdGdwdw;
	}
	/**
	 * @return the swlsortedwhitew
	 */
	public double getSwlsortedwhitew() {
		return swlsortedwhitew;
	}
	/**
	 * @param swlsortedwhitew the swlsortedwhitew to set
	 */
	public void setSwlsortedwhitew(double swlsortedwhitew) {
		this.swlsortedwhitew = swlsortedwhitew;
	}
	/**
	 * @return the onpolnNewsprintw
	 */
	public double getOnpolnNewsprintw() {
		return onpolnNewsprintw;
	}
	/**
	 * @param onpolnNewsprintw the onpolnNewsprintw to set
	 */
	public void setOnpolnNewsprintw(double onpolnNewsprintw) {
		this.onpolnNewsprintw = onpolnNewsprintw;
	}
	/**
	 * @return the oinewsw
	 */
	public double getOinewsw() {
		return oinewsw;
	}
	/**
	 * @param oinewsw the oinewsw to set
	 */
	public void setOinewsw(double oinewsw) {
		this.oinewsw = oinewsw;
	}
	/**
	 * @return the lightprtsbsw
	 */
	public double getLightprtsbsw() {
		return lightprtsbsw;
	}
	/**
	 * @param lightprtsbsw the lightprtsbsw to set
	 */
	public void setLightprtsbsw(double lightprtsbsw) {
		this.lightprtsbsw = lightprtsbsw;
	}
	/**
	 * @return the hww
	 */
	public double getHww() {
		return hww;
	}
	/**
	 * @param hww the hww to set
	 */
	public void setHww(double hww) {
		this.hww = hww;
	}
	/**
	 * @return the heavyprtsbsw
	 */
	public double getHeavyprtsbsw() {
		return heavyprtsbsw;
	}
	/**
	 * @param heavyprtsbsw the heavyprtsbsw to set
	 */
	public void setHeavyprtsbsw(double heavyprtsbsw) {
		this.heavyprtsbsw = heavyprtsbsw;
	}
	/**
	 * @return the soww
	 */
	public double getSoww() {
		return soww;
	}
	/**
	 * @param soww the soww to set
	 */
	public void setSoww(double soww) {
		this.soww = soww;
	}
	/**
	 * @return the unprtsbsw
	 */
	public double getUnprtsbsw() {
		return unprtsbsw;
	}
	/**
	 * @param unprtsbsw the unprtsbsw to set
	 */
	public void setUnprtsbsw(double unprtsbsw) {
		this.unprtsbsw = unprtsbsw;
	}
	/**
	 * @return the newsblankw
	 */
	public double getNewsblankw() {
		return newsblankw;
	}
	/**
	 * @param newsblankw the newsblankw to set
	 */
	public void setNewsblankw(double newsblankw) {
		this.newsblankw = newsblankw;
	}
	/**
	 * @return the whitegdwdblendw
	 */
	public double getWhitegdwdblendw() {
		return whitegdwdblendw;
	}
	/**
	 * @param whitegdwdblendw the whitegdwdblendw to set
	 */
	public void setWhitegdwdblendw(double whitegdwdblendw) {
		this.whitegdwdblendw = whitegdwdblendw;
	}
	/**
	 * @return the mailundeliverablew
	 */
	public double getMailundeliverablew() {
		return mailundeliverablew;
	}
	/**
	 * @param mailundeliverablew the mailundeliverablew to set
	 */
	public void setMailundeliverablew(double mailundeliverablew) {
		this.mailundeliverablew = mailundeliverablew;
	}
	/**
	 * @return the hoggedbooksw
	 */
	public double getHoggedbooksw() {
		return hoggedbooksw;
	}
	/**
	 * @param hoggedbooksw the hoggedbooksw to set
	 */
	public void setHoggedbooksw(double hoggedbooksw) {
		this.hoggedbooksw = hoggedbooksw;
	}
	/**
	 * @return the occw
	 */
	public double getOccw() {
		return occw;
	}
	/**
	 * @param occw the occw to set
	 */
	public void setOccw(double occw) {
		this.occw = occw;
	}
	/**
	 * @return the dlkw
	 */
	public double getDlkw() {
		return dlkw;
	}
	/**
	 * @param dlkw the dlkw to set
	 */
	public void setDlkw(double dlkw) {
		this.dlkw = dlkw;
	}
	/**
	 * @return the mixedpaperw
	 */
	public double getMixedpaperw() {
		return mixedpaperw;
	}
	/**
	 * @param mixedpaperw the mixedpaperw to set
	 */
	public void setMixedpaperw(double mixedpaperw) {
		this.mixedpaperw = mixedpaperw;
	}
	/**
	 * @return the softwoodchipsw
	 */
	public double getSoftwoodchipsw() {
		return softwoodchipsw;
	}
	/**
	 * @param softwoodchipsw the softwoodchipsw to set
	 */
	public void setSoftwoodchipsw(double softwoodchipsw) {
		this.softwoodchipsw = softwoodchipsw;
	}
	/**
	 * @return the hardwoodchipsw
	 */
	public double getHardwoodchipsw() {
		return hardwoodchipsw;
	}
	/**
	 * @param hardwoodchipsw the hardwoodchipsw to set
	 */
	public void setHardwoodchipsw(double hardwoodchipsw) {
		this.hardwoodchipsw = hardwoodchipsw;
	}
	/**
	 * @return the whitebrokew
	 */
	public double getWhitebrokew() {
		return whitebrokew;
	}
	/**
	 * @param whitebrokew the whitebrokew to set
	 */
	public void setWhitebrokew(double whitebrokew) {
		this.whitebrokew = whitebrokew;
	}
	/**
	 * @return the pwew
	 */
	public double getPwew() {
		return pwew;
	}
	/**
	 * @param pwew the pwew to set
	 */
	public void setPwew(double pwew) {
		this.pwew = pwew;
	}
	/**
	 * @return the brownnapkinbrokew
	 */
	public double getBrownnapkinbrokew() {
		return brownnapkinbrokew;
	}
	/**
	 * @param brownnapkinbrokew the brownnapkinbrokew to set
	 */
	public void setBrownnapkinbrokew(double brownnapkinbrokew) {
		this.brownnapkinbrokew = brownnapkinbrokew;
	}
	/**
	 * @return the pulpwetlapw
	 */
	public double getPulpwetlapw() {
		return pulpwetlapw;
	}
	/**
	 * @param pulpwetlapw the pulpwetlapw to set
	 */
	public void setPulpwetlapw(double pulpwetlapw) {
		this.pulpwetlapw = pulpwetlapw;
	}
	/**
	 * @return the virginpulpw
	 */
	public double getVirginpulpw() {
		return virginpulpw;
	}
	/**
	 * @param virginpulpw the virginpulpw to set
	 */
	public void setVirginpulpw(double virginpulpw) {
		this.virginpulpw = virginpulpw;
	}
	/**
	 * @return the brownwetLapw
	 */
	public double getBrownwetLapw() {
		return brownwetLapw;
	}
	/**
	 * @param brownwetLapw the brownwetLapw to set
	 */
	public void setBrownwetLapw(double brownwetLapw) {
		this.brownwetLapw = brownwetLapw;
	}
	/**
	 * @return the pulpdryLapw
	 */
	public double getPulpdryLapw() {
		return pulpdryLapw;
	}
	/**
	 * @param pulpdryLapw the pulpdryLapw to set
	 */
	public void setPulpdryLapw(double pulpdryLapw) {
		this.pulpdryLapw = pulpdryLapw;
	}
	/**
	 * @return the otherrollsw
	 */
	public double getOtherrollsw() {
		return otherrollsw;
	}
	/**
	 * @param otherrollsw the otherrollsw to set
	 */
	public void setOtherrollsw(double otherrollsw) {
		this.otherrollsw = otherrollsw;
	}
	/**
	 * @return the stbaleswetlapw
	 */
	public double getStbaleswetlapw() {
		return stbaleswetlapw;
	}
	/**
	 * @param stbaleswetlapw the stbaleswetlapw to set
	 */
	public void setStbaleswetlapw(double stbaleswetlapw) {
		this.stbaleswetlapw = stbaleswetlapw;
	}
	/**
	 * @return the sttbaledbrokebutlw
	 */
	public double getSttbaledbrokebutlw() {
		return sttbaledbrokebutlw;
	}
	/**
	 * @param sttbaledbrokebutlw the sttbaledbrokebutlw to set
	 */
	public void setSttbaledbrokebutlw(double sttbaledbrokebutlw) {
		this.sttbaledbrokebutlw = sttbaledbrokebutlw;
	}
	/**
	 * @return the closemonth
	 */
	public int getClosemonth() {
		return closemonth;
	}
	/**
	 * @param closemonth the closemonth to set
	 */
	public void setClosemonth(int closemonth) {
		this.closemonth = closemonth;
	}
	/**
	 * @return the closeyear
	 */
	public int getCloseyear() {
		return closeyear;
	}
	/**
	 * @param closeyear the closeyear to set
	 */
	public void setCloseyear(int closeyear) {
		this.closeyear = closeyear;
	}
	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	/**
	 * @return the total_tonnage
	 */
	public double getTotal_tonnage() {
		return total_tonnage;
	}
	/**
	 * @param total_tonnage the total_tonnage to set
	 */
	public void setTotal_tonnage(double total_tonnage) {
		this.total_tonnage = total_tonnage;
	}
	/**
	 * @return the totalweight
	 */
	public double getTotalweight() {
		return totalweight;
	}
	/**
	 * @param totalweight the totalweight to set
	 */
	public void setTotalweight(double totalweight) {
		this.totalweight = totalweight;
	}
	public int getVirginhardwood() {
		return virginhardwood;
	}
	public void setVirginhardwood(int virginhardwood) {
		this.virginhardwood = virginhardwood;
	}
	public int getVirginsoftwood() {
		return virginsoftwood;
	}
	public void setVirginsoftwood(int virginsoftwood) {
		this.virginsoftwood = virginsoftwood;
	}
	public double getVirginhardwoodw() {
		return virginhardwoodw;
	}
	public void setVirginhardwoodw(double virginhardwoodw) {
		this.virginhardwoodw = virginhardwoodw;
	}
	public double getVirginsoftwoodw() {
		return virginsoftwoodw;
	}
	public void setVirginsoftwoodw(double virginsoftwoodw) {
		this.virginsoftwoodw = virginsoftwoodw;
	}
	/**
	 * @return the unctdflyleafshvgsw
	 */
	public double getUnctdflyleafshvgsw() {
		return unctdflyleafshvgsw;
	}
	/**
	 * @param unctdflyleafshvgsw the unctdflyleafshvgsw to set
	 */
	public void setUnctdflyleafshvgsw(double unctdflyleafshvgsw) {
		this.unctdflyleafshvgsw = unctdflyleafshvgsw;
	}
	/**
	 * @return the looseestW
	 */
	public double getLooseestW() {
		return looseestW;
	}
	/**
	 * @param looseestW the looseestW to set
	 */
	public void setLooseestW(double looseestW) {
		this.looseestW = looseestW;
	}
	/**
	 * @return the virginSoftWoodw
	 */
	public double getVirginSoftWoodw() {
		return virginSoftWoodw;
	}
	/**
	 * @param virginSoftWoodw the virginSoftWoodw to set
	 */
	public void setVirginSoftWoodw(double virginSoftWoodw) {
		this.virginSoftWoodw = virginSoftWoodw;
	}
	/**
	 * @return the virginHardWoodw
	 */
	public double getVirginHardWoodw() {
		return virginHardWoodw;
	}
	/**
	 * @param virginHardWoodw the virginHardWoodw to set
	 */
	public void setVirginHardWoodw(double virginHardWoodw) {
		this.virginHardWoodw = virginHardWoodw;
	}
	/**
	 * @return the virginEucalyptusw
	 */
	public double getVirginEucalyptusw() {
		return virginEucalyptusw;
	}
	/**
	 * @param virginEucalyptusw the virginEucalyptusw to set
	 */
	public void setVirginEucalyptusw(double virginEucalyptusw) {
		this.virginEucalyptusw = virginEucalyptusw;
	}
	/**
	 * @return the scnNewsw
	 */
	public double getScnNewsw() {
		return scnNewsw;
	}
	/**
	 * @param scnNewsw the scnNewsw to set
	 */
	public void setScnNewsw(double scnNewsw) {
		this.scnNewsw = scnNewsw;
	}
	/**
	 * @return the virginSW_Fluffw
	 */
	public double getVirginSW_Fluffw() {
		return virginSW_Fluffw;
	}
	/**
	 * @param virginSW_Fluffw the virginSW_Fluffw to set
	 */
	public void setVirginSW_Fluffw(double virginSW_Fluffw) {
		this.virginSW_Fluffw = virginSW_Fluffw;
	}
	/**
	 * @return the unctdflyleafshvgs
	 */
	public int getUnctdflyleafshvgs() {
		return unctdflyleafshvgs;
	}
	/**
	 * @param unctdflyleafshvgs the unctdflyleafshvgs to set
	 */
	public void setUnctdflyleafshvgs(int unctdflyleafshvgs) {
		this.unctdflyleafshvgs = unctdflyleafshvgs;
	}
	/**
	 * @return the looseest
	 */
	public int getLooseest() {
		return looseest;
	}
	/**
	 * @param looseest the looseest to set
	 */
	public void setLooseest(int looseest) {
		this.looseest = looseest;
	}
	/**
	 * @return the virginSoftWood
	 */
	public int getVirginSoftWood() {
		return virginSoftWood;
	}
	/**
	 * @param virginSoftWood the virginSoftWood to set
	 */
	public void setVirginSoftWood(int virginSoftWood) {
		this.virginSoftWood = virginSoftWood;
	}
	/**
	 * @return the virginHardWood
	 */
	public int getVirginHardWood() {
		return virginHardWood;
	}
	/**
	 * @param virginHardWood the virginHardWood to set
	 */
	public void setVirginHardWood(int virginHardWood) {
		this.virginHardWood = virginHardWood;
	}
	/**
	 * @return the virginEucalyptus
	 */
	public int getVirginEucalyptus() {
		return virginEucalyptus;
	}
	/**
	 * @param virginEucalyptus the virginEucalyptus to set
	 */
	public void setVirginEucalyptus(int virginEucalyptus) {
		this.virginEucalyptus = virginEucalyptus;
	}
	/**
	 * @return the scnNews
	 */
	public int getScnNews() {
		return scnNews;
	}
	/**
	 * @param scnNews the scnNews to set
	 */
	public void setScnNews(int scnNews) {
		this.scnNews = scnNews;
	}
	/**
	 * @return the virginSW_Fluff
	 */
	public int getVirginSW_Fluff() {
		return virginSW_Fluff;
	}
	/**
	 * @param virginSW_Fluff the virginSW_Fluff to set
	 */
	public void setVirginSW_Fluff(int virginSW_Fluff) {
		this.virginSW_Fluff = virginSW_Fluff;
	}
	
}
