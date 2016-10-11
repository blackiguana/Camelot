import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;

public class WavPlayer extends Thread {
	private String soundFile;
	private boolean bSoundOff;

	public WavPlayer(String filename) {
		this.soundFile = filename;
		this.bSoundOff = false;
	}

	public void run() {
		if (!this.bSoundOff) {
			try {
				Throwable e = null;
				Object arg1 = null;

				try {
					AudioInputStream audioInputStream = AudioSystem
							.getAudioInputStream(ClassLoader.getSystemResourceAsStream(this.soundFile));

					try {
						AudioFormat format = audioInputStream.getFormat();
						Info info = new Info(SourceDataLine.class, format);
						SourceDataLine audioDataLine = (SourceDataLine) AudioSystem.getLine(info);
						audioDataLine.open(format);
						audioDataLine.start();
						byte[] audioBytes = new byte[524288];
						int readBytes = 0;

						while (readBytes != -1) {
							readBytes = audioInputStream.read(audioBytes, 0, audioBytes.length);
							if (readBytes >= 0) {
								audioDataLine.write(audioBytes, 0, readBytes);
							}
						}
					} finally {
						if (audioInputStream != null) {
							audioInputStream.close();
						}

					}

				} catch (Throwable arg15) {
					if (e == null) {
						e = arg15;
					} else if (e != arg15) {
						e.addSuppressed(arg15);
					}

					//throw e;
				}
			} catch (Exception arg16) {
				arg16.printStackTrace();
			}
		}
	}

	public void toggleSound() {
		this.bSoundOff = !this.bSoundOff;
	}
}