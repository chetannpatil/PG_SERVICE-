package io.chetan.controller;

import javax.websocket.server.PathParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import io.chetan.model.Address;
import io.chetan.model.Pg;
import io.chetan.service.PgService;

@RestController
@RequestMapping(value = "/pg")
public class PgController 
{

	@Autowired
	private PgService pgService;
	
	private static Logger LOGGER = LogManager.getLogger(PgController.class);
	
	@PostMapping(value = "/createPg")
	public @ResponseBody Pg createPG(@RequestBody Pg pg)
	{
		System.out.println("\n -----------PGController createPG() with pg = \n"+pg);
		
		return pgService.createPg(pg);
	}
	
	
	@GetMapping(value = "/read")
	public Pg read()
	{
		System.out.println("\n PGController read = \n");
		
		LOGGER.info("\n PGController read = \n");
		Pg pg = new Pg();
		
		pg.setName("daridra pg");
		pg.setMyOwner(1L);
		
		pg.setPgId(2);
		return pg;
		
	}
	
//	@PostMapping(value = "/findPG")
//	public @ResponseBody Pg findPG(@RequestBody Address address)
//	{
//		System.out.println("\n -----------PGController findPG() with address = \n"+address);
//		
//		return pgService.findPG(address);
//
//	}
	

	//@RequestMapping(value = "/Id/{Id}/Name/{Name}
	//path = "/mno/objectKey/{id}/{name}"
	@GetMapping(value = "findPg/houseNumber/street/disrtict/state/country/pin/{houseNumber}/{street}/{disrtict}/{state}/{country}/{pin}")
	public @ResponseBody Pg findPG(@PathVariable("houseNumber") String houseNumber,
			@PathVariable("street") String street,
			@PathVariable("disrtict") String disrtict,
			@PathVariable("state") String state,
			@PathVariable("country") String country,
			@PathVariable("pin") String pin)
	{
		System.out.println("\n -----------PGController findPG() with address = \n");
		
		return pgService.findPG(houseNumber,street,disrtict,state,country,pin);

	}
	/*
	 * //GET cant have @RequestBody mean GET cant receive objects
	 * 
	 * @GetMapping(value = "/findPG") public @ResponseBody PG findPG(@RequestBody
	 * Address address) {
	 * System.out.println("\n -----------PGController findPG() with address = \n"
	 * +address);
	 * 
	 * return pgService.findPG(address);
	 * 
	 * }
	 */
	
	//       @GetMapping("/exchange/{from}/to/{to}")
//	@GetMapping(value = "/findPgById/{pgId}")
//	public @ResponseBody Pg findPgById(@PathVariable("pgId") long pgId)
//	{
//		                            //@PathVariable("from") String fromValue
//		System.out.println("\n PGController findPgById () with pgid = \n"+pgId);
//		
//		return pgService.findPgById(pgId);
//	}
	
//	@GetMapping(value = "/findPgById")
//	public @ResponseBody Pg findPgById()
//	{
//		                            //@PathVariable("from") String fromValue
//		//System.out.println("\n PGController findPgById () with pgid = \n"+pgId);
//		System.out.println("\n PGController findPgById () with pgid = \n");
//		
//		return pgService.findPgById(0);
//	}
	
	//@GetMapping("employee/{id}")
	@GetMapping(value = "find/{pgId}")
	public @ResponseBody Pg findPgById_temp(@PathVariable("pgId") long pgId,
			@RequestHeader("first-request") String header)
	{                                 //@PathVariable("id") Integer empId
		System.out.println("\n PGController findPgById () with pgid = \n"+pgId);
		
		System.out.println("\n\n\n PG_controller - findPgById with header =   \n\n\n"+header);
		
		LOGGER.info("\n\n\n PG_controller - findPgById with header =   \n\n\n"+header);
		
//		try {
//			//1000 ms - 1s
//			//waiting for 20sceonds
//			
//			Thread.sleep(20000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		 return pgService.findPgById(pgId);
		 
		// ResponseEntity<Pg> pg = new ResponseEntity<Pg>(HttpStatus.OK)
	}
	
	
	//@GetMapping("employee/{id}")
	@GetMapping(value = "findPgById/{pgId}")
	public @ResponseBody Pg findPgById(@PathVariable("pgId") long pgId)
	{                                 //@PathVariable("id") Integer empId
		System.out.println("\n PGController findPgById () with pgid = \n"+pgId);
		
		
		
//		try {
//			//1000 ms - 1s
//			//waiting for 20sceonds
//			
//			Thread.sleep(20000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		 return pgService.findPgById(pgId);
		 
		// ResponseEntity<Pg> pg = new ResponseEntity<Pg>(HttpStatus.OK)
	}
	
	//	@GetMapping(value = "/findPgById/{pgId}")
//	public @ResponseBody Pg findPgById(@PathParam("pgId") long pgId)
//	{
//		System.out.println("\n PGController findPgById () with pgid = \n"+pgId);
//		
//		return pgService.findPgById(pgId);
//	}
//	
	@PutMapping(value = "/updatePg")
	public void updatePg(@RequestBody Pg pg)
	{
		System.out.println("\n PGController updatePg () with pg = \n"+pg);
		
		pgService.updatePg(pg);
	}
}
