// Generated by view binder compiler. Do not edit!
package com.iua.proyecto_integrador.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.iua.proyecto_integrador.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityPerfilSettingsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageButton backButton;

  @NonNull
  public final Button changePasswordButton;

  @NonNull
  public final EditText editTextTextEmailAddress;

  @NonNull
  public final ImageView imageView5;

  @NonNull
  public final Button savePerfilSettingsButton;

  @NonNull
  public final TextView textView;

  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final EditText userName;

  private ActivityPerfilSettingsBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageButton backButton, @NonNull Button changePasswordButton,
      @NonNull EditText editTextTextEmailAddress, @NonNull ImageView imageView5,
      @NonNull Button savePerfilSettingsButton, @NonNull TextView textView,
      @NonNull Toolbar toolbar, @NonNull EditText userName) {
    this.rootView = rootView;
    this.backButton = backButton;
    this.changePasswordButton = changePasswordButton;
    this.editTextTextEmailAddress = editTextTextEmailAddress;
    this.imageView5 = imageView5;
    this.savePerfilSettingsButton = savePerfilSettingsButton;
    this.textView = textView;
    this.toolbar = toolbar;
    this.userName = userName;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPerfilSettingsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPerfilSettingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_perfil_settings, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPerfilSettingsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.backButton;
      ImageButton backButton = ViewBindings.findChildViewById(rootView, id);
      if (backButton == null) {
        break missingId;
      }

      id = R.id.changePasswordButton;
      Button changePasswordButton = ViewBindings.findChildViewById(rootView, id);
      if (changePasswordButton == null) {
        break missingId;
      }

      id = R.id.editTextTextEmailAddress;
      EditText editTextTextEmailAddress = ViewBindings.findChildViewById(rootView, id);
      if (editTextTextEmailAddress == null) {
        break missingId;
      }

      id = R.id.imageView5;
      ImageView imageView5 = ViewBindings.findChildViewById(rootView, id);
      if (imageView5 == null) {
        break missingId;
      }

      id = R.id.savePerfilSettingsButton;
      Button savePerfilSettingsButton = ViewBindings.findChildViewById(rootView, id);
      if (savePerfilSettingsButton == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      id = R.id.userName;
      EditText userName = ViewBindings.findChildViewById(rootView, id);
      if (userName == null) {
        break missingId;
      }

      return new ActivityPerfilSettingsBinding((ConstraintLayout) rootView, backButton,
          changePasswordButton, editTextTextEmailAddress, imageView5, savePerfilSettingsButton,
          textView, toolbar, userName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
