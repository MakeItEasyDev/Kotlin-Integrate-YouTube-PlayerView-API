package com.kotlin.youtubeplayer

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        youtubePlayer.initialize("AIzaSyDv-gjtmZh1h9WKwQbp-aySccEFlDkxFuk", this)
    }

    override fun onInitializationSuccess(
        provider: YouTubePlayer.Provider?,
        player: YouTubePlayer?,
        wasRestored: Boolean
    ) {
        Toast.makeText(this, "Youtube API Initialization Success", Toast.LENGTH_SHORT).show()

        if (!wasRestored) {
            player?.loadVideo("1cSkvtM15-c")
        }
    }

    override fun onInitializationFailure(
        provider: YouTubePlayer.Provider?,
        result: YouTubeInitializationResult?
    ) {
        Toast.makeText(this, "YouTube API Initialization Failure", Toast.LENGTH_SHORT).show()
    }
}