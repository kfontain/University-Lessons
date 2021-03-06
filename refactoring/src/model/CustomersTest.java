package model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomersTest {

	@Test
	public void testStatement() {
		Movie rougueOne = new Movie("Rogue One", Movie.NEW_RELEASE) ;
		Movie reineDesNeiges = new Movie("Reine des neiges", Movie.CHILDRENS) ;
		Movie starWarsIII = new Movie("Star Wars III", Movie.REGULAR) ;
		
		Rental rental_1 = new Rental(rougueOne, 5);
		Rental rental_2 = new Rental(reineDesNeiges, 7);
		Rental rental_3 = new Rental(starWarsIII, 4);
		
		Customer customer = new Customer("bob");
		customer.addRental(rental_1);
		customer.addRental(rental_2);
		customer.addRental(rental_3);
		
		TextStatment textBuilder = new TextStatment();
		customer.statement(textBuilder);
		
		HTMLStatment htmlBuilder = new HTMLStatment();
		customer.statement(htmlBuilder);

		assertEquals("Rental Record for bob\n" + 
				"	Rogue One	15.0\n" + 
				"	Reine des neiges	7.5\n" + 
				"	Star Wars III	5.0\n" + 
				"Amount owned is 27.5\n" + 
				"You earned 4.0 frequent renter points"
				, textBuilder.getResult());
		
		assertEquals("<html><body><H1>Rental Record for bob<BR><EM><P>Rogue One	15.0</P><BR><EM><P>Reine des neiges	7.5</P><BR><EM><P>Star Wars III	5.0</P><BR><P>Amount owned is 27.5</P><BR><P>You earned 4.0 frequent renter points</P><BR></body></html>", htmlBuilder.getResult());
		
	}

}
