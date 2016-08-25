package weapon;

/**
 * Magic - Useless Java Structure
 * @author Kurt Bowen (Kbowen99)
 *
 */
public class magic {
	/**
	 * Sentinel used for auto generating magics
	 */
	private static final int Sentinel = 100;
	
	/**
	 * Only Real Variable in Structure
	 */
	private int magicNumber = 0;
	
	/**
	 * Auto Generates Magics
	 */
	public magic(){
		while(this.magicNumber < Sentinel){
			this.magicNumber = randomInt();
		}
	}
	
	/**
	 * Manually set Magics
	 * @param magics - Magics to Magic
	 */
	public magic(int magics){
		this.magicNumber = magics;
	}
	
	/**
	 * Generate 'Random' number
	 * @return - 'Random' Number
	 */
	private int randomInt(){
		return (int)(Math.random() * 1000);
	}
	
	/**
	 * Object Print Method
	 * @return - Number of Magics as a string
	 */
	public String print(){
		return this.magicNumber + " Magics";
	}
}
