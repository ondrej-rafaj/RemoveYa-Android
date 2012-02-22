package cz.ursimon.removya;

import java.io.IOException;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class RemoveYaActivity extends Activity {
	
	private MediaPlayer player;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main); 
    }
    
    public void playbutton(View view) {
    	AssetFileDescriptor afd = null; 
		try {
			afd = getAssets().openFd("removeya.mp3");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        player = new MediaPlayer();
        try {
			player.setDataSource(afd.getFileDescriptor());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			player.prepare();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        player.start();

    }
    
    public void onPause() {
    	super.onPause();
    	if (player!=null) {
    		player.stop();
    		player.release();
    		
    	}
    	finish();
    }
}