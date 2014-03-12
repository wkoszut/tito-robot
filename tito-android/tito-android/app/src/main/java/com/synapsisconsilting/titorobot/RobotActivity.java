package com.synapsisconsilting.titorobot;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class RobotActivity extends ActionBarActivity implements Const, BTConnectFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robot);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new BTConnectFragment())
                    .commit();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

//
//    /**
//     * Called when the activity is first created.
//     */
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_robot);
//    }
//
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == REQUEST_ENABLE_BT) {
//            if (resultCode == Activity.RESULT_OK) {
//                BluetoothAdapter BT = BluetoothAdapter.getDefaultAdapter();
//                String address = BT.getAddress();
//                String name = BT.getName();
//                String connectedMsg = "BT is on; your device is " + name + " : " + address;
//                main.setText(connectedMsg);
//                Toast.makeText(this, connectedMsg, Toast.LENGTH_LONG).show();
//                Button discoverButton = (Button) findViewById(R.id.discoverButton);
//                discoverButton.setOnClickListener(discoverButtonHandler);
//            } else {
//                Toast.makeText(this, "Failed to enable Bluetooth adapter!", Toast.LENGTH_LONG).show();
//            }
//        } else {
//            Toast.makeText(this, "Unknown RequestCode " + requestCode, Toast.LENGTH_LONG).show();
//        }
//    }
//
//    /**
//     * When the user clicks the Discover button, get the list of paired devices
//     */
//    View.OnClickListener discoverButtonHandler = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            Log.d(TAG, "in onClick(" + v + ")");
//            // IntentFilter for found devices
//            IntentFilter foundFilter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
//            // Broadcast receiver for any matching filter
//            RobotActivity.this.registerReceiver(mReceiver, foundFilter);
//
//            IntentFilter doneFilter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
//            RobotActivity.this.registerReceiver(mReceiver, doneFilter);
//
//
//            BluetoothAdapter BT = BluetoothAdapter.getDefaultAdapter();
//
//            IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
//            registerReceiver(mReceiver, filter);
//            BT.startDiscovery();
//
//        }
//    };
//
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        unregisterReceiver(mReceiver);
//    }
//
//    /**
//     * Receiver for the BlueTooth Discovery Intent; put the paired devices
//     * into the viewable list.
//     */
//    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            String action = intent.getAction();
//            Log.d(TAG, "in onReceive, action = " + action);
//
//            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
//                BluetoothDevice btDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
//
//                if (btDevice != null && btDevice.getBondState() != BluetoothDevice.BOND_BONDED) {
//                    mNewDevicesArrayAdapter.add(btDevice.getName() + "\n" + btDevice.getAddress());
//                } else {
//                    String noDevice = getResources().getText(R.string.null_device).toString();
//                    mNewDevicesArrayAdapter.add(btDevice.getName());
//                }
//            } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
//                setProgressBarIndeterminateVisibility(false);
//                setTitle(R.string.select_device);
//                if (mNewDevicesArrayAdapter.getCount() == 0) {
//                    String noDevice = getResources().getText(R.string.none_paired).toString();
//                    mNewDevicesArrayAdapter.add(noDevice);
//                }
//            }
//        }
//    };
}
