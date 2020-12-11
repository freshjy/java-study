package prob3;

public class SmartPhone extends MusicPhone{

	@Override
	public void execute(String function) {
		// TODO Auto-generated method stub
		if (function.equals("앱") ) {
			executeApp();
			return;
		}else if(function.equals("음악")) {
			playMusic();
			return;
		}
		
		super.execute(function);
	}
	
	void playMusic() {
		System.out.println("다운로드해서 음악재생");
	}
	
	private void executeApp() {
		System.out.println("앱실행");
	}
	
}
