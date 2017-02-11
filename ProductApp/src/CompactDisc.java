/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**Description: A subclass of Product that gets and sets data related to a 
 * compact disc.
 *
 * @author Alyssa Watson
 * @created 02/01/17
 */
public class CompactDisc extends Product {
    private String artist;
    
    	public CompactDisc()
	{
		super();
		artist = "";
		count++;
	}
        public void setArtist(String artist)
	{
		this.artist = artist;
	}

	public String getArtist(){
		return artist;
	}

        @Override
	public String toString()
	{
		return super.toString() +
			"Artist:      " + artist + "\n";
	}
    
}
