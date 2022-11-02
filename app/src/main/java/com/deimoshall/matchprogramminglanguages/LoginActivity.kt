package com.deimoshall.matchprogramminglanguages

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import android.widget.VideoView

class LoginActivity : AppCompatActivity() {

    lateinit var videoBackground: VideoView
    lateinit var btnGetStarted: Button
    lateinit var cbTestYourself: CheckBox
    lateinit var etUsername: EditText
    lateinit var mediaPlayer: MediaPlayer
    lateinit var musicPlayer: MediaPlayer
    private var currentVideoPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        videoBackground = findViewById(R.id.vv_background)
        btnGetStarted = findViewById(R.id.btn_get_started)
        cbTestYourself = findViewById(R.id.cb_test_yourself)
        etUsername = findViewById(R.id.et_username)

        musicPlayer = MediaPlayer.create(applicationContext, R.raw.dark_terminal)

        val uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.cmatrix)
        videoBackground.setVideoURI(uri)
        videoBackground.start()

        videoBackground.setOnPreparedListener { mp ->
            mediaPlayer = mp
            mediaPlayer.isLooping = true

            musicPlayer.start()
            musicPlayer.isLooping = true

            if (currentVideoPosition != 0) {
                mediaPlayer.seekTo(currentVideoPosition)
                mediaPlayer.start()
            }
        }

        btnGetStarted.setOnClickListener {
            val username: String = etUsername.text.toString()
            val testYourself: String = cbTestYourself.isChecked.toString()

            if (username.isEmpty()) {
                Toast.makeText(applicationContext, R.string.no_username, Toast.LENGTH_SHORT).show()
            } else {
                musicPlayer.pause()
                val intent = Intent(applicationContext, MainActivity::class.java).apply {
                    putExtra("username", username)
                    putExtra("test_yourself", testYourself)
                }
                startActivity(intent)
            }
        }
    }

    override fun onPause() {
        super.onPause()

        musicPlayer.pause()

        currentVideoPosition = mediaPlayer.currentPosition
        videoBackground.pause()
    }

    override fun onResume() {
        super.onResume()

        musicPlayer.start()
        videoBackground.start()
    }

    override fun onDestroy() {
        super.onDestroy()

        musicPlayer.release()
        mediaPlayer.release()
    }
}