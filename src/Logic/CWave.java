package Logic;

public class CWave {
	private static final int[] waveL = {0,3,6,9,11,14,17};
	private static int stage;
	private int count;
	
	public CWave() {
		this.stage = 1;
		this.count = 0;
	}
	
	public void count() {
		count++;
	}
	
	public void stage() {
		for(int i = stage; i < 6;i++ ) {
			if(count == waveL[i]) {
				this.stage = i;
				break;
			}
		}
		this.count = 0;
	}
	
	public static int getSatge() {
		return stage;
		
	}
}
