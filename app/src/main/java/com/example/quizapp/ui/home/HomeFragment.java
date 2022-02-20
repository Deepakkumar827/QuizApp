package com.example.quizapp.ui.home;

import android.content.Context;
import android.content.Intent;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.example.quizapp.MainActivity;
import com.example.quizapp.R;
import com.example.quizapp.backend.data.DATA;
import com.example.quizapp.backend.data.Dir;
import com.example.quizapp.backend.data.Trie;
import com.example.quizapp.databinding.FragmentHomeBinding;
import com.example.quizapp.ui.user.QuizDashboard;
import com.example.quizapp.ui.user.QuizManager;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    LinearLayout home_list;
    CardView cardView1;
    View v;
    Spinner standard;
    Trie subjectTrie;
    LinearLayout subject_card_list_linearLayout;
//    ViewPager viewPager;
    ArrayList<Trie> viewpager_trie_arraylist;
    MyAdapter myAdapter;
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
        standard = getView().findViewById(R.id.standard);
//        viewPager = view.findViewById(R.id.view_pager);

        subject_card_list_linearLayout=getView().findViewById(R.id.subject_card_list_linearLayout);

        for(int i=0; i<11; i++){
            LinearLayout cardView=getView().findViewById(R.id.subject_cardview);
            if(cardView.getParent() != null) {
                ((ViewGroup)cardView.getParent()).removeView(cardView); // <- fix
            }
            subject_card_list_linearLayout.addView(cardView);


        }


        binding.testbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), QuizManager.class));
            }
        });
        ArrayList<String> list_std=new ArrayList<>();
        for(Trie std: Dir.getInstanceOfDir().child.get(0).child ){
            list_std.add(std.name);

//            viewpager_trie_arraylist=new ArrayList<>();
//            viewpager_trie_arraylist.add(std);
        }
       /* myAdapter=new MyAdapter(getContext(), viewpager_trie_arraylist);
        viewPager.setAdapter(myAdapter);
        viewPager.setPadding(100, 0 , 100, 0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

*/
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item,list_std );
        standard.setAdapter(adapter1);
        standard.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                subjectTrie=getTrieSubjectList();
                Log.w("asdf1--=-", subjectTrie.name);

                for(Trie t:subjectTrie.child){
                    Log.w("asdf2=-", t.name);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        home_list=view.findViewById(R.id.home_fragment_linear);
        home_list=view.findViewById(R.id.home_fragment_linear);
        home_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), QuizManager.class);
                startActivity(intent);
            }
        });




    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    ArrayList<String> getSubjectList(){
        int std_selected_index=standard.getSelectedItemPosition();
        ArrayList<String> list_sub=new ArrayList<>();
        for(Trie std: Dir.getInstanceOfDir().child.get(0).child.get(std_selected_index).child ){
            list_sub.add(std.name);
        }
        return list_sub;
    }
    Trie getTrieSubjectList(){
        int std_selected_index=standard.getSelectedItemPosition();
        ArrayList<Trie> list_Trie_sub=new ArrayList<>();
//        TODO: use this list_Trie_sub.addAll(Dir.getInstanceOfDir().child.get(0).child.get(std_selected_index).child);


        return Dir.getInstanceOfDir().child.get(0).child.get(std_selected_index);
    }

    /*ArrayList<String> getChapter(){
        int std_selected_index=standard.getSelectedItemPosition();

        int sub_selected_index=subject.getSelectedItemPosition();
        ArrayList<String> list_chapter=new ArrayList<>();
        for(Trie cht: Dir.getInstanceOfDir().child.get(0).child.get(std_selected_index).child.get(sub_selected_index).child ){
            list_chapter.add(cht.name);
        }
        return list_chapter;



    }*/



}