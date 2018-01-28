package com.example.twins.meeter.ui.activitiesStart;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.twins.meeter.R;
import com.example.twins.meeter.data.utils.NetworkUtils;
import com.example.twins.meeter.ui.activityMain.MainActivity;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {
    //auth
//    public static final int RC_SIGN_IN_GOOGLE = 9001;
//    public static final int RC_SIGN_IN_FACEBOOK = 64206;
//
//    private FirebaseAuth mAuth;
//    private CallbackManager callbackManager;
//    private Intent signInIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        callbackManager = CallbackManager.Factory.create();
//        LoginManager.getInstance().registerCallback(callbackManager,
//                new FacebookCallback<LoginResult>() {
//                    @Override
//                    public void onSuccess(LoginResult loginResult) {
//                        handleFacebookAccessToken(loginResult.getAccessToken());
//                    }
//
//                    @Override
//                    public void onCancel() {
//                        Toast.makeText(LoginActivity.this, "Login Cancel", Toast.LENGTH_LONG).show();
//                    }
//
//                    @Override
//                    public void onError(FacebookException exception) {
//                        Toast.makeText(LoginActivity.this, exception.getMessage(), Toast.LENGTH_LONG).show();
//                    }
//                });
//        setContentView(R.layout.activity_login);
        findViewById(R.id.facebook_sing_up_button).setOnClickListener(this);
        findViewById(R.id.google_sing_up_button).setOnClickListener(this);
//        mAuth = FirebaseAuth.getInstance();
//
//        if (!NetworkUtils.isNetworkConnected(this)) {
//            Toast.makeText(this, "not internet", Toast.LENGTH_LONG).show();
//        }
    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.facebook_sing_up_button:
////                LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("email", "public_profile", "user_friends"));
//                LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("email", "user_friends"));
//                break;
//            case R.id.google_sing_up_button:
//                signInGoogle();
//                break;
//        }
        onBackPressed();
    }
//
//    private void signInGoogle() {
//        String ID_TOKEN = "851273596948-cl5rckjsrquavpt433od49q0emrlmflu.apps.googleusercontent.com";
//
//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken(ID_TOKEN)
//                .requestEmail()
//                .build();
//        Intent signInIntent = GoogleSignIn.getClient(this, gso).getSignInIntent();
//        startActivityForResult(signInIntent, RC_SIGN_IN_GOOGLE);
//    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == RC_SIGN_IN_GOOGLE) {
//            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
//            if (result.isSuccess()) {
//                // Google Sign In was successful, authenticate with Firebase
//                GoogleSignInAccount account = result.getSignInAccount();
//                firebaseAuthWithGoogle(account);
//            } else {
//                Log.w("LoginActivity", "onActivityResult:google_failure" + data.toString());
//                Log.w("LoginActivity", "onActivityResult:google_failure" + result.toString());
//
//                // Google Sign In failed, update UI appropriately
//                Toast.makeText(this, "Google Sign In failed", Toast.LENGTH_SHORT).show();
//            }
//        } else if (requestCode == RC_SIGN_IN_FACEBOOK) {
//            callbackManager.onActivityResult(requestCode, resultCode, data);
//        }
//    }
//
//    private void firebaseAuthWithGoogle(final GoogleSignInAccount acct) {
//        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
//        if (mAuth.getCurrentUser() != null)
//            mAuth.getCurrentUser().linkWithCredential(credential)
//                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if (task.isSuccessful()) {
//                                // Sign in success, update UI with the signed-in user's information
//                                Log.d("LoginActivity", "signInWithCredential:success");
//                                FirebaseUser user = mAuth.getCurrentUser();
//                                //save data
//                                saveUser(LoginActivity.this, user);
//                            } else {
//                                // If sign in fails, display a message to the user.
//                                Log.w("LoginActivity", "signInWithCredential:failure", task.getException());
//                                Toast.makeText(LoginActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });
//    }
//
//    private void handleFacebookAccessToken(final AccessToken token) {
//        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
//        if (mAuth.getCurrentUser() != null)
//            mAuth.getCurrentUser().linkWithCredential(credential)
//                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if (task.isSuccessful()) {
//                                // Sign in success, update UI with the signed-in user's information
//                                FirebaseUser user = mAuth.getCurrentUser();
//                                //save data
//                                saveUser(LoginActivity.this, user);
//                            } else {
//                                // If sign in fails, display a message to the user.
//                                Toast.makeText(LoginActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });
//    }
//
//    public void saveUser(Context context, FirebaseUser userModel) {
//        Log.d("LoginActivity", "saveUser:getDisplayName = " + userModel.getDisplayName());
//        Log.d("LoginActivity", "saveUser:getUid = " + userModel.getUid());
//        Log.d("LoginActivity", "saveUser:getEmail = " + userModel.getEmail());
//        Log.d("LoginActivity", "saveUser:getPhotoUrl = " + userModel.getPhotoUrl());
//        showMainActivity();
//    }
//
//    private void showMainActivity() {
//        Intent intent = new Intent(this, MainActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        startActivity(intent);
//    }
//
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d("LoginActivity", "onConnectionFailed, connectionResult = " + connectionResult.toString());
    }

}
