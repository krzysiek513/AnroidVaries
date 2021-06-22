package pl.studia.various;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

import static android.app.Activity.RESULT_OK;


public class FragmentA extends Fragment {

    private static final int PICK_IMAGE_REQUEST = 234;
    private static final int PICK_CAMERA_REQUEST = 567;
    View view;
    Button fragmentBtn, choseBtn, uploadBtn;
    ImageView imageView;
    EditText editText;
    private Uri image_uri;
    private StorageReference storageRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        storageRef = FirebaseStorage.getInstance().getReference();

        view = inflater.inflate(R.layout.fragment_a, container, false);
        fragmentBtn  = view.findViewById(R.id.fragmentABtn);
        editText = view.findViewById(R.id.fragmentAEt);
        imageView = view.findViewById(R.id.imageViewStorage);
        fragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("fragment A clicked");
            }
        });
        choseBtn = view.findViewById(R.id.fragmentAChoseBtn);
        choseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickFromGallery();
            }
        });
        uploadBtn = view.findViewById(R.id.fragmentAUploadBtn);
        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadFile();
            }
        });
        return view;
    }

    private void uploadFile() {
        if(image_uri != null){

            final ProgressDialog progressDialog = new ProgressDialog(getContext());
            progressDialog.setTitle("Uploading...");
            progressDialog.show();
            String name = editText.getText().toString().trim();
            StorageReference imagesRef = storageRef.child("images/" + name + ".jpg");

            imagesRef.putFile(image_uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    progressDialog.dismiss();
                    Toast.makeText(getContext(), "Image uploaded", Toast.LENGTH_LONG).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                    double progress = ( 100.0 * snapshot.getBytesTransferred()) / snapshot.getBytesTransferred();
                    progressDialog.setMessage(((int) progress) + "% Uploaded...");
                }
            });
        } else { //display toast
        }
    }

    private void pickFromGallery(){

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select an image"), PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK && data != null && data.getData() != null){
            if (requestCode == PICK_IMAGE_REQUEST){
                image_uri = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), image_uri);
                    imageView.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(getContext(), "Image error", Toast.LENGTH_LONG).show();
                }

            }
            else if (requestCode == PICK_CAMERA_REQUEST){
                imageView.setImageURI(image_uri);

            }
        }
    }
}