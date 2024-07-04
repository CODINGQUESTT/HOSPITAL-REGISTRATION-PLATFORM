package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Service.Agevalidation;
import com.example.demo.Service.Contactvalidation;
import com.example.demo.Service.pincodevalidation;
import com.example.demo.Service.SetConstantValue;
import com.example.demo.Service.anydiagnosisvalidation;
import com.example.demo.Service.bloodvalidation;
import com.example.demo.Service.cityvalidation;
import com.example.demo.Service.departmentvalidation;
import com.example.demo.Service.GenderValidation;
import com.example.demo.Service.HouseValidation;
import com.example.demo.Service.ParentValidation;
import com.example.demo.Service.PidValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.demo.obj.Addressdata;
import com.example.demo.obj.Personaldata;
import com.example.demo.repository.address_interface;
import com.example.demo.repository.department_interface;
import com.example.demo.repository.medicalhistory_interface;
import com.example.demo.repository.perosnaldetails_interface;
import com.example.demo.obj.Medicalhistorydata;
import com.example.demo.obj.Departmentdata;
import com.example.demo.constant.ApplicationConstant;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.fasterxml.jackson.databind.*;
//extra import
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;





@CrossOrigin(origins="http://localhost:3000")
//convert this class in to API class
@RestController
public class Controller implements WebMvcConfigurer{//extra implements
	
	//create object on interface
	@Autowired
	perosnaldetails_interface piobj;
	@Autowired
	address_interface adobj;
	@Autowired
	department_interface deobj;
	@Autowired
	medicalhistory_interface mdobj;
	
	
	//create Constant object
	ApplicationConstant constantObj= new ApplicationConstant();
	//extra code remove
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:57503")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }
	
	@RequestMapping("/user")
	List<Personaldata> fetchuser()
	{
		return piobj.findAll();
	}
	
	@RequestMapping("/personalDetails/{name}/{gender}/{age}/{contact}/{email}/{bg}/{gname}")
	Personaldata personalDetails(@PathVariable String name,
			@PathVariable String gender,
			@PathVariable String age,
			@PathVariable String contact,
			@PathVariable String email,
			@PathVariable String bg,
			@PathVariable String gname)
	{
		//perform the validation operation
		//Agevalidation ageobj=new Agevalidation();
		//boolean agec1=ageobj.ispositive(age);
		//perform validation on contact
		//Contactvalidation cv=new Contactvalidation();
		//boolean conc1=cv.iscontact(contact);
		
		//SetConstantValue cvalue= new SetConstantValue();
		
		new SetConstantValue().setGender(constantObj.genderList);
		new SetConstantValue().setbloodgroup(constantObj.bloodList);
		//validate the gender
		//GenderValidation gobj= new GenderValidation();
		//boolean gstatus=gobj.validateGender(constantObj.genderList,gender);
		
		
		//validate the blood group
		//bloodvalidation bobj=new bloodvalidation();
		//boolean bstatus=bobj.validatebloodgroup(constantObj.bloodList,bg);
		
		//ParentValidation psobj=new ParentValidation();
		//boolean pstatus=psobj.validateparent(gname);
		
		
		
		
		
		//save the data
		if(new Agevalidation().ispositive(age) &&new Contactvalidation().iscontact(contact) && new GenderValidation().validateGender(constantObj.genderList,gender)&& new bloodvalidation().validatebloodgroup(constantObj.bloodList,bg)&& new ParentValidation().validateparent(gname))
		{
			//Random rand=new Random();
			//int num=rand.nextInt(1000);
			//String pid=Integer.toString(num);
			// create single object to insert the data 
			Personaldata pobj=new Personaldata();
			pobj.setName(name);
			pobj.setGender(gender);
			pobj.setAge(age);
			pobj.setContact(contact);
			pobj.setEmail(email);
			pobj.setBg(bg);
			pobj.setGname(gname);
		    pobj.setPid(Integer.toString(new Random().nextInt(1000)));
		    piobj.save(pobj);
			return pobj;		
			
		}
		return null;
		
		
	}
	

	
	
