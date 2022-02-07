package com.example.quizapp.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.quizapp.R;
import com.example.quizapp.backend.firebase.FireBaseManager;
import com.example.quizapp.databinding.FragmentDashboardBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class DashboardFragment extends Fragment {

    DatabaseReference ref;
    Button btn;
    TextView tv;
    DatabaseReference databaseReference;
    private DashboardViewModel dashboardViewModel;
    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDashboard;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });




        return root;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv=getView().findViewById(R.id.text_dashboard);
        btn=getView().findViewById(R.id.button123);
        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EXample ex=new EXample("111", "bbb", "222");


                FirebaseDatabase db=FirebaseDatabase.getInstance();
                ref=db.getReference(EXample.class.getSimpleName());
                ref.push().setValue(ex).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(getActivity().getApplicationContext(),"succes",Toast.LENGTH_LONG).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getActivity().getApplicationContext(),"FAILED",Toast.LENGTH_LONG).show();

                    }
                });



            }
        });*/

       /* btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference= FirebaseDatabase.getInstance().getReference().child(EXample.class.getSimpleName());
//                    databaseReference= FirebaseDatabase.getInstance().getReference(folder);
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                              for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                                  EXample eXample= dataSnapshot.getValue(EXample.class);

                                  Toast.makeText(getActivity().getApplicationContext(),eXample.born,Toast.LENGTH_LONG).show();

//                                  array.add( dataSnapshot.getValue(Question.class));
//                                  Log.d("-----", (dataSnapshot.getValue(Question.class).getClass().toString()));
                            }

 ////
                         }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }


                    });
            }
        });*/


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EXDDatabasehelper exdDatabasehelper=new EXDDatabasehelper();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}