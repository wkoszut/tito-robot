package com.synapsisconsilting.titorobot;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BTConnectFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BTConnectFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BTConnectFragment extends Fragment {

    int REQUEST_ENABLE_BT = 1;
    EditText main;
    private ArrayAdapter<String> devicesArrayAdapter;


    private OnFragmentInteractionListener mListener;

    public static BTConnectFragment newInstance() {
        BTConnectFragment fragment = new BTConnectFragment();
        return fragment;
    }

    public BTConnectFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_btconnect, container, false);

        main = (EditText) rootView.findViewById(R.id.mainTextArea);
        devicesArrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1);

        // Hook up the Discover button to its handler
        Button discover = (Button) rootView.findViewById(R.id.discoverButton);
//        discover.setOnClickListener(discoverButtonHandler);

        // Hook up the ArrayAdapter to the ListView
        ListView lv = (ListView) rootView.findViewById(R.id.pairedBtDevices);
        lv.setAdapter(devicesArrayAdapter);

        BluetoothAdapter BT = BluetoothAdapter.getDefaultAdapter();
        if (BT == null) {
            String noDevMsg = "This device does not appear to have a Bluetooth adapter, sorry";
            main.setText(noDevMsg);
            Toast.makeText(getActivity(), noDevMsg, Toast.LENGTH_LONG).show();
        } else if (!BT.isEnabled()) {
            // Ask user's permission to switch the Bluetooth adapter On.
            Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
        }


        return rootView;


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
