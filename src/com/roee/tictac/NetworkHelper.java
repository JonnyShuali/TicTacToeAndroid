package com.roee.tictac;

import java.io.IOException;
import java.net.ServerSocket;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdManager.RegistrationListener;
import android.net.nsd.NsdServiceInfo;

public class NetworkHelper {
	ServerSocket mServer;
	int mPort;

	public NetworkHelper() throws IOException {
		mServer = new ServerSocket(0);
		mPort = mServer.getLocalPort();
	}

	private class NsdHelper {
		NsdManager mNsdManager;
		NsdServiceInfo serviceInfo;
		NsdManager.RegistrationListener mRegistrationListener;
	    public NsdHelper(Context context) {
	    //    mContext = context;
	        mNsdManager = (NsdManager) context.getSystemService(Context.NSD_SERVICE);
	    }

		public void RegisterService() {
			// Registering new NDS service
			serviceInfo = new NsdServiceInfo();
			// Calling it the same as bluetooth name (human friendly)
			serviceInfo.setServiceName(BluetoothAdapter.getDefaultAdapter()
					.getName());
			serviceInfo.setServiceType("_RoyTicTac.tcp.");
			serviceInfo.setPort(mPort);

		//	mNsdManager = (NsdManager) Context.getSystemService(Context.NSD_SERVICE);

			mNsdManager.registerService(serviceInfo,
					NsdManager.PROTOCOL_DNS_SD, mRegistrationListener);
		}

				}
		
	}

