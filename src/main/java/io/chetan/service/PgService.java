package io.chetan.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.chetan.dao.PgDao;
import io.chetan.model.Address;
import io.chetan.model.Pg;

@Service
public class PgService 
{

	@Autowired
	private PgDao pgDao ;
	
	public Pg createPg(Pg pg)
	{
		return pgDao.save(pg);
	}

//	public Pg findPG(Address address)
//	{
//		Iterable<Pg> allPGs = pgDao.findAll();
//				
//		 //PG foundPG = null ;
//		/*
//		 * allPGs.forEach(pg->{ if(address.equals(pg.getAddress())) {
//		 * 
//		 * } foundPG = pg; });
//		 */
//		
//		allPGs.forEach(System.out::println);  
//		
//		for(Pg pg : allPGs)
//		{
//			System.out.println("\n PGService findPG(Address address) for(PG pg : allPGs) fro pg = \n"+pg);
//			if(address.equals(pg.getAddress()))
//			{
//				System.out.println("\n PGService findPG(Address address) address.equals(pg.getAddress() = \n"+pg.getAddress());
//				System.out.println("\n so returning pg \n");
//				return pg;
//			}
//		}
//		System.out.println("\n PGService findPG(Address address) coulndt find pg returning null = \n");
//
//		return null ;
//	}

	public Pg findPgById(long pgId) 
	{
		System.out.println("\n PGService findPgById = \n");
		Optional<Pg> optional = pgDao.findById(pgId);
		System.out.println("\n opttional = \n"+optional);
		
		return optional.get();
	}

	public Pg findPG(String houseNumber, String street, String disrtict, String state, String country, String pin)
	{
		Iterable<Pg> allPGs = pgDao.findAll();
		Address compareAddress = new Address(houseNumber,street,disrtict,state,country,pin);
		
		for(Pg pg : allPGs)
		{
			System.out.println("\n PGService findPGfor(PG pg : allPGs) fro pg = \n"+pg);
			if(compareAddress.equals(pg.getAddress()))
			{
				System.out.println("\n yes we found  pg in PGService findPG() @ address.equals(pg.getAddress() = \n"+pg.getAddress());
				System.out.println("\n so returning pg \n");
				return pg;
			}
		}
		System.out.println("\n PGService findPG() coulndt find pg returning null = \n");
		return null ;

	}

	public void updatePg(Pg pg) 
	{
	
		System.out.println("\n PGService updatePg() with pg = \n"+pg);
		
		Pg updatedPg = pgDao.save(pg);
		
		System.out.println("\n updatedPg = \n"+updatedPg);
	}



	
	
}
