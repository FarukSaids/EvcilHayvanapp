package com.example.evcilhayvanapp.view

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.evcilhayvanapp.databinding.ActivityUploadBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage
import java.util.UUID

class UploadActivity : AppCompatActivity() {
    private lateinit var binding :ActivityUploadBinding
    private lateinit var  activityResultLauncher : ActivityResultLauncher<Intent>
    private lateinit var permissionLauncher : ActivityResultLauncher<String>
    var selectedPicture : Uri? = null
    private lateinit var auth : FirebaseAuth
    private lateinit var firestore : FirebaseFirestore
    private lateinit var storage :FirebaseStorage


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding= ActivityUploadBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
        registerLauncher()
        auth = Firebase.auth
        firestore=Firebase.firestore
        storage = Firebase.storage
    }

    fun upload(view : View)
    {
        val uuid=UUID.randomUUID()
        val imagename ="$uuid.jpg"
        val reference =storage.reference // boşluğu veriyor upload file da
        val imageReference = reference.child("images/").child(imagename)
        if(selectedPicture != null){
            imageReference.putFile(selectedPicture!!).addOnSuccessListener{
            //downloadurl
                val uploadPictureReference = storage.reference.child("images").child(imagename)
                uploadPictureReference.downloadUrl.addOnSuccessListener {
                    val downloadUrl= it.toString()
                    val postmap = hashMapOf<String,Any>()
                    postmap.put("downloadUrl",downloadUrl)
                    postmap.put("userEmail",auth.currentUser!!.email!!)
                    postmap.put("comment",binding.commentText.text.toString())
                    postmap.put("date",Timestamp.now())
                    firestore.collection("Posts").add(postmap).addOnSuccessListener {
                    finish()
                    }.addOnFailureListener{
                        Toast.makeText(this@UploadActivity, it.localizedMessage, Toast.LENGTH_SHORT).show()
                    }
                }

            }.addOnFailureListener{
                Toast.makeText(this,it.localizedMessage,Toast.LENGTH_LONG).show()

            }
        }

    }

    fun selectImage(view : View)
    {
    if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,android.Manifest.permission.READ_EXTERNAL_STORAGE)){
            Snackbar.make(view,"Galeri için izin gereklidir",Snackbar.LENGTH_INDEFINITE).setAction("izin ver"){
                //request permission
                permissionLauncher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
            }.show()
        }else{
            //request permission
            permissionLauncher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
        }
    }else{
        val intentToGallery = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        activityResultLauncher.launch(intentToGallery)
        // start activity for result
    }
    }

    private fun registerLauncher()
    {

        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult(),
            ActivityResultCallback {result ->
            if(result.resultCode == RESULT_OK){
                val intentFromResult = result.data
                if(intentFromResult != null){
                   selectedPicture = intentFromResult.data
                    selectedPicture.let {
                        binding.imageView.setImageURI(it)
                    }
                }
            }

            } )
                permissionLauncher  = registerForActivityResult(ActivityResultContracts.RequestPermission())
                {result ->
                      if(result)
                        {
                            val intentToGallery = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                            activityResultLauncher.launch(intentToGallery)
                         }  else{
                                    Toast.makeText(this@UploadActivity, "İzin Gerekli", Toast.LENGTH_SHORT).show()

                               }
                }

    }
}