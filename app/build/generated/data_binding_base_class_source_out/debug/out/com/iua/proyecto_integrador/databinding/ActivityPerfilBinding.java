// Generated by view binder compiler. Do not edit!
package com.iua.proyecto_integrador.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.iua.proyecto_integrador.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityPerfilBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageButton backButton;

  @NonNull
  public final Button editUserButton;

  @NonNull
  public final TextView email;

  @NonNull
  public final Guideline guideline4;

  @NonNull
  public final ImageView imageView5;

  @NonNull
  public final TextView shoppingHistoryButton;

  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final TextView userName;

  private ActivityPerfilBinding(@NonNull ConstraintLayout rootView, @NonNull ImageButton backButton,
      @NonNull Button editUserButton, @NonNull TextView email, @NonNull Guideline guideline4,
      @NonNull ImageView imageView5, @NonNull TextView shoppingHistoryButton,
      @NonNull Toolbar toolbar, @NonNull TextView userName) {
    this.rootView = rootView;
    this.backButton = backButton;
    this.editUserButton = editUserButton;
    this.email = email;
    this.guideline4 = guideline4;
    this.imageView5 = imageView5;
    this.shoppingHistoryButton = shoppingHistoryButton;
    this.toolbar = toolbar;
    this.userName = userName;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPerfilBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPerfilBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_perfil, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPerfilBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.backButton;
      ImageButton backButton = ViewBindings.findChildViewById(rootView, id);
      if (backButton == null) {
        break missingId;
      }

      id = R.id.editUserButton;
      Button editUserButton = ViewBindings.findChildViewById(rootView, id);
      if (editUserButton == null) {
        break missingId;
      }

      id = R.id.email;
      TextView email = ViewBindings.findChildViewById(rootView, id);
      if (email == null) {
        break missingId;
      }

      id = R.id.guideline4;
      Guideline guideline4 = ViewBindings.findChildViewById(rootView, id);
      if (guideline4 == null) {
        break missingId;
      }

      id = R.id.imageView5;
      ImageView imageView5 = ViewBindings.findChildViewById(rootView, id);
      if (imageView5 == null) {
        break missingId;
      }

      id = R.id.shoppingHistoryButton;
      TextView shoppingHistoryButton = ViewBindings.findChildViewById(rootView, id);
      if (shoppingHistoryButton == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      id = R.id.userName;
      TextView userName = ViewBindings.findChildViewById(rootView, id);
      if (userName == null) {
        break missingId;
      }

      return new ActivityPerfilBinding((ConstraintLayout) rootView, backButton, editUserButton,
          email, guideline4, imageView5, shoppingHistoryButton, toolbar, userName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
