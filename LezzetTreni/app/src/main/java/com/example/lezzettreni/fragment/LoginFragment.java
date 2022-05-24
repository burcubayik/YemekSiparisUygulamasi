package com.example.lezzettreni.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lezzettreni.R;
import com.example.lezzettreni.databinding.FragmentLoginBinding;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

public class LoginFragment extends Fragment {
    private FragmentLoginBinding design;
    private FirebaseAuth firebaseAuth;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        design = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false);
        design.setLoginFragment(this);
        design.setToolbarLogin("Giriş");

        return design.getRoot();
    }
    public void buttonLoginClick(){
        String email = design.editTextEmail.getText().toString();
        String password = design.editTextPassword.getText().toString();
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnSuccessListener(authResult -> {
            Snackbar.make(design.getRoot(),"Giriş Başarılı!",Snackbar.LENGTH_SHORT).show();
        });



    }
}