	@RequestMapping("/address/{houseno}/{streetno}/{pincode}/{city}/{country}/{pid}")
	Object address(@PathVariable String houseno,
	@PathVariable String streetno,
	@PathVariable String pincode,
	@PathVariable String city,
	@PathVariable String country,
	@PathVariable String pid)
	{
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("C:\\Users\\Gautam kumar\\Desktop\\Full Stack JAVA\\demo\\src\\main\\resources\\countryname.json"));
			JSONObject jsonObject = (JSONObject) obj;
			Object countryName = jsonObject.get("country");
			Object statename = jsonObject.get("INDIA");
			Object cityname = jsonObject.get("delhi");
			Object pincode1 = jsonObject.get("noida");
			//validation process	
		    HouseValidation hobj=new HouseValidation();
		    boolean hstatus=hobj.ValidateHouseno(houseno);  
			//pincode must be valid pincode ( Pincode )   
			//City - valid and county Valid 
		    new SetConstantValue().setcity(constantObj.cityList,cityname);
		    cityvalidation cobj=new cityvalidation();
		    boolean cstatus=cobj.ValidateCity(city,constantObj.cityList);  
		    
		    new SetConstantValue().setpincode(constantObj.pincodeList,pincode1);
			pincodevalidation pinobj=new pincodevalidation();
			boolean pinc1=pinobj.iscorrect(pincode,constantObj.pincodeList);
			//on pid 
			boolean pidstatus=new PidValidation().validate(pid,piobj.findAll());
			if(pinc1 && cstatus && hstatus && pidstatus)
			{
				Addressdata aobj=new Addressdata();
				aobj.setHouseno(houseno);
				aobj.setStreetno(streetno);
				aobj.setPincode(pincode);
				aobj.setCity(city);
				aobj.setCountry(country);
				aobj.setPid(pid);
				adobj.save(aobj);
				return aobj;
			}
		   
		     return null;
			
		}
		catch (FileNotFoundException e) {
			return "file not found";
		} catch (IOException e) {
			return "IO Exce";
		} catch (ParseException e) {
			return "parse exce";
		} catch(Exception e) {
			return e.getMessage();
		}
		
	}

	@RequestMapping("/medicalhistory/{anydiagnosis}/{doctorname}/{pid}")
	Medicalhistorydata medicalhistory(@PathVariable String anydiagnosis,
			@PathVariable String doctorname,
			@PathVariable String pid)
	 {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("C:\\Users\\Gautam kumar\\Desktop\\Full Stack JAVA\\demo\\src\\main\\resources\\anydiagnosis.json"));
			JSONObject jsonObject = (JSONObject) obj;
			Object diagnosedwith_json = jsonObject.get("diagnosedwith");
			new SetConstantValue().setdiagnosedwith(constantObj.dignosedwith,diagnosedwith_json);
		    anydiagnosisvalidation dobj1=new anydiagnosisvalidation();
		    boolean dstatus=dobj1.validatedig(constantObj.dignosedwith,anydiagnosis);
		  //on pid 
			boolean pidstatus=new PidValidation().validate(pid,piobj.findAll());
		    if(dstatus && pidstatus) {
		    	Medicalhistorydata mobj=new Medicalhistorydata();
				mobj.setAnydiagnosis(anydiagnosis);
				mobj.setDoctorname(doctorname);
				mobj.setPid(pid);
				mdobj.save(mobj);
			    return mobj;	
		    }
		}
		catch(Exception e)
		{
			
		}
		return null;
			
     }
    @RequestMapping("/department/{department_name}/{specialdoctor}/{pid}")
    Departmentdata department(@PathVariable String department_name,
    		@PathVariable String specialdoctor,
    		@PathVariable String pid)
    {
    	JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("C:\\Users\\Gautam kumar\\Desktop\\Full Stack JAVA\\demo\\src\\main\\resources\\departmentname.json"));
			JSONObject jsonObject = (JSONObject) obj;
			
		    Object department_json=jsonObject.get("departmentname");
			Object cardilogydoc_json = jsonObject.get("cardiology");
			Object urologydoc_json = jsonObject.get("urology");
			Object dentistdoc_json = jsonObject.get("dentist");
			
			new SetConstantValue().setdepartmentname(constantObj.departmentList,department_json);
		    departmentvalidation dobj2=new departmentvalidation();
		    boolean destatus=dobj2.validatedig(constantObj.departmentList,department_name);
		  //on pid 
			boolean pidstatus=new PidValidation().validate(pid,piobj.findAll());
	    	if(destatus && pidstatus) {
				Departmentdata dobj=new Departmentdata();
		    	dobj.setDepartmentname(department_name);
		    	dobj.setSpecialdoctor(specialdoctor);
		    	dobj.setPid(pid);
		    	deobj.save(dobj);
		    	return dobj;
	    	}
		}
		catch(Exception e) {
			
		}
		return null;
}

// doctoprescription {pid}/{TreatmentLinE/{DurtionofTreatment}/{nextVissit)
    //one month
}



 

















































































































































































































































































































































	
