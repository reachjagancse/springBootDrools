package com.websystique.springboot.controller;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.kie.api.KieServices;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.KieScanner;
import org.kie.api.definition.KiePackage;
import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.TestDO;
import com.websystique.springboot.model.Discount;
import com.websystique.springboot.model.Rule;
import com.websystique.springboot.service.DiscountService;
import com.websystique.springboot.service.RuleService;
import com.websystique.springboot.util.CustomErrorType;
/*import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.Iterator;*/
@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory
			.getLogger(RestApiController.class);

	@Autowired
	DiscountService discountService;
	
	@Autowired
	RuleService ruleService;

	@RequestMapping(value = "/discount/", method = RequestMethod.GET)
	public ResponseEntity<List<Discount>> listAllDiscounts() {
		List<Discount> discounts = discountService.findAllDiscounts();
		if (discounts.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Discount>>(discounts, HttpStatus.OK);
	}

	@RequestMapping(value = "/discount/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getDiscount(@PathVariable("id") long id) {
		logger.info("Fetching discount with id {}", id);
		Discount discount = discountService.findById(id);
		if (discount == null) {
			logger.error("Discount with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Discount with id "
					+ id + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Discount>(discount, HttpStatus.OK);
	}

	@RequestMapping(value = "/discount/", method = RequestMethod.POST)
	public ResponseEntity<?> createDiscount(@RequestBody Discount discount,
			UriComponentsBuilder ucBuilder) {
		logger.info("Creating discount : {}", discount);

		/*if (discount.getNetInvoiceCurYear() > discount.getTarget()
				&& discount.getSumOfNetValueCurYear() > discount
						.getSumOfNetValueLastYear()) {
			discount.setIncentive(discount.getSumOfNetValueCurYear() / 10);
		} else {
			discount.setIncentive(10);
		}*/
		discountService.saveDiscount(discount);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/discount/{id}")
				.buildAndExpand(discount.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/discount/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateDiscount(@PathVariable("id") long id,
			@RequestBody Discount discount) {
		logger.info("Updating discount with id {}", id);

		Discount currentDiscount = discountService.findById(id);

		currentDiscount.setName(discount.getName());
		currentDiscount.setCurrentYear(discount.getCurrentYear());

		/*if (discount.getNetInvoiceCurYear() > discount.getTarget()
				&& discount.getSumOfNetValueCurYear() > discount
						.getSumOfNetValueLastYear()) {
			currentDiscount
					.setIncentive(discount.getSumOfNetValueCurYear() / 10);
		} else {
			currentDiscount.setIncentive(0);
		}*/
		//currentDiscount.setIncentiveType(discount.getIncentiveType());
		currentDiscount.setMonth(discount.getMonth());

		discountService.updateDiscount(currentDiscount);
		return new ResponseEntity<Discount>(currentDiscount, HttpStatus.OK);
	}

	@RequestMapping(value = "/discount/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteDiscount(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting discount with id {}", id);

		Discount discount = discountService.findById(id);
		if (discount == null) {
			logger.error("Unable to delete. discount with id {} not found.", id);
			return new ResponseEntity(
					new CustomErrorType("Unable to delete. discount with id "
							+ id + " not found."), HttpStatus.NOT_FOUND);
		}
		discountService.deleteDiscountById(id);
		return new ResponseEntity<Discount>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/discount/", method = RequestMethod.DELETE)
	public ResponseEntity<Discount> deleteAllDiscounts() {
		logger.info("Deleting All Discounts");

		discountService.deleteAllDiscounts();
		return new ResponseEntity<Discount>(HttpStatus.NO_CONTENT);
	}
	@RequestMapping(value = "/rule/", method = RequestMethod.POST)
	public ResponseEntity<?> createRule(@RequestBody Rule rule,
			UriComponentsBuilder ucBuilder) {
		logger.info("Creating rule : {}", rule);
		
		String ruleNames="";
		Iterator itr=rule.getRulesSelection().iterator();
while(itr.hasNext()){
	ruleNames=ruleNames+itr.next();
	if(itr.hasNext()){
		ruleNames=ruleNames+";";
	}
}
rule.setRulesSelected(ruleNames);
		ruleService.saveRule(rule);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/rule/{id}")
				.buildAndExpand(rule.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value = "/fileUpload/", method = RequestMethod.POST)
	public  ResponseEntity<?> fileUpload(@RequestBody MultipartFile file,UriComponentsBuilder ucBuilder) {
		HttpHeaders headers = new HttpHeaders();
		List<Discount> discounts=new ArrayList<Discount>();
		Discount discount=null;
		try {
			InputStream inputStream = file.getInputStream();
			// Create Workbook instance for xlsx/xls file input stream
			Workbook workbook = null;
			if (file.getOriginalFilename().toLowerCase().endsWith("xlsx")) {
				workbook = new XSSFWorkbook(inputStream);
			} else if (file.getOriginalFilename().toLowerCase().endsWith("xls")) {
				workbook = new HSSFWorkbook(inputStream);
			}
			int numberOfSheets = workbook.getNumberOfSheets();
				Sheet sheet = workbook.getSheetAt(0);
				Iterator<Row> rowIterator = sheet.iterator();
				rowIterator.next();
				rowIterator.next();
				while (rowIterator.hasNext()) {
				Row row=rowIterator.next();
				 discount=new Discount();
				 
				 discount.setName(getValueFromCell(row.getCell(1)));
				 discount.setTarget(new BigDecimal(getValueFromCell(row.getCell(2))).setScale(2, 5));
				 discount.setNetInvoiceCurYear(new BigDecimal(getValueFromCell(row.getCell(3))).setScale(2, 5));
				 discount.setSumOfBilledQtyLastYear(new BigDecimal(getValueFromCell(row.getCell(4))).setScale(2, 5));
				 discount.setSumOfNetValueLastYear(new BigDecimal(getValueFromCell(row.getCell(5))).setScale(2, 5));
				 discount.setSumOfBilledQtyCurYear(new BigDecimal(getValueFromCell(row.getCell(6))).setScale(2, 5));
				 discount.setSumOfNetValueCurYear(new BigDecimal(getValueFromCell(row.getCell(7))).setScale(2, 5));
				Double increase=(discount.getSumOfNetValueCurYear().doubleValue()/discount.getSumOfNetValueLastYear().doubleValue())-1;
				discount.setGrowth(BigDecimal.valueOf(increase).setScale(2,BigDecimal.ROUND_UP).multiply(new BigDecimal(100)));
				/*increase=increase.divide(discount.getSumOfNetValueLastYear().setScale(2, 5)).setScale(2, 5);
				BigDecimal increasePercentage=(increase.divide(discount.getSumOfNetValueCurYear())).multiply(new BigDecimal(100));
				discount.setGrowth(increasePercentage);
				*/  discount.setCurrentYear("2017");
				 discount.setMonth("MAY");
				 discount.setPreviousYear("2016");
				 discounts.add(discount);
				}
			//}
			discountService.saveDiscount(discounts);
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	private String getValueFromCell(Cell cell) {
		
		String valueFromCell="";
		if(cell!=null){
		 if(Cell.CELL_TYPE_NUMERIC==cell.getCellType()){
			 valueFromCell=cell.getNumericCellValue()+"";
		 }else if(Cell.CELL_TYPE_STRING==cell.getCellType()){
			 valueFromCell=cell.getStringCellValue();
		 }else if(Cell.CELL_TYPE_FORMULA==cell.getCellType()){
			 
			 switch(cell.getCachedFormulaResultType()) {
	            case Cell.CELL_TYPE_NUMERIC:
	            	 valueFromCell=cell.getNumericCellValue()+"";
	                break;
	            case Cell.CELL_TYPE_STRING:
	            	valueFromCell=cell.getRichStringCellValue() + "\"";
	                break;
	        }
			
		 }}
		 if(valueFromCell==""){
valueFromCell="0";
		 }
		 return valueFromCell;
	}
	
	
	@RequestMapping(value = "/rule/", method = RequestMethod.GET)
	public ResponseEntity<List<Rule>> listAllRules() {
		List<Rule> rules = ruleService.findAllRules();
		if (rules.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Rule>>(rules, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/inci/{schemesToApply}", method = RequestMethod.GET)
	public ResponseEntity<List<Discount>> getIncentives(
			@PathVariable("schemesToApply") String schemesToApply) {
		KieSession kSession=getKieSession();
List<TestDO> testDOs=new ArrayList<TestDO>();
		//List<Rule> rules = ruleService.findAllRules();
		List<Discount> discounts = discountService.findAllDiscounts();
		if(!"No Rules".equalsIgnoreCase(schemesToApply)){
		for (Discount discount : discounts) {
			TestDO testDO = new TestDO();
			testDO.setMonth(discount.getId().intValue());
			testDO.setCurrentTarget(discount.getTarget().setScale(2,5));
			testDO.setCurrentTargetAchieved(discount
					.getNetInvoiceCurYear());
			testDO.setMonthlySalesCuryr(discount
					.getSumOfNetValueCurYear());
			testDO.setMonthlySalesLastYr(discount
					.getSumOfNetValueLastYear());
			testDO.setIncentivePercentage(discount
					.getIncentivePercentage());
			testDO.setGrowth(discount.getGrowth());
			
			/*if (testDO.getIncentive() == null) {
				discount.setIncentive(BigDecimal.ZERO);
			} else {
				discount.setIncentive(testDO.getIncentive().setScale(3,5));
			}*/
			testDOs.add(testDO);
			kSession.insert(testDO);
		}
		  Rule rule=ruleService.findByName(schemesToApply);
          for(String ruleSelectedToApply:Arrays.asList(rule.getRulesSelected().split(";"))){
          kSession.fireAllRules(new RuleNameEqualsAgendaFilter(ruleSelectedToApply));
          
          }
          kSession.dispose();
          
          for (TestDO testD : testDOs) {
        	  Discount disc=getDiscountById(discounts,testD.getMonth());
        	  if(testD.getIncentive()!=null){
        	  disc.setIncentive(testD.getIncentive().setScale(3, 5));
          }else{
        	  disc.setIncentive(BigDecimal.ZERO);
          }
		}
		
		}else{for (Discount discount : discounts) {
			
			discount.setIncentive(null);
		}}

		if (discounts == null || discounts.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Discount>>(discounts, HttpStatus.OK);
	}
	


	private Discount getDiscountById(List<Discount> discounts, Integer month) {
		// TODO Auto-generated method stub
		
		Discount disc=null;
		for (Discount discount : discounts) {
			if(discount.getId()==month.longValue()){
				disc=discount;
				
			}
		}
		return disc;
	}

	private List<String> getRuleNames() {
		List<String> ruleNames=new ArrayList<String>();
		KieSession kSession=getKieSession();
		for(KiePackage kiep:kSession.getKieBase().getKiePackages()){
           	for(org.kie.api.definition.rule.Rule r:kiep.getRules()){
           		ruleNames.add(r.getName());
           	}
           }
		return ruleNames;
	}

	private KieSession getKieSession() {
		String urlStr = "http://localhost:8180/kie-drools-wb-7.3.0.Final-tomcat8/maven2/INCAABOSCH_Group/INCAABOSCH_Artifact/1.0.0/INCAABOSCH_Artifact-1.0.0.jar";
	     KieSession kSession = null;
        try {
                    URL url = new URL(urlStr);
                    String userPassword = "admin" + ":" + "admin";
                    String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));                           
                    HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
                    httpConn.setRequestProperty("Authorization", "Basic " + encoding);
                    int responseCode = httpConn.getResponseCode();
                    System.out.println(responseCode);
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                                // opens input stream from the HTTP connection
                                InputStream inputStream = httpConn.getInputStream();
                                // Load the knowledge base:
                                KieServices ks = KieServices.Factory.get();
                                KieRepository repo = ks.getRepository();
                                KieModule kModule = repo.addKieModule(ks.getResources().newInputStreamResource(inputStream));
                                //KieModule kModule = repo.addKieModule(ks.getResources().newUrlResource(url, encoding));
                                inputStream.close();
                                KieContainer kContainer = ks.newKieContainer(kModule.getReleaseId());
                                KieScanner kieScanner = ks.newKieScanner(kContainer);
                                kieScanner.start(900000L);     
                                //KiePackage kPackage = kContainer.getKieBase().getKiePackages().iterator().next();
                                kSession = kContainer.newKieSession();
                    }
                   

        } catch (Exception e) {
                    e.printStackTrace();
        }
        return kSession;
	}
	
	
	@RequestMapping(value = "/loadAllShemes/", method = RequestMethod.GET)
	public ResponseEntity<List<Rule>> loadAllShemes() {
		List<Rule> rules = ruleService.findAllRules();
		if (rules.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Rule>>(rules, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/loadAllRuleNamesFromDrools/", method = RequestMethod.GET)
	public ResponseEntity<List<String>> loadAllRuleNamesFromDrools() {
		List<String> rules=this.getRuleNames();
		return new ResponseEntity<List<String>>(rules, HttpStatus.OK);
	}
	
	
	
}