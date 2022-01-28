package com.example.quizapp.ui.home;

import android.content.Context;
import android.content.Intent;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.quizapp.R;
import com.example.quizapp.backend.data.DATA;
import com.example.quizapp.databinding.FragmentHomeBinding;
import com.example.quizapp.ui.user.QuizDashboard;
import com.example.quizapp.ui.user.QuizManager;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    LinearLayout home_list;
    CardView cardView1;
    View v;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


         home_list=view.findViewById(R.id.home_fragment_linear);
//         cardView1=view.findViewById(R.id.subject_cardview);
         home_list.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent=new Intent(getContext(), QuizManager.class);
//                 getActivity().finish();
                 startActivity(intent);
             }
         });




    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}