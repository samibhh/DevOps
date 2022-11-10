package com.esprit.examen.services;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.esprit.examen.entities.CategorieFournisseur;
import com.esprit.examen.entities.DetailFournisseur;
import com.esprit.examen.entities.Fournisseur;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FournisseurServiceImplTest {
	@Autowired
	IFournisseurService fs;
	/*
	private Fournisseur initF()
	{
	    Date date = new Date(0);  
		DetailFournisseur detailFournisseur=new DetailFournisseur(null, "fournisseur@gmail.com",date,"Tunis","RandomMat", null);
		Fournisseur f = new Fournisseur(null,"RandomCode","FournisseurTest",CategorieFournisseur.ORDINAIRE,null,null,detailFournisseur);
		return f;
	}*/
	@Test
	public void testRetrieveAllFournisseurs(){
		assertNotNull(fs.retrieveAllFournisseurs());
	}
	@Test
	public void testAddFournisseur() {
	//	List<Stock> stocks = stockService.retrieveAllStocks();
	//	int expected=stocks.size();
		Date date = new Date(0);  
		DetailFournisseur detailFournisseur=new DetailFournisseur(null, "fournisseur@gmail.com",date,"Tunis","RandomMat", null);
		Fournisseur f = new Fournisseur(null,"RandomCode","FournisseurTest",CategorieFournisseur.ORDINAIRE,null,null,detailFournisseur);
		
		//Fournisseur f=initF();
		Fournisseur savedFournisseur= fs.addFournisseur(f);
		
	//	assertEquals(expected+1, stockService.retrieveAllStocks().size());
		assertNotNull(savedFournisseur.getLibelle());
		fs.deleteFournisseur(savedFournisseur.getIdFournisseur());
		
	} 
	
	@Test
	public void testDeleteFournissuer() {
		//Fournisseur f=initF();
		Date date = new Date(0);  
		DetailFournisseur detailFournisseur=new DetailFournisseur(null, "fournisseur@gmail.com",date,"Tunis","RandomMat", null);
		Fournisseur f = new Fournisseur(null,"RandomCode","FournisseurTest",CategorieFournisseur.ORDINAIRE,null,null,detailFournisseur);
		
		Fournisseur savedFournisseur= fs.addFournisseur(f);
		fs.deleteFournisseur(savedFournisseur.getIdFournisseur());
		assertNull(fs.retrieveFournisseur(savedFournisseur.getIdFournisseur()));
	}

	
}
