package com.bignerdranch.android.liveschedule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.bignerdranch.android.liveschedule.Models.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Button buttonSignIn, buttonRegister;
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;

    RelativeLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSignIn = findViewById(R.id.button_sign_in);
        buttonRegister = findViewById(R.id.button_register);
        root = findViewById(R.id.root_element);

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("users");

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRegisterWindow();
            }

        });
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSignInWindow();
            }

        });

        if (auth.getCurrentUser() != null) {
            String id = auth.getUid();
            Intent intent = new Intent(MainActivity.this, TasksActivity.class);
            DatabaseReference reference;
            reference = FirebaseDatabase.getInstance().getReference();
            User user = new User();
           //  user.
            //  user.setName();
            intent.putExtra("name", user.getFirstname());

            startActivity(intent);
        }
    }

    private void showSignInWindow() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Войти в систему");
        dialog.setMessage("Введите все данные для входа");

        LayoutInflater inflater = LayoutInflater.from(this);
        View signInWindow = inflater.inflate(R.layout.sign_in_window, null);
        dialog.setView(signInWindow);

        final TextInputEditText email = signInWindow.findViewById(R.id.emailField);
        final TextInputEditText password = signInWindow.findViewById(R.id.passwordField);

        dialog.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialog.setPositiveButton("Войти", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (TextUtils.isEmpty(email.getText().toString())) {
                    Snackbar.make(root, "Введите логин", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password.getText().toString())) {
                    Snackbar.make(root, "Введите пароль", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                auth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            String id = auth.getUid();
                            Intent intent = new Intent(MainActivity.this, TasksActivity.class);
                           // User user = new User();
                          //  user.setName();
                            intent.putExtra("id", id);
                            startActivity(intent);

                            finish();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Snackbar.make(root, "Ошибка авторизации", Snackbar.LENGTH_SHORT).show();
                        }
                    });

            }
        });

        dialog.show();
    }

    private void showRegisterWindow() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Зарегистрироваться");
        dialog.setMessage("Введите все данные для регистрации");

        LayoutInflater inflater = LayoutInflater.from(this);
        View registerWindow = inflater.inflate(R.layout.register_window, null);
        dialog.setView(registerWindow);

        final TextInputEditText firstname = registerWindow.findViewById(R.id.firstnameField);
        final TextInputEditText secondname = registerWindow.findViewById(R.id.secondnameField);
        final TextInputEditText lastname = registerWindow.findViewById(R.id.lastnameField);
        final TextInputEditText job = registerWindow.findViewById(R.id.jobField);
        //ЛОГИН
        final TextInputEditText email = registerWindow.findViewById(R.id.emailField);
        final TextInputEditText password = registerWindow.findViewById(R.id.passwordField);

        dialog.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialog.setPositiveButton("Зарегистрироваться", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (TextUtils.isEmpty(firstname.getText().toString())) {
                   Snackbar.make(root, "Введите вашу фамилию", Snackbar.LENGTH_SHORT).show();
                   return;
                }
                if (TextUtils.isEmpty(secondname.getText().toString())) {
                    Snackbar.make(root, "Введите ваше имя", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(email.getText().toString())) {
                    Snackbar.make(root, "Введите адрес электронной почты", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password.getText().toString())) {
                    Snackbar.make(root, "Введите пароль", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if (password.getText().toString().length() < 6) {
                    Snackbar.make(root, "Пароль должен содержать более 6 символов", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                auth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            User user = new User();
                            user.setFirstname(firstname.getText().toString());
                            user.setSecondname(secondname.getText().toString());
                            user.setLastname(lastname.getText().toString());
                           // user.setJob(job.getText().toString());
                            user.setEmail(email.getText().toString());
                            user.setPassword(password.getText().toString());

                            users.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Snackbar.make(root, "Пользователь добавлен", Snackbar.LENGTH_SHORT).show();
                                    }
                                });
                        }
                    })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Snackbar.make(root, "Ошибка регистрации" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
                    }
                });
            }
        });

        dialog.show();
    }
}
