package com.gautam.camerause

import android.content.pm.PackageManager
import android.opengl.Matrix
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Rational
import android.util.Size
import android.view.Surface
import android.view.ViewGroup
import android.widget.Toast
import androidx.camera.core.*
import androidx.core.app.ActivityCompat
import androidx.lifecycle.LifecycleOwner
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity(), LifecycleOwner {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA),1234)
        }
        else{
            textureView.post {
                startCamera()
            }
        }
    }

    private fun startCamera() {
        // to capture image on button click
        val imageCaptureConfig=ImageCaptureConfig.Builder().apply {
            setTargetAspectRatio(Rational(1,1))
            setCaptureMode(ImageCapture.CaptureMode.MIN_LATENCY)
        }.build()
        val imageCapture=ImageCapture(imageCaptureConfig)
        imageButton.setOnClickListener{
            val file=File(externalMediaDirs.first(),"${System.currentTimeMillis()}.jpg")
            imageCapture.takePicture(file,object : ImageCapture.OnImageSavedListener{
                override fun onImageSaved(file: File) {
                    Toast.makeText(this@MainActivity,"Picture Captured at ${file.path}",Toast.LENGTH_LONG).show()
                }

                override fun onError(useCaseError: ImageCapture.UseCaseError, message: String, cause: Throwable?) {
                    Toast.makeText(this@MainActivity,"Error Capturing Picture",Toast.LENGTH_LONG).show()
                }

            })
        }



        //To get the preview of the camera
        val previousConfig=PreviewConfig.Builder().apply {
            setTargetAspectRatio(Rational(1,1))
            setTargetResolution(Size(1080,1080))
            setLensFacing(CameraX.LensFacing.BACK)
        }.build()
        val preView=Preview(previousConfig)
        preView.setOnPreviewOutputUpdateListener {
            val parent=textureView.parent as ViewGroup
            parent.removeView(textureView)
            parent.addView(textureView,0)
            updatePreview()
            textureView.surfaceTexture=it.surfaceTexture
        }
        CameraX.bindToLifecycle(this,preView,imageCapture)
    }

    private fun updatePreview() {
        val matrix=android.graphics.Matrix()

        val centerX=textureView.width/2f
        val centerY=textureView.height/2f

        val rotaion=when(textureView.display.rotation){
            Surface.ROTATION_0 -> 0
            Surface.ROTATION_90 -> 90
            Surface.ROTATION_180 -> 180
            Surface.ROTATION_270 -> 270
            else -> return
        }

        matrix.postRotate(-rotaion.toFloat(),centerX,centerY)

        textureView.setTransform(matrix)
    }
}
