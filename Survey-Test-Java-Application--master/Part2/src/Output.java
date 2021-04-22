import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Output extends IO {

	private static final long serialVersionUID = 1L;

	public void display(String stream) {
		System.out.println(stream);
		
		String voiceName = "kevin16";

		VoiceManager voiceManager = VoiceManager.getInstance();
		Voice voice = voiceManager.getVoice(voiceName);

		voice.allocate();
		voice.speak(stream);
		voice.deallocate();
	}
}

