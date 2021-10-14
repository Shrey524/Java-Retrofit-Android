package com.example.food.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food.Activities.MainActivity;
import com.example.food.Adapter.SavedRecyclerViewAdapter;
import com.example.food.R;

public class SavedItemFragment extends Fragment {

    public SavedItemFragment() {
    }

    public static SavedItemFragment newInstance() {
        SavedItemFragment fragment = new SavedItemFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_saved_item_list, container, false);
        RecyclerView savedList = view.findViewById(R.id.list);
        SavedRecyclerViewAdapter adapter = new SavedRecyclerViewAdapter(((MainActivity)getActivity()).saved_list, requireContext());
        savedList.setLayoutManager(new LinearLayoutManager(requireContext()));
        savedList.setAdapter(adapter);
        return view;
    }
}