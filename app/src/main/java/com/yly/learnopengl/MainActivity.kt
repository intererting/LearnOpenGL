package com.yly.learnopengl

import android.app.ActivityManager
import android.content.Context
import android.opengl.GLSurfaceView
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var mGLSurfaceView: GLSurfaceView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mGLSurfaceView = GLSurfaceView(this)
        if (detectOpenGLES30()) {
            // Tell the surface view we want to create an OpenGL ES 3.0-compatible
// context, and set an OpenGL ES 3.0-compatible renderer.
            mGLSurfaceView.setEGLContextClientVersion(3)
            mGLSurfaceView.setRenderer(ParticleSystemRenderer(this))
        } else {
            finish()
        }
        setContentView(mGLSurfaceView)
    }

    private fun detectOpenGLES30(): Boolean {
        val am = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val info = am.deviceConfigurationInfo
        return info.reqGlEsVersion >= 0x30000
    }

    override fun onResume() {
        // Ideally a game should implement onResume() and onPause()
// to take appropriate action when the activity looses focus
        super.onResume()
        mGLSurfaceView.onResume()
    }

    override fun onPause() {
        // Ideally a game should implement onResume() and onPause()
// to take appropriate action when the activity looses focus
        super.onPause()
        mGLSurfaceView.onPause()
    }
}
