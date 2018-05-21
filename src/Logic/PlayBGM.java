package Logic;

import javafx.scene.media.AudioClip;

public class PlayBGM implements Runnable{
	private AudioClip BGM;
	private boolean isBGMRunning;
	private long duration;

	public PlayBGM(AudioClip BGM,long duration) {
		this.BGM = BGM;
		this.BGM.setVolume(0.5);
		this.duration = duration*1000;
		
	}
	@Override
	public void run() {
		isBGMRunning = true;
		while (isBGMRunning) {
			BGM.play();
			try {
				Thread.sleep(duration);
			} catch (InterruptedException e) {
				BGM.stop();
				e.printStackTrace();
			}
		}
		
	}
	
	public boolean isBGMRunning() {
		return isBGMRunning;
	}
	public void setBGMRunning(boolean isBGMRunning) {
		this.isBGMRunning = isBGMRunning;
	}
	
}
