package model;

public class Rental {
    private Movie _movie;
    private int _daysRented;
    
    public Rental(Movie movie, int daysRented)
    {
	_movie=movie;
	_daysRented=daysRented;
    }
    public int getDaysRented()
    {
	return _daysRented; 
    }
    public Movie getMovie()
    {
	return _movie;
    }
    
    //calculer les points fidelites
    public int getFrequentRentalPoints() {
		if( (this.getMovie().getPrice()== Movie.NEW_RELEASE) && (this.getDaysRented()>1)) 
		    return 2 ;
		
		return 1 ;
    }
}
