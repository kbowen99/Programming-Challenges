
public class ComboFrag {
	Fragment frag1;
	Fragment frag2;
	
	Fragment c1;
	Fragment c2;
	
	Fragment comboFrag;
	
	public ComboFrag(Fragment f1, Fragment f2){
		this.frag1 = f1;
		this.frag2 = f2;
		this.c1 = new Fragment(this.frag1.getContents() + this.frag2.getContents());
		this.c2 = new Fragment(this.frag2.getContents() + this.frag1.getContents());
	}

	public Fragment getFrag1() {
		return frag1;
	}

	public void setFrag1(Fragment frag1) {
		this.frag1 = frag1;
	}

	public Fragment getFrag2() {
		return frag2;
	}

	public void setFrag2(Fragment frag2) {
		this.frag2 = frag2;
	}

	public Fragment getC1() {
		return c1;
	}

	public void setC1(Fragment c1) {
		this.c1 = c1;
	}

	public Fragment getC2() {
		return c2;
	}

	public void setC2(Fragment c2) {
		this.c2 = c2;
	}

	public Fragment getComboFrag() {
		return comboFrag;
	}

	public void setComboFrag(Fragment comboFrag) {
		this.comboFrag = comboFrag;
	}
}
