package ru.chipenable.videoview;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener{

    private final String TAG = getClass().getName();
    private final String URL = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";
    private VideoView videoView;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVideoView();
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.seekTo(100);
        mediaController.setAnchorView(videoView);
    }

    private void initVideoView(){
        videoView = (VideoView)findViewById(R.id.video_view);
        mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.setOnPreparedListener(this);
        try {
            videoView.setVideoPath(URL);
        }
        catch (Exception e) {
            Log.d(TAG, e.toString());
        }
    }

}